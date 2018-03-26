package bg.dominos.models;

import bg.dominos.exceptions.ItemException;

public class Ingredient extends Item {

	public Ingredient(String type, float price) throws ItemException {
		super(type, price);
	}

}
