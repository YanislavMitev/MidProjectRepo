package bg.dominos.models;

import bg.dominos.exceptions.IllegalPriceException;
import bg.dominos.exceptions.IllegalTypeException;
import bg.dominos.exceptions.IllegalWeightException;
import bg.dominos.exceptions.InvalidQuantityException;

public class Salad extends Food {

	public Salad(float price, String type, int quantity, float weight)
			throws Exception {
		super(price, type, quantity, weight);
	}

}
