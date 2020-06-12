package com.nagarro.orderservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.orderservice.data.OrderRepository;
import com.nagarro.orderservice.models.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> getOrders() {
		List<Order> orders = new ArrayList<>();
		orderRepository.findAll().forEach(orders::add);
		return orders;
	}

	@Override
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getOrdersByUserId(int userId) {
		return orderRepository.findByUserId(userId);
	}


}
