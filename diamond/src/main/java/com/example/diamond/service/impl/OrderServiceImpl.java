package com.example.diamond.service.impl;

import com.example.diamond.dao.OrderDao;
import com.example.diamond.dao.OrderDetailDao;
import com.example.diamond.entity.Order;
import com.example.diamond.entity.OrderDetail;
import com.example.diamond.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderDetailDao orderDetailDao;

    @Override
    public Order createOrder(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.convertValue(orderData, Order.class);
        orderDao.save(order);

        TypeReference<List<OrderDetail>> typeRef = new TypeReference<List<OrderDetail>>() {};
        List<OrderDetail> orderDetails = mapper.convertValue(orderData.get("orderDetails"),typeRef)
                .stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
        orderDetailDao.saveAll(orderDetails);
        return order;
    }

    @Override
    public Order findByOrderId(int orderId) {
        return orderDao.findById(orderId).get();
    }
}
