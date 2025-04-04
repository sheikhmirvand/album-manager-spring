package com.example.album.service.impl;

import com.example.album.dto.OrderDto;
import com.example.album.exception.AlbumNotFoundException;
import com.example.album.model.*;
import com.example.album.repository.*;
import com.example.album.service.OrderService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final AlbumRepository albumRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final PaidOrderRepository paidOrderRepository;

    public OrderServiceImpl(AlbumRepository albumRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository, PaidOrderRepository paidOrderRepository) {
        this.albumRepository = albumRepository;
        this.orderRepository = orderRepository;
        this.paidOrderRepository = paidOrderRepository;

        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void addAlbumToOrder(Long albumId,int quantity) throws AlbumNotFoundException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Order order = orderRepository.findByUser(user).get();

        Album album = albumRepository.findById(albumId)
                .orElseThrow(()->new AlbumNotFoundException("album not found"));

        OrderItem orderItem = orderItemRepository.findByUserAndAlbum(user,album)
                .orElse(new OrderItem());

        orderItem.setAlbum(album);
        orderItem.setUser(user);
        orderItem.setQuantity(quantity);
        order.addAlbum(orderItem);
        orderItemRepository.save(orderItem);
    }

    @Override
    public OrderDto getUserOrder() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Order order = orderRepository.findByUser(user).get();
        order.setTotalPrice(order.getAlbums().stream().mapToDouble((item) -> item.getQuantity() * item.getAlbum().getPrice()).sum());
        orderRepository.save(order);
        return order.getOrderDto();
    }

    @Override
    public void payOrder() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Order order = orderRepository.findByUser(user).orElseThrow(()->new RuntimeException("order not found"));
        System.out.println(order.getTotalPrice());


        PaidOrder paidOrder = new PaidOrder();
        paidOrder.setOrderFormat(user.getUsername()+ " " + order.getTotalPrice());

        paidOrderRepository.save(paidOrder);

        // delete user order
        orderRepository.deleteById(order.getId());

        // create new order
        Order newOrder = new Order();
        newOrder.setUser(user);
        orderRepository.save(newOrder);

    }
}
