package com.shop.pumpkin.controller;

import com.shop.pumpkin.model.Item;
import com.shop.pumpkin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    private final ItemService itemService;

    @Autowired
    public InventoryController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/inventory/getItems")
    public List<Item> getItems() {
        return itemService.getAll();
    }

    @PostMapping("/inventory/addItem")
    public void addItem(@RequestParam String name,
                        @RequestParam double wholesalePrice,
                        @RequestParam double retailPrice,
                        @RequestParam int amount,
                        @RequestParam int quantity,
                        @RequestParam double weight) {
        Item item = new Item(name, wholesalePrice, retailPrice, amount, quantity, weight);

        itemService.save(item);
    }

    @DeleteMapping("/inventory/deleteItem")
    public void deleteItem(@RequestParam String id) {
        itemService.delete(id);
    }
}
