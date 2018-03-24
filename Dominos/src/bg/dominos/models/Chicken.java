package bg.dominos.models;

import bg.dominos.exceptions.IllegalPriceException;
import bg.dominos.exceptions.IllegalTypeException;
import bg.dominos.exceptions.IllegalWeightException;
import bg.dominos.exceptions.InvalidQuantityException;

public class Chicken extends Item {

<<<<<<< HEAD
	public Chicken(String type, float price) throws IllegalPriceException {
		super(type, price);
=======
	public Chicken(float price, String type, int quantity, float weight)
			throws IllegalPriceException, IllegalTypeException, InvalidQuantityException, IllegalWeightException {
		super(price, type, quantity, weight);
>>>>>>> 0dde1fff67a8f602bf67b39460aa97572d847dc2
	}
}
