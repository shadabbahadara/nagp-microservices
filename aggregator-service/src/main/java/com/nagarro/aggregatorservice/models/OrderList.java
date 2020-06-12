package com.nagarro.aggregatorservice.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class OrderList {
	private List<Order> orders;

	public OrderList() {
		orders = new ArrayList<>();
	}

}
