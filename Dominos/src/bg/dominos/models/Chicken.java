package bg.dominos.models;

import bg.dominos.exceptions.ItemException;

public class Chicken extends Item {

	public Chicken(String type, float price) throws ItemException {
		super(type, price);
	}
}
