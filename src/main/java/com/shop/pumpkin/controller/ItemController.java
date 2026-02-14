package com.shop.pumpkin.controller;

import com.shop.pumpkin.model.Item;
import com.shop.pumpkin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/inventory/addItem")
    public void addItem(Item item) {
        itemService.save(item);
    }
}
