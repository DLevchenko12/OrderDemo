package com.example.orderdemo.model.dto.mapper;

import com.example.orderdemo.model.dto.OrderDto;
import com.example.orderdemo.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

    Order mapToOrder(OrderDto orderDto);

    OrderDto mapToOrderDto(Order order);

}
