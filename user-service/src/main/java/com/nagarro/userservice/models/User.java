package com.nagarro.userservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.nagarro.userservice.views.Views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "USERS")
public class User {

	@Id
	private int id;
	@JsonView(Views.Get.class)
	private String name;
	@JsonView(Views.Get.class)
	private String age;
	@JsonView(Views.Get.class)
	private String email;
}
