package com.example.orderdemo.model.dto;

import com.example.orderdemo.model.entity.Item;
import com.example.orderdemo.model.entity.User;
import com.example.orderdemo.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * A DTO for the {@link com.example.orderdemo.model.entity.Order} entity
 */
@Data
public class OrderDto  {
    private final UUID id;

    @JsonProperty("user_id")
    private final User user;

    @JsonProperty("item_list")
    private final List<Item> items;

    @JsonProperty("creation_date")
    private final LocalDateTime creationDate;

    private final Status status;
}
