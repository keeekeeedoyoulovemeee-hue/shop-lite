package com.shoplite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@SpringBootApplication
@RestController
@CrossOrigin(origins = { "http://127.0.0.1:5500", "http://localhost:5500" })
public class ProductsApplication {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productRepository.findAll(); // Теперь берём из БД!
    }

    @GetMapping("/api/products/{id}")
    public Product getProduct(@PathVariable Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @GetMapping("/api/products/search/{name}")
    public List<Product> searchProducts(@PathVariable String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/")
    public String home() {
        return "Products Service with PostgreSQL is running!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class, args);
    }
}