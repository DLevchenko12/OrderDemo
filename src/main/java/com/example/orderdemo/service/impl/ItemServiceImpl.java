package com.example.orderdemo.service.impl;

import com.example.orderdemo.mapper.ItemMapper;
import com.example.orderdemo.model.dto.ItemDto;
import com.example.orderdemo.repository.ItemRepository;
import com.example.orderdemo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public void createItem(ItemDto item) {
        itemRepository.save(itemMapper.mapToItem(item));
    }

    @Override
    public List<ItemDto> getItemList() {
        return itemRepository.findAll()
                .stream()
                .map(itemMapper::mapToItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDto getItemById(UUID id) {
        return itemMapper.mapToItemDto(itemRepository.findById(id));
    }

    @Override
    public void deleteItemById(UUID id) {
        itemRepository.deleteById(id);
    }
}
