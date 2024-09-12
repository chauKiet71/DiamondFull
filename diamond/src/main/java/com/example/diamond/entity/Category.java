package com.example.diamond.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Categories")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    public String category_id;
    public String category_name;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    List<Product> Product;

}
