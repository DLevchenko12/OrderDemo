package com.example.orderdemo.service.impl;

import com.example.orderdemo.mapper.OrderMapper;
import com.example.orderdemo.model.dto.OrderDto;
import com.example.orderdemo.model.entity.Order;
import com.example.orderdemo.repository.OrderRepository;
import com.example.orderdemo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    private static final String MESSAGE = "Entity is not presented: ";


    @Override
    public void createOrder(OrderDto order) {
        orderRepository.save(orderMapper.mapToOrder(order));
    }

    @Override
    public List<OrderDto> getOrderList() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrderListByUserId(UUID userId) {
        return orderRepository.findOrdersByUserId(userId)
                .stream()
                .map(orderMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(UUID orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::mapToOrderDto)
                .orElse(null);
    }

    @Override
    public void deleteOrder(UUID orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, UUID orderId) {
        Order currentOrder = orderRepository.findById(orderId).orElseThrow(
                () -> new EntityNotFoundException(MESSAGE + orderId)
        );
        orderMapper.updateFromOrderDto(orderDto, currentOrder);
        orderRepository.save(currentOrder);

        return orderMapper.mapToOrderDto(currentOrder);
    }


}
