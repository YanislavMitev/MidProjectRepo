package com.pizza.order.main.models.item;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Pasta")
public class Pasta extends Food {

	/**
	 * Constructor.
	 */
	public Pasta() {
		// No ops.
	}

	/**
	 * Constructor.
	 *
	 * @param description is the pasta description.
	 * @param type is the pasta type.
	 * @param price is the pasta price.
	 */
	public Pasta(String description, String type, float price) {
		setDescription(description);
		setType(type);
		setPrice(price);
	}
}
