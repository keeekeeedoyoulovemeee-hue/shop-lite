package com.shoplite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500"})
public class ProductsApplication {

    // Список товаров
    private List<Product> products = Arrays.asList(
        new Product(1, "Футболка", 990, "https://placehold.co/200x200/4F46E5/FFFFFF?text=👕"),
        new Product(2, "Куртка", 5490, "https://placehold.co/200x200/059669/FFFFFF?text=🧥"),
        new Product(3, "Кроссовки", 3290, "https://placehold.co/200x200/DC2626/FFFFFF?text=👟"),
        new Product(4, "Джинсы", 2990, "https://placehold.co/200x200/7C3AED/FFFFFF?text=👖"),
        new Product(5, "Шапка", 1290, "https://placehold.co/200x200/EA580C/FFFFFF?text=🧢")
    );

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return products;
    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    public String home() {
        return "Products Service is running!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class, args);
    }

    // Модель товара
    public static class Product {
        private int id;
        private String name;
        private int price;
        private String image;

        public Product() {}

        public Product(int id, String name, int price, String image) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.image = image;
        }

        // Геттеры и сеттеры
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getPrice() { return price; }
        public void setPrice(int price) { this.price = price; }

        public String getImage() { return image; }
        public void setImage(String image) { this.image = image; }
    }
}