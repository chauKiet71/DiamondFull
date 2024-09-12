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
@Table(name = "Orders")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Order_id;

    @ManyToOne
    @JoinColumn(name = "username")
    public Account account;

    public Date create_date = new Date();
    public String address;
    @JsonIgnore
    @OneToMany(mappedBy = "order")
    List<OrderDetail> orderDetails;
}
