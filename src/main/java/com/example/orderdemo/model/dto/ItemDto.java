package com.example.orderdemo.model.dto;

import com.example.orderdemo.model.entity.Item;
import com.example.orderdemo.model.entity.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.example.orderdemo.model.entity.Item} entity
 */
@Data
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class ItemDto implements Serializable {
    @JsonProperty("id")
    private final Long id;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("price")
    private final BigDecimal price;

    private final Order order;
}