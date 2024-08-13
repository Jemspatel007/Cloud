package com.example.A2.Service;

import com.example.A2.Entity.Products;
import com.example.A2.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProducts(List<Products> products) {
        productRepository.saveAll(products);
    }

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }
}
