package com.supermarket.system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.system.entity.Category;
import com.supermarket.system.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public Category updateCategory(Long CategoryId,Category category) {
        Category categoryUpdate=categoryRepository.findById(CategoryId).orElse(null);
        if(categoryUpdate==null){
            return null;
        }else{{
            categoryUpdate.setCname(category.getCname());
            categoryUpdate.setDescription(category.getDescription());
            Category update=categoryRepository.save(categoryUpdate);
            return update;
        }}
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
    
}
