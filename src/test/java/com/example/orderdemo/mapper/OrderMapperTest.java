package com.example.orderdemo.mapper;

import com.example.orderdemo.model.dto.OrderDto;
import com.example.orderdemo.model.entity.Order;
import com.example.orderdemo.model.enums.Status;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OrderMapperTest {

    private final OrderMapper orderMapper;

    OrderMapperTest() {
        orderMapper = new OrderMapperImpl();
    }

    @Test
    void mapToOrderDto_correct() {
        UUID randomId = UUID.randomUUID();

        Order order = new Order(randomId, null, null, null, Status.DECLINED);

        OrderDto expected = OrderDto.builder()
                .id(randomId)
                .status(Status.DECLINED)
                .build();

        OrderDto actual = orderMapper.mapToOrderDto(order);

        assertEquals(actual.getId(), expected.getId());
        assertEquals(actual.getStatus(), expected.getStatus());
        assertNull(actual.getUserId());
        assertNull(actual.getItems());
        assertNull(actual.getCreationDate());
    }

    @Test
    void mapToOrder_correct() {
        UUID randomId = UUID.randomUUID();

        OrderDto order = OrderDto.builder()
                .id(randomId)
                .status(Status.DECLINED)
                .build();

        Order expected = new Order(randomId, null, null, null, Status.DECLINED);

        Order actual = orderMapper.mapToOrder(order);

        assertEquals(actual.getId(), expected.getId());
        assertEquals(actual.getStatus(), expected.getStatus());
        assertNull(actual.getUser());
        assertNull(actual.getItems());
        assertNull(actual.getCreationDate());
    }
}
