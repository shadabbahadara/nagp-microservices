package com.nagarro.orderservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.orderservice.models.Order;
import com.nagarro.orderservice.services.OrderServiceImpl;

@RestController
@RequestMapping("/orders")
public class OrderResource {

	@Autowired
	private OrderServiceImpl orderService;
	
	@GetMapping(path = "/{userId}")
	public List<Order> getOrders(@PathVariable("userId") int userId) {
		return orderService.getOrders(userId);
	}
}
