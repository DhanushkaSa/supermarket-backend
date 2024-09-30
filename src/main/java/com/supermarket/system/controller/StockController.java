package com.supermarket.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.system.Service.ItemService;
import com.supermarket.system.Service.StockService;
import com.supermarket.system.dto.StockDto;
import com.supermarket.system.entity.Item;
import com.supermarket.system.entity.Stock;

@RestController
public class StockController {
    

    @Autowired
    private StockService stockService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/stocks")
    public ResponseEntity<List<Stock>>getAllStocks(){
        return ResponseEntity.status(200).body(stockService.getAllStock());
    }

    @PostMapping("/stocks")
    public ResponseEntity<?> createStock(@RequestBody StockDto stockDto){
        if(stockDto.getExpireDate()==null && stockDto.getQuantity()==0){
            return ResponseEntity.status(400).body("Stock expire date or quantity is null");
        }else{
            Stock stock=new Stock();

            Item item=itemService.getItem(stockDto.getItem());
            stock.setExpireDate(stockDto.getExpireDate());
            stock.setQuantity(stockDto.getQuantity());
            stock.setItem(item);
            return ResponseEntity.status(201).body(stockService.createStock(stock));
        }
    }

    @GetMapping("/stocks/{stockId}")
    public ResponseEntity<?> getStock(@PathVariable Long stockId){
        Stock stock=stockService.getStock(stockId);
        if(stock==null){
            return ResponseEntity.status(404).body("Stock is null");
        }else{
            return ResponseEntity.status(200).body(stock);
        }
    }

    @PutMapping("/stocks/{stockId}")
    public ResponseEntity<?> updateStock(@PathVariable Long stockId,@RequestBody StockDto stockDto){
        Stock updateStock=stockService.getStock(stockId);
        if(updateStock==null){
            return ResponseEntity.status(400).body("Stock is not found");
        }else{
           

            Item item=itemService.getItem(stockDto.getItem());
            updateStock.setExpireDate(stockDto.getExpireDate());
            updateStock.setQuantity(stockDto.getQuantity());
            updateStock.setItem(item);
            return ResponseEntity.status(201).body(stockService.updateStock(stockId,updateStock));
        }
    }

    @DeleteMapping("/stocks/{stockId}")
    public void deleteStock(@PathVariable Long stockId){
          stockService.deleteStock(stockId);
    }

}
