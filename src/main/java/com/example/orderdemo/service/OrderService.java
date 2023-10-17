package com.example.orderdemo.service;

import com.example.orderdemo.model.dto.OrderDto;

import java.util.List;

public interface OrderService {

    void createOrder(OrderDto order);

    List<OrderDto> getOrderList();

    List<OrderDto> getOrderListByUserId(Long userId);

    OrderDto getOrderById(Long orderId);

    void deleteOrder(Long orderId);

}
