package com.ProductCatalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ProductCatalog.model.Category;
import com.ProductCatalog.repository.CategoryRepository;



@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public Page<Category> getCategories(Pageable pageable){
    	return categoryRepository.findAll(pageable);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category updatecategory){
        return categoryRepository.findById(id).map(category -> {
            category.setName(updatecategory.getName());
            category.setProducts(updatecategory.getProducts());
            
            return categoryRepository.save(category);
        }).orElseThrow(() -> new RuntimeException("Category Not Found"));
    }


    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}


