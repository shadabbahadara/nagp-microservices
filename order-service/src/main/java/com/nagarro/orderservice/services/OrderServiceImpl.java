package com.nagarro.orderservice.services;

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
	public List<Order> getOrders(int userId) {
		return orderRepository.findByUserId(userId);
//		return Collections.singletonList(new Order(BigInteger.valueOf(1), BigDecimal.valueOf(250), LocalDate.now()));
	}

	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

}
