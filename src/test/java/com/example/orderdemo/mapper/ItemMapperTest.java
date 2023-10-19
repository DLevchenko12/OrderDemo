package com.example.orderdemo.mapper;

import com.example.orderdemo.model.dto.ItemDto;
import com.example.orderdemo.model.entity.Item;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemMapperTest {
    private final ItemMapper itemMapper;

    ItemMapperTest() {
        itemMapper = new ItemMapperImpl();
    }

    @Test
    void mapItemToItemDto_correct() {
        UUID randomId = UUID.randomUUID();

        Item item = new Item(randomId, "Iphone 12", BigDecimal.valueOf(1199.00), null);

        ItemDto expected = new ItemDto(randomId, "Iphone 12", BigDecimal.valueOf(1199.00), null);

        ItemDto actual = itemMapper.mapToItemDto(item);

        assertEquals(actual.getId(), expected.getId());
        assertEquals(actual.getName(), expected.getName());
        assertEquals(actual.getPrice(), expected.getPrice());
    }

    @Test
    void mapToItem_correct() {
        UUID randomId = UUID.randomUUID();

        ItemDto item = new ItemDto(randomId, "Iphone 12", BigDecimal.valueOf(1199.00), null);

        Item expected = new Item(randomId, "Iphone 12", BigDecimal.valueOf(1199.00), null);


        Item actual = itemMapper.mapToItem(item);

        assertEquals(actual.getId(), expected.getId());
        assertEquals(actual.getName(), expected.getName());
        assertEquals(actual.getPrice(), expected.getPrice());
    }

}
