package com.example.orderdemo.service;

import com.example.orderdemo.model.dto.ItemDto;

import java.util.List;

public interface ItemService {

    void createItem(ItemDto item);

    List<ItemDto> getItemList();

    ItemDto getItemById(Long id);

    void deleteItemById(Long id);

}
