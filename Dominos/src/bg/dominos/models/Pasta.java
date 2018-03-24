package bg.dominos.models;

import bg.dominos.exceptions.IllegalPriceException;
import bg.dominos.exceptions.IllegalTypeException;
import bg.dominos.exceptions.IllegalWeightException;
import bg.dominos.exceptions.InvalidQuantityException;

public class Pasta extends Food {
	private static final String TYPE = "Pasta";

<<<<<<< HEAD
	public Pasta(float price, int quantity, float weight) throws Exception {
=======
	public Pasta(float price, int quantity, float weight)
			throws IllegalPriceException, IllegalTypeException, InvalidQuantityException, IllegalWeightException {
>>>>>>> 0dde1fff67a8f602bf67b39460aa97572d847dc2
		super(price, TYPE, quantity, weight);
	}

}
