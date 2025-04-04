package com.example.album.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
public class PaidOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderFormat;

    @CreatedDate
    private LocalDateTime localDateTime = LocalDateTime.now();

    public PaidOrder() {
    }

    public PaidOrder(Long id, String orderFormat, LocalDateTime localDateTime) {
        this.id = id;
        this.orderFormat = orderFormat;
        this.localDateTime = localDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderFormat() {
        return orderFormat;
    }

    public void setOrderFormat(String orderFormat) {
        this.orderFormat = orderFormat;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
