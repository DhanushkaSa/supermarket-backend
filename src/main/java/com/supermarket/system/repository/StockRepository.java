package com.supermarket.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.system.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
