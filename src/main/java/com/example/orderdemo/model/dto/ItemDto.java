package com.example.orderdemo.model.dto;

import com.example.orderdemo.model.entity.Order;
import io.swagger.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * A DTO for the {@link com.example.orderdemo.model.entity.Item} entity
 */
@Data
public class ItemDto {

    @Schema(name = "Item id",
            description = "Item id required for deletion and search operations")
    private final UUID id;

    private final String name;

    private final BigDecimal price;

    private final Order order;
}