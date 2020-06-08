package com.nagarro.aggregatorservice.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class Order {

	private BigInteger orderId;
	private BigDecimal orderAmount;
	private LocalDate orderDate;

	public Order() {

	}

	public Order(BigInteger orderId, BigDecimal orderAmount, LocalDate orderDate) {
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
	}

	public BigInteger getOrderId() {
		return orderId;
	}

	public void setOrderId(BigInteger orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
}
