package bg.dominos.models;

import bg.dominos.exceptions.IllegalPriceException;
import bg.dominos.exceptions.IllegalTypeException;
import bg.dominos.exceptions.IllegalWeightException;
import bg.dominos.exceptions.InvalidQuantityException;

public class Salad extends Food {

	public Salad(float price, String type, int quantity, float weight)
<<<<<<< HEAD
			throws Exception {
=======
			throws IllegalPriceException, IllegalTypeException, InvalidQuantityException, IllegalWeightException  {
>>>>>>> 0dde1fff67a8f602bf67b39460aa97572d847dc2
		super(price, type, quantity, weight);
	}

}
