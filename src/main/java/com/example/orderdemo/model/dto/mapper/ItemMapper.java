package com.example.orderdemo.model.dto.mapper;

import com.example.orderdemo.model.dto.ItemDto;
import com.example.orderdemo.model.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ItemMapper {

    Item mapToItem(ItemDto itemDto);

    ItemDto mapToItemDto(Item item);

}
