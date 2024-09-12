package com.example.diamond.restcontroller;

import com.example.diamond.dao.OrderDao;
import com.example.diamond.entity.Order;
import com.example.diamond.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/orders")
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @PostMapping()
    public String order(@RequestBody JsonNode orderData) {
        orderService.createOrder(orderData);
        return "success";
    }
}
