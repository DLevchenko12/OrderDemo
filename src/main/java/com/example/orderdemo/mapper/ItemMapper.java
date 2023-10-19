package com.example.orderdemo.mapper;

import com.example.orderdemo.model.dto.ItemDto;
import com.example.orderdemo.model.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ItemMapper {

    Item mapToItem(ItemDto itemDto);

    ItemDto mapToItemDto(Item item);
}
