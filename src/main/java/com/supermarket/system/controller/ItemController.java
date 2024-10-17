package com.supermarket.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.system.Service.CategoryService;
import com.supermarket.system.Service.ItemService;
import com.supermarket.system.dto.ItemDto;
import com.supermarket.system.entity.Category;
import com.supermarket.system.entity.Item;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/items")
    public ResponseEntity<?> createItem(@RequestBody ItemDto itemDto) {

        Item item = new Item();
        if (itemDto.getIname() == null) {
            return ResponseEntity.status(404).body("Null value");
        } else {
            Category category = categoryService.getCategory(itemDto.getCategoryId());
            item.setIname(itemDto.getIname());
            item.setPrice(itemDto.getPrice());
            item.setCategory(category);
            return ResponseEntity.status(201).body(itemService.createItem(item));
        }
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.status(200).body(itemService.getAllItems());
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity<?> getItem(@PathVariable Long itemId) {
        Item item = itemService.getItem(itemId);
        if (item == null) {
            return ResponseEntity.status(404).body("Item Id not found");
        } else {
            return ResponseEntity.status(200).body(item);
        }
    }

    @PutMapping("/items/{itemId}")
    public ResponseEntity<?> updateItem(@PathVariable Long itemId, @RequestBody ItemDto itemDto) {
        Item item = itemService.getItem(itemId);
        if (item==null) {
            return ResponseEntity.status(404).body("Item not found");
        } else {
            Category category = categoryService.getCategory(itemDto.getCategoryId());
            item.setIname(itemDto.getIname());
            item.setPrice(itemDto.getPrice());
            item.setCategory(category);
            return ResponseEntity.status(201).body(itemService.updateItem(itemId, item));
        }
    }

    @DeleteMapping("/items/{itemId}")
    public void deleteItem(@PathVariable Long itemId){
        itemService.deleteItem(itemId);
    }
}
