package com.example.album.repository;

import com.example.album.model.Album;
import com.example.album.model.OrderItem;
import com.example.album.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
    List<OrderItem> findByUser(User user);
    Optional<OrderItem> findByUserAndAlbum(User user, Album album);
}
