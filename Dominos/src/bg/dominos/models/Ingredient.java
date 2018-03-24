package bg.dominos.models;

import bg.dominos.exceptions.IllegalPriceException;
import bg.dominos.exceptions.IllegalTypeException;

public class Ingredient extends Item{

	public Ingredient(String type, float price) throws IllegalTypeException, IllegalPriceException{
		super(type, price);
	}
	
}
