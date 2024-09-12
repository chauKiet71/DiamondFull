package com.example.diamond.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Entity
@Table(name = "Products")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    public String product_id;
    public String product_name;
    public String image;
    public float price;
    Date create_date = new Date();

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;
}
