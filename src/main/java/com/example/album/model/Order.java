package com.example.album.model;

import com.example.album.dto.OrderDto;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    List<OrderItem> albums = new ArrayList<>();

    private Double totalPrice;

    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();


    public void addAlbum(OrderItem album) {
        albums.add(album);
    }

    public OrderDto getOrderDto () {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(id);
        orderDto.setAlbums(albums);
        orderDto.setUser(user);
        orderDto.setCreatedAt(createdAt);
        orderDto.setTotalPrice(totalPrice);
        return orderDto;
    }

    public Order() {
    }

    public Order(Long id, User user, List<OrderItem> albums, Double totalPrice, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.albums = albums;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getAlbums() {
        return albums;
    }

    public void setAlbums(List<OrderItem> albums) {
        this.albums = albums;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}