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

/**
 * A DTO for the {@link com.example.orderdemo.model.entity.User} entity
 */
@Data
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    @JsonProperty("id")
    private final Long id;

    @JsonProperty("role")
    private final Role role;

    @JsonProperty("order_list")
    private final List<Order> orders;
}