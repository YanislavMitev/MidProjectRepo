package bg.dominos.models;

import bg.dominos.exceptions.IllegalPriceException;
import bg.dominos.exceptions.IllegalTypeException;
import bg.dominos.exceptions.IllegalWeightException;
import bg.dominos.exceptions.InvalidQuantityException;

public class Chicken extends Item {

	public Chicken(String type, float price) throws IllegalPriceException {
		super(type, price);
	}
}
