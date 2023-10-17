package com.example.orderdemo.controller;

import com.example.orderdemo.model.dto.ItemDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/items")
public interface ItemController {
    @GetMapping
    List<ItemDto> getAllItems();

    @PostMapping("/{id}")
    ResponseEntity<ItemDto> createItem(
            @PathVariable Long id,
            ItemDto itemDto,
            @RequestHeader(value = "X-Credential-Sub") Long userId);
}
