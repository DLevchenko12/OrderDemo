package com.example.orderdemo.model.dto;

import com.example.orderdemo.model.entity.Item;
import com.example.orderdemo.model.entity.User;
import com.example.orderdemo.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link com.example.orderdemo.model.entity.Order} entity
 */
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderDto implements Serializable {
    @JsonProperty("id")
    private final Long id;

    @JsonProperty("user_id")
    private final User user;

    @JsonProperty("item_list")
    private final List<Item> items;

    @JsonProperty("creation_date")
    private final LocalDateTime creationDate;

    @JsonProperty("status")
    private final Status status;
}