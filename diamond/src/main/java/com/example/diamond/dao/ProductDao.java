package com.example.diamond.dao;

import com.example.diamond.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, String> {

    @Query("select p from Product p")
    public List<Product> selectTop4Product(Pageable pageable);
}
