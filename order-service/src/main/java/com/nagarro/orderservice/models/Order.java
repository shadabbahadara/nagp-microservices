package com.nagarro.orderservice.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	private int orderId;
	private int orderAmount;
	private LocalDate orderDate;

	@JsonIgnore
	@ManyToOne
	private User user;
}
