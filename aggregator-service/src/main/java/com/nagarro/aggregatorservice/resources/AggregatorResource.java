package com.nagarro.aggregatorservice.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.aggregatorservice.models.OrderDetails;
import com.nagarro.aggregatorservice.models.OrderList;
import com.nagarro.aggregatorservice.models.User;
import com.nagarro.exceptions.RestTemplateResponseErrorHandler;


@RestController
@RequestMapping("/orderdetails")
public class AggregatorResource {

	private static Logger LOG = LoggerFactory.getLogger(AggregatorResource.class);

	private RestTemplate restTemplate;

	@Autowired
	public AggregatorResource(RestTemplateBuilder builder) {
		restTemplate = builder.errorHandler(new RestTemplateResponseErrorHandler()).build();
	}

	@GetMapping(path = "/{userId}")
	public OrderDetails getOrders(@PathVariable("userId") int userId) {
		LOG.info("calling User service...");
		User user = restTemplate.getForObject("http://localhost:8081/user/" + userId, User.class);
		LOG.info("calling Order service...");
		OrderList orderList = restTemplate.getForObject("http://localhost:8082/orders/" + userId, OrderList.class);

		return new OrderDetails(user, orderList.getOrders());
	}
}
