package com.example.orderdemo.model.dto;

import com.example.orderdemo.model.entity.Order;
import com.example.orderdemo.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * A DTO for the {@link com.example.orderdemo.model.entity.User} entity
 */
@Data
public class UserDto {

    @Schema(name = "user_id", description = "Unique identifier for performing operations.")
    private final UUID id;

    @Schema(name = "role", description = "User role for granting authorities.")
    private final Role role;

    @Schema(name = "order_list", description = "Order list for the given user.")
    @JsonProperty("order_list")
    private final List<Order> orders;
}
