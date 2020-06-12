package com.nagarro.aggregatorservice.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

	private int orderId;
	private int orderAmount;
	private LocalDate orderDate;
}
