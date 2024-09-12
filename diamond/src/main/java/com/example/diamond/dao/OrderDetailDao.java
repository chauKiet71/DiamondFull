package com.example.diamond.dao;

import com.example.diamond.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Integer> {
}
