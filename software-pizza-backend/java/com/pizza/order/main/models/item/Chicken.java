package com.pizza.order.main.models.item;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Chicken")
public class Chicken extends Food {

	/**
	 * Constructor.
	 */
	public Chicken() {
		// No ops.
	}

	/**
	 * Constructor.
	 * @param chickenType is the chicken dish type.
	 * @param price is the chicken dish price.
	 * @param description is the chicken dish description.
	 *
	 * @throws IllegalArgumentException whenever an invalid
	 * 									argument is passed to
	 * 									be set as an item value.
	 */
	public Chicken(String chickenType, float price, String description) {
		setDescription(description);
		setType(chickenType);
		setPrice(price);
	}
}
