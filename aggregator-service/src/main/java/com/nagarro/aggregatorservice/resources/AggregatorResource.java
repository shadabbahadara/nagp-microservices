package com.nagarro.aggregatorservice.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.aggregatorservice.models.OrderDetails;
import com.nagarro.aggregatorservice.models.OrderList;
import com.nagarro.aggregatorservice.models.User;


@RestController
@RequestMapping("/orderdetails")
public class AggregatorResource {

	private static Logger LOG = LoggerFactory.getLogger(AggregatorResource.class);

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(path = "/{userId}")
	public OrderDetails getOrders(@PathVariable("userId") int userId) {
		LOG.info("calling User service...");
		User user = restTemplate.getForObject("http://USER-SERVICE/user/" + userId, User.class);
		LOG.info("calling Order service...");
		OrderList orderList = restTemplate.getForObject("http://ORDER-SERVICE/orders/" + userId, OrderList.class);

		return new OrderDetails(user, orderList.getOrders());
	}
}
