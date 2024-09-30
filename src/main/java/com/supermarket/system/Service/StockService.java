package com.supermarket.system.Service;

import org.springframework.stereotype.Service;

import com.supermarket.system.entity.Stock;
import java.util.*;

@Service
public interface StockService {
    

    public Stock createStock(Stock stock);

    public List<Stock> getAllStock();

    public Stock getStock(Long stockId);

    public Stock updateStock(Long stockId,Stock stock);

    public void deleteStock(Long stockId);

    

}
