package com.nagarro.orderservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.orderservice.dto.OrderResponse;
import com.nagarro.orderservice.models.Order;
import com.nagarro.orderservice.models.User;
import com.nagarro.orderservice.services.OrderServiceImpl;

@RestController
@RequestMapping("/orders")
public class OrderResource {

	@Autowired
	private OrderServiceImpl orderService;
	
	@GetMapping
	public OrderResponse getAllOrders() {
		OrderResponse response = new OrderResponse();
		response.setOrders(orderService.getOrders());
		return response;
	}

	@PostMapping
	public Order createOrder(@RequestBody Order order) {
		order.setUser(new User(1, "John", "23", "john.doe@google.com"));
		return orderService.createOrder(order);
	}

	@GetMapping(path = "/{userId}")
	public OrderResponse getOrdersByUserId(@PathVariable("userId") int userId) {
		OrderResponse response = new OrderResponse();
		response.setOrders(orderService.getOrdersByUserId(userId));
		return response;
	}
}
