package com.example.orderdemo.controller;

import com.example.orderdemo.model.dto.OrderDto;
import com.example.orderdemo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> getOrderList() {
        return orderService.getOrderList();
    }

    @GetMapping("/{userId}")
    public List<OrderDto> getOrderListByUserId(@PathVariable UUID userId) {
        return orderService.getOrderListByUserId(userId);
    }

    @PostMapping
    public void createOrder(OrderDto orderDto) {
        orderService.createOrder(orderDto);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable UUID orderId) {
        orderService.deleteOrder(orderId);
    }

    @PutMapping("/{orderId}")
    public OrderDto updateOrder(OrderDto orderDto, @PathVariable UUID orderId) {
        return orderService.updateOrder(orderDto, orderId);
    }

    @GetMapping("/{orderId}/checkout")
    public OrderDto checkoutOrder(@PathVariable UUID orderId) {
        return orderService.checkoutOrder(orderId);
    }
}
