package com.example.album.controller;

import com.example.album.dto.OrderDto;
import com.example.album.exception.AlbumNotFoundException;

import com.example.album.service.OrderService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create-order/{id}")
    public String createNewOrder (@PathVariable("id") String id, @RequestParam("quantity") String quantity) throws AlbumNotFoundException {
        Long longId = Long.parseLong(id);
        int intQuantity = Integer.parseInt(quantity);

        orderService.addAlbumToOrder(longId,intQuantity);
        return "redirect:/order";
    }

    @GetMapping
    public String showOrder (Model model) {
        OrderDto order = orderService.getUserOrder();
        model.addAttribute("order",order);
        return "order";
    }

    @PostMapping("/pay-order")
    public String payOrder() {
        System.out.println("run");
        orderService.payOrder();

        return "redirect:/";
    }
}
