package com.example.diamond.restcontroller;

import com.example.diamond.dao.ProductDao;
import com.example.diamond.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/product")
public class ProductRestController {

    @Autowired
    ProductDao dao;

    @GetMapping()
    public List<Product> getAllProducts() {
        return dao.findAll();
    }

    @PostMapping()
    public Product addProduct(@RequestBody Product product) {
        return dao.save(product);
    }

    @PutMapping("{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        return dao.save(product);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") String id) {
        dao.deleteById(id);
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable("id") String id) {
        return dao.findById(id).get();
    }
}
