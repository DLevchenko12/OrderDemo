package com.example.orderdemo.model.dto;

import com.example.orderdemo.model.entity.Item;
import com.example.orderdemo.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * A DTO for the {@link com.example.orderdemo.model.entity.Order} entity
 */
@Data
@Builder
public class OrderDto {

    @Schema(name = "order_id", description = "Unique identifier for performing operations.")
    private final UUID id;

    @Schema(name = "user_id", description = "Unique identifier of owner of the order.")
    @JsonProperty("user_id")
    private final UUID userId;

    @Schema(name = "item_list", description = "Items related to the order.")
    @JsonProperty("item_list")
    private final List<Item> items;

    @Schema(name = "creation_date", description = "Order creation date.")
    @JsonProperty("creation_date")
    private final LocalDateTime creationDate;

    @Schema(name = "status", description = "Order processing status.")
    private final Status status;
}
