package com.example.album.dto;

import com.example.album.model.Album;
import com.example.album.model.OrderItem;
import com.example.album.model.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private Long id;

    private User user;

    List<OrderItem> albums = new ArrayList<>();

    private Double totalPrice;

    private LocalDateTime createdAt ;

    public OrderDto() {
    }

    public OrderDto(Long id, User user, List<OrderItem> albums, Double totalPrice, LocalDateTime createdAt) {
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
