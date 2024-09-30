package com.supermarket.system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.system.entity.Stock;
import com.supermarket.system.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStock(Long stockId) {
        return stockRepository.findById(stockId).orElse(null);
    }

    @Override
    public Stock updateStock(Long stockId, Stock stock) {
        Stock updateStock=stockRepository.findById(stockId).orElse(null);
        if(updateStock==null){
            return null;
        }else{
            updateStock.setQuantity(stock.getQuantity());
            updateStock.setExpireDate(stock.getExpireDate());
            updateStock.setItem(stock.getItem());
            return stockRepository.save(updateStock);
        }
    }

    @Override
    public void deleteStock(Long stockId) {
        stockRepository.deleteById(stockId);
    }
    
}
