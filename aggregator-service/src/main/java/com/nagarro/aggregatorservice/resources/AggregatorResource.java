package com.nagarro.aggregatorservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.nagarro.aggregatorservice.models.OrderDetails;
import com.nagarro.aggregatorservice.models.OrderList;
import com.nagarro.aggregatorservice.models.User;

@RestController
@RequestMapping("/orderdetails")
public class AggregatorResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@GetMapping(path = "/{userId}")
	public OrderDetails getOrders(@PathVariable("userId") int userId) {
		User user = restTemplate.getForObject("http://localhost:8081/user/" + userId, User.class);
		OrderList orderList = restTemplate.getForObject("http://localhost:8082/orders/" + userId, OrderList.class);

		return new OrderDetails(user, orderList.getOrders());
	}
}
