package com.supermarket.system.Service;

import org.springframework.stereotype.Service;

import com.supermarket.system.entity.Item;
import java.util.*;

@Service
public interface ItemService {
    
    public Item createItem(Item item);

    public List<Item> getAllItems();

    public Item getItem(Long ItemId);

    public Item updateItem(Long Item,Item item);

    public void deleteItem(Long Item);
}
