package com.kodilla.patterns2.facade.api;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    private final List<ItemDto> itemsDto = new ArrayList<>();

    public void addItem(final ItemDto item) {
        itemsDto.add(item);
    }

    public List<ItemDto> getItemsDto() {
        return itemsDto;
    }
}
