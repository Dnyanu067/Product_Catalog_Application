package com.ProductCatalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ProductCatalog.model.Product;
import com.ProductCatalog.repository.ProductRepository;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public Page<Product> getProducts(Pageable pageable){
    	return productRepository.findAll(pageable);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updateproduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(updateproduct.getName());
            product.setCategory(updateproduct.getCategory());  // Added category update

            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product Not Found with id: " + id));
    }
    
    
    
    
    public void deleteProduct(Long id) {
    	  if (!productRepository.existsById(id)) {
              throw new RuntimeException("Product Not Found with id: " + id);
          }
        productRepository.deleteById(id);
    }
}
