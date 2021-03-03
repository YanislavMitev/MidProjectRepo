package com.pizza.order.main.application;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.pizza.order.main.business.core.repository.IUserRepositoryService;
import com.pizza.order.main.business.core.repository.impl.UserRepositoryServiceImpl;

import com.pizza.order.exceptions.UserException;
import com.pizza.order.main.models.address.Address;

import com.pizza.order.main.models.address.City;
import com.pizza.order.main.models.item.Drink;
import com.pizza.order.main.models.item.Item;
import com.pizza.order.main.models.user.User;

public class PizzaOrderApp {
	public static void main(String[] args) {
		try {
			User adminUser = new User("Yanislav", "Mitev", "yanislav@mitev.com", "123456");
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

			Address address = new Address("Home", "Neofit Rilski st.", "10A", 8500, City.AYTOS, (byte) 2);

			Item pizza = new Drink(
				"Juice of freshly drained apples.",
				"Apple juice",
				3.30f
			);

			String value = objectMapper.writeValueAsString(adminUser);

			IUserRepositoryService userRepositoryService = new UserRepositoryServiceImpl();
			userRepositoryService.initialize();

			System.out.println(value);
		} catch (UserException | JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
