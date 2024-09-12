package com.example.diamond.restcontroller;

import com.example.diamond.dao.CategoryDao;
import com.example.diamond.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoriesRestController {

    @Autowired
    CategoryDao dao;

    @GetMapping()
    public List<Category> getAllCategories() {
        return dao.findAll();
    }

    @PostMapping()
    public Category addCategory(@RequestBody Category category) {
        return dao.save(category);
    }

    @PutMapping("{id}")
    public Category updateCategory(@PathVariable("id") String id, @RequestBody Category category) {
        return dao.save(category);
    }

    @DeleteMapping("{id}")
    public void deleteCategory(@PathVariable("id") String id) {
        dao.deleteById(id);
    }

    @GetMapping("{id}")
    public Category getCategory(@PathVariable String id) {
        return dao.findById(id).get();
    }
}
