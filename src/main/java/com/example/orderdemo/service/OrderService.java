package com.example.orderdemo.service;

import com.example.orderdemo.model.dto.OrderDto;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    void createOrder(OrderDto order);

    List<OrderDto> getOrderList();

    List<OrderDto> getOrderListByUserId(UUID userId);

    OrderDto getOrderById(UUID orderId);

    void deleteOrder(UUID orderId);

    OrderDto updateOrder(OrderDto orderDto, UUID orderId);

    OrderDto checkoutOrder(UUID orderId);

}
