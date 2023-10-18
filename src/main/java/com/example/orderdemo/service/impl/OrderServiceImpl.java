package com.example.orderdemo.service.impl;

import com.example.orderdemo.mapper.OrderMapper;
import com.example.orderdemo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;


}
