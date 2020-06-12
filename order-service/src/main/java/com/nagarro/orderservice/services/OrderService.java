package com.nagarro.orderservice.services;

import java.util.List;

import com.nagarro.orderservice.models.Order;

public interface OrderService {

	List<Order> getOrders();

	List<Order> getOrdersByUserId(int userId);

	Order createOrder(Order order);
}
