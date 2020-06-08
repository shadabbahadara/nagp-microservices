package com.nagarro.aggregatorservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.nagarro.aggregatorservice.models.Order;
import com.nagarro.aggregatorservice.models.OrderDetails;
import com.nagarro.aggregatorservice.models.User;

@RestController
@RequestMapping("/orderdetails")
public class AggregatorResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@GetMapping(path = "/{userId}")
	public OrderDetails getOrders(@PathVariable("userId") String userId) {
		User user = restTemplate.getForObject("http://localhost:8081/user/" + userId, User.class);
//		User user = webClientBuilder.build().get().uri("http://localhost:8081/user/" + userId).retrieve()
//				.bodyToMono(User.class).block();
		List<Order> orders = restTemplate.getForObject("http://localhost:8082/orders/" + userId, List.class);

		return new OrderDetails(user, orders);
	}
}
