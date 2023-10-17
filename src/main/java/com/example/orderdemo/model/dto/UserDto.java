package com.example.orderdemo.model.dto;

import com.example.orderdemo.model.entity.Order;
import com.example.orderdemo.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * A DTO for the {@link com.example.orderdemo.model.entity.User} entity
 */
@Data
public class UserDto {
    private final UUID id;

    private final Role role;

    @JsonProperty("order_list")
    private final List<Order> orders;
}