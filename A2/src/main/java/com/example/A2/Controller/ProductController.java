package com.example.A2.Controller;

import com.example.A2.Entity.Products;
import com.example.A2.Entity.ProductsArray;
import com.example.A2.Entity.ResponseSuccess;
import com.example.A2.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/store-products")
    public ResponseEntity<ResponseSuccess> storeProducts(@RequestBody ProductsArray array) {

        System.out.println(array);
        System.out.println(array.getProducts());

        productService.saveProducts(array.getProducts());
        ResponseSuccess success = new ResponseSuccess();
        success.setMessage("Success.");
        return new ResponseEntity<>(success, HttpStatus.CREATED);

    }

    @GetMapping("/list-products")
    public ResponseEntity<Map<String, List<Products>>> listProducts() {
        List<Products> products = productService.getAllProducts();
        Map<String, List<Products>> response = new HashMap<>();
        response.put("products", products);
        return ResponseEntity.ok(response);
    }
}
