package com.example.diamond.controller;

import com.example.diamond.dao.ProductDao;
import com.example.diamond.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductDao dao;

    @GetMapping()
    public String product(Model model) {
        List<Product> products = dao.findAll();
        model.addAttribute("products", products);
        return "/client/product/product";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {
        Product pd = dao.findById(id).get();
        model.addAttribute("item", pd);
        return "/client/product/productDetail";
    }
}

