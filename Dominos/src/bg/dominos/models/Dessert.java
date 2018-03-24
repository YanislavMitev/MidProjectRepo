package bg.dominos.models;

import bg.dominos.exceptions.IllegalPriceException;

public class Dessert extends Item{

	public Dessert(String type, float price) throws IllegalPriceException {
		super(type, price);
	}

}
