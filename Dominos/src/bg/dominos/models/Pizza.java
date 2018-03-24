package bg.dominos.models;

import java.util.ArrayList;
import java.util.List;

import bg.dominos.exceptions.IllegalPriceException;
import bg.dominos.exceptions.IllegalTypeException;
import bg.dominos.exceptions.IllegalWeightException;
import bg.dominos.exceptions.InvalidQuantityException;

public class Pizza extends Food {

	public Pizza(float price, String type, int quantity, float weight)
			throws IllegalPriceException, IllegalTypeException, InvalidQuantityException, IllegalWeightException {
		super(price, type, quantity, weight);
		// TODO Auto-generated constructor stub
	}

	//ti
	//price
}
