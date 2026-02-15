package com.shop.pumpkin.service;

import com.shop.pumpkin.model.Item;
import com.shop.pumpkin.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void save(Item item) {
        log.info("Saving item with the name {}", item.getName());

        itemRepository.save(item);
    }

    public List<Item> getAll() {
        log.info("Retrieving all items");

        return itemRepository.findAll();
    }

    public void delete(String id) {
        log.info("Deleting item with id {}", id);

        itemRepository.deleteById(id);
    }
}
