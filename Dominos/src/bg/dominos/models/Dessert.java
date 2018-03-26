package bg.dominos.models;

import bg.dominos.exceptions.ItemException;

public class Dessert extends Item{

	public Dessert(String type, float price) throws ItemException {
		super(type, price);
	}

}
