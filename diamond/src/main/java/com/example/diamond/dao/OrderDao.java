package com.example.diamond.dao;

import com.example.diamond.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {
}
