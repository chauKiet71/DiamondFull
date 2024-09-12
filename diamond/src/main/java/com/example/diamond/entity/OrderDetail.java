package com.example.diamond.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_detail")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    float price;
    Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    public Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product product;
}
