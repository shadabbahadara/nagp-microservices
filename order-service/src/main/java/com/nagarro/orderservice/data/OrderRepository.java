package com.nagarro.orderservice.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.orderservice.models.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

	public List<Order> findByUserId(int id);
}
