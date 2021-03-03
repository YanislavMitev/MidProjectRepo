package com.pizza.order.main.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public enum Size {
	MEDIUM(0.400f, 7.9f),
	LAGRGE(0.600f, 10.9f),
	JUMBO(0.900f, 14.9f);

	@JsonProperty
	private float weight;

	@JsonProperty
	private float price;
	
	Size(float weigth, float price){
		this.price = price;
		this.weight = weigth;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public float getWeight() {
		return this.weight;
	}
}
