package com.example.orderdemo.model.dto;

import com.example.orderdemo.model.entity.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * A DTO for the {@link com.example.orderdemo.model.entity.Item} entity
 */
@Data
public class ItemDto {

    @Schema(name = "item_id", description = "Unique identifier for performing operations.")
    private final UUID id;

    @Schema(name = "item_name", description = "Name of a product.")
    @JsonProperty("item_name")
    private final String name;

    @Schema(name = "price", description = "Item price.")
    private final BigDecimal price;

    @Schema(name = "order", description = "Orders owning this item.")
    private final Order order;
}
