package com.example.album.repository;

import com.example.album.model.Order;
import com.example.album.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Optional<Order> findByUser(User user);
}
