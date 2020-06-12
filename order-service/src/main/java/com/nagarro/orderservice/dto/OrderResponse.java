package com.nagarro.orderservice.dto;

import java.util.List;

import com.nagarro.orderservice.models.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderResponse {
	private List<Order> orders;
}
