package com.example.orderdemo.service;

import com.example.orderdemo.model.dto.ItemDto;

import java.util.List;
import java.util.UUID;

public interface ItemService {

    void createItem(ItemDto item);

    List<ItemDto> getItemList();

    ItemDto getItemById(UUID id);

    void deleteItemById(UUID id);

}
