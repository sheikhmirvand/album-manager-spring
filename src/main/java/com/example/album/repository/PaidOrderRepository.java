package com.example.album.repository;

import com.example.album.model.PaidOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaidOrderRepository extends JpaRepository<PaidOrder,Long> {
}
