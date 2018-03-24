package bg.dominos.models;

import bg.dominos.exceptions.IllegalPriceException;

public class Sauce extends Item{

	public Sauce(String type, float price) throws IllegalPriceException {
		super(type, price);
	}
	
}
