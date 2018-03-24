package bg.dominos.models;

import bg.dominos.exceptions.IllegalPriceException;

public class Drink extends Item {

	public Drink(String type, float price) throws IllegalPriceException {
		super(type, price);
	}

}
