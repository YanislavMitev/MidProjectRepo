package bg.dominos.models;

import bg.dominos.exceptions.IllegalTypeException;
import bg.dominos.exceptions.IllegalPriceException;
import bg.dominos.exceptions.IllegalWeightException;
import bg.dominos.exceptions.InvalidQuantityException;

public class Pasta extends Food {
	private static final String TYPE = "Pasta";
	
	
	public Pasta(float price, int quantity, float weight)
			throws IllegalPriceException, IllegalTypeException, InvalidQuantityException, IllegalWeightException {
		super(price, TYPE, quantity, weight);
	}

}
