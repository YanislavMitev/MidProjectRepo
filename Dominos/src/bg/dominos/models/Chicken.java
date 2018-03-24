package bg.dominos.models;

import bg.dominos.exceptions.IllegalPriceException;

public class Chicken extends Item {

	public Chicken(String type, float price) throws IllegalPriceException {
		super(type, price);
	}
}
