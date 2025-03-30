package com.example.album.service.impl;

import com.example.album.exception.AlbumNotFoundException;
import com.example.album.model.Album;
import com.example.album.model.Order;
import com.example.album.model.User;
import com.example.album.repository.AlbumRepository;
import com.example.album.repository.OrderRepository;
import com.example.album.repository.UserRepository;
import com.example.album.service.OrderService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final AlbumRepository albumRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(AlbumRepository albumRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.albumRepository = albumRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addAlbumToOrder(Long albumId) throws AlbumNotFoundException {
        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new AlbumNotFoundException("album not found"));
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByUsername(email).get();

        Optional<Order> optionalOrder = orderRepository.findByUser(user);
        Order order;

        // create new order if order not exists
        if(optionalOrder.isEmpty()) {
            order = new Order();
            order.setUser(user);
            order = orderRepository.save(order);
        }else {
            order = optionalOrder.get();
        }

        order.addAlbum(album);
    }
}
