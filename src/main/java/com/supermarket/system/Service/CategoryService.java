package com.supermarket.system.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.supermarket.system.entity.Category;

@Service
public interface CategoryService {
    
    public Category createCategory(Category category);

    public List<Category> getAllCategories();

    public Category getCategory(Long categoryId);

    public Category updateCategory(Long categoryId,Category category);

    public void deleteCategory(Long categoryId);
}
