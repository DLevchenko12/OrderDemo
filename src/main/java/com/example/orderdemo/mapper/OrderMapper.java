package com.example.orderdemo.mapper;

import com.example.orderdemo.model.dto.OrderDto;
import com.example.orderdemo.model.entity.Order;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

    Order mapToOrder(OrderDto orderDto);

    OrderDto mapToOrderDto(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromOrderDto(OrderDto orderDto, @MappingTarget Order order);

}
