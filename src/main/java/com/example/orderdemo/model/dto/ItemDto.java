package com.example.orderdemo.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * A DTO for the {@link com.example.orderdemo.model.entity.Item} entity
 */
@Data
public class ItemDto {
    private final UUID id;

    private final String name;

    private final BigDecimal price;
}
