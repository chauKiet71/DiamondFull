package com.example.diamond.service;

import com.example.diamond.entity.Order;
import com.fasterxml.jackson.databind.JsonNode;

public interface OrderService {

    Order createOrder(JsonNode orderData);

    Order findByOrderId(int orderId);
}
