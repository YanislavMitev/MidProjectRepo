package bg.dominos.models;


import bg.dominos.exceptions.IllegalPriceException;
import bg.dominos.exceptions.IllegalTypeException;
import bg.dominos.exceptions.IllegalWeightException;
import bg.dominos.exceptions.InvalidQuantityException;

public class Pizza extends Food {

	public Pizza(float price, String type, int quantity, float weight)
			throws IllegalPriceException, IllegalTypeException, InvalidQuantityException, IllegalWeightException {
		super(price, type, quantity, weight);
	}

}
