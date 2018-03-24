package bg.dominos.models;

import bg.dominos.exceptions.IllegalPriceException;

public class Appetizer extends Item {
	
	
	public Appetizer(String type, float price) throws IllegalPriceException {
		super(type, price);
	}
}
