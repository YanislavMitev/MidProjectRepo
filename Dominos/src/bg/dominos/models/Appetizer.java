package bg.dominos.models;

import bg.dominos.exceptions.ItemException;

public class Appetizer extends Item {
	
	
	public Appetizer(String type, float price) throws ItemException {
		super(type, price);
	}
}
