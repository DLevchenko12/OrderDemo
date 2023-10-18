package com.example.orderdemo.controller;

import com.example.orderdemo.model.dto.ItemDto;
import com.example.orderdemo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<ItemDto> getItemList() {
        return itemService.getItemList();
    }

    @GetMapping("/{id}")
    public ItemDto getItemById(@PathVariable UUID id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    public void createItem(ItemDto item) {
        itemService.createItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable UUID id) {
        itemService.deleteItemById(id);
    }
}
