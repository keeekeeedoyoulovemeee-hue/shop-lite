package com.shoplite;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer price;

    @Column(name = "image_url")
    private String imageUrl;

    private String description;
    private String category;

    @Column(name = "in_stock")
    private Boolean inStock;

    // Конструктор по умолчанию (обязателен для JPA)
    public Product() {
    }

    // Конструктор с параметрами
    public Product(String name, Integer price, String imageUrl, String description, String category) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
        this.category = category;
        this.inStock = true;
    }

    // Геттеры и сеттеры
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }
}