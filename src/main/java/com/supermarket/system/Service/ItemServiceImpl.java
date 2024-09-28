package com.supermarket.system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.system.entity.Item;
import com.supermarket.system.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItem(Long itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }

    @Override
    public Item updateItem(Long itemId, Item item) {
        Item updateItem = itemRepository.findById(itemId).orElse(null);
        if (updateItem == null) {
            return null;
        } else {
            updateItem.setIname(item.getIname());
            updateItem.setPrice(item.getPrice());
            return itemRepository.save(updateItem);
        }
    }

    @Override
    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }

}
