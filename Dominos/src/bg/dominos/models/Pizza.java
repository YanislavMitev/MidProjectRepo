package bg.dominos.models;

import bg.dominos.exceptions.IllegalPriceException;
import bg.dominos.exceptions.IllegalTypeException;
import bg.dominos.exceptions.IllegalWeightException;
import bg.dominos.exceptions.InvalidQuantityException;
import bg.dominos.utils.Methods;

public class Pizza extends Food {

	private static final String TYPE = "Pizza";
	private static final String ILLEGAL_PIZZA_TYPE = "Illegal pizza type";
	private String pizzaType;

	public Pizza(float price, String pizzaType, int quantity, float weight) throws IllegalPriceException, IllegalTypeException, InvalidQuantityException, IllegalWeightException  {
		super(price, TYPE, quantity, weight);
		setPizzaType(pizzaType);
	}

	private void setPizzaType(String pizzaType) throws IllegalTypeException {
		if (Methods.checkString(pizzaType)) {
			this.pizzaType = pizzaType;
		} else
			throw new IllegalTypeException(ILLEGAL_PIZZA_TYPE);
	}

	public String getPizzaType() {
		return this.pizzaType;
	}
}
