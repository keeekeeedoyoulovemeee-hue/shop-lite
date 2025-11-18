package com.shoplite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Spring Data JPA сам реализует эти методы!
    List<Product> findAll();

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByCategory(String category);
}