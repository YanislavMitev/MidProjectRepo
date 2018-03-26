package bg.dominos.models;

import bg.dominos.exceptions.ItemException;

public class Drink extends Item {

	public Drink(String type, float price) throws ItemException {
		super(type, price);
	}

}
