package com.supermarket.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.system.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
    
}
