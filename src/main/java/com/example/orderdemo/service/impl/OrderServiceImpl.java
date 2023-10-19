package com.example.orderdemo.service.impl;

import com.example.orderdemo.mapper.OrderMapper;
import com.example.orderdemo.model.dto.OrderDto;
import com.example.orderdemo.model.entity.Order;
import com.example.orderdemo.model.enums.Status;
import com.example.orderdemo.repository.OrderRepository;
import com.example.orderdemo.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    private static final String MESSAGE = "Entity is not presented.";


    @Override
    public void createOrder(OrderDto order) {
        OrderDto newOrder = OrderDto.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .items(order.getItems())
                .creationDate(order.getCreationDate())
                .status(Status.PENDING)
                .build();
        orderRepository.save(orderMapper.mapToOrder(newOrder));

        executeScheduledDeletion(order);
    }

    private void executeScheduledDeletion(OrderDto order) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        long difference = ChronoUnit.MINUTES.between(order.getCreationDate(), LocalDateTime.now());

        Runnable deletion = () -> {
            if (Objects.equals(order.getStatus(), Status.PENDING)
                    && difference >= 10) {
                orderRepository.deleteById(order.getId());
            }
        };
        ScheduledFuture<?> deletionHandler = scheduler
                .schedule(deletion, 10, TimeUnit.MINUTES);

        try {
            log.log(Level.DEBUG, "Successfully executed deletion process: " + deletionHandler.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        scheduler.shutdown();
    }

    @Override
    public List<OrderDto> getOrderList() {
        if (orderRepository.findAll().isEmpty()) {
            throw new ResourceNotFoundException(MESSAGE);
        }
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrderListByUserId(UUID userId) {
        if (Objects.equals(orderRepository.findOrdersByUserId(userId), null)) {
            throw new ResourceNotFoundException(MESSAGE);
        }
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
        Order currentOrder = orderRepository.findById(orderId)
                .orElseThrow(
                        () -> new ResourceNotFoundException(MESSAGE)
                );
        orderMapper.updateFromOrderDto(orderDto, currentOrder);
        orderRepository.save(currentOrder);

        return orderMapper.mapToOrderDto(currentOrder);
    }

    @Override
    public OrderDto checkoutOrder(UUID orderId) {
        OrderDto currentOrder = orderRepository.findById(orderId)
                .map(orderMapper::mapToOrderDto)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE)
                );

        OrderDto processedOrder = buildOrder(currentOrder);
        orderRepository.save(orderMapper.mapToOrder(processedOrder));

        return processedOrder;
    }

    private OrderDto buildOrder(OrderDto currentOrder) {
        return OrderDto.builder()
                .id(currentOrder.getId())
                .userId(currentOrder.getUserId())
                .items(currentOrder.getItems())
                .creationDate(currentOrder.getCreationDate())
                .status(Status.SUCCESS)
                .build();
    }


}
