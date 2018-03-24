package bg.dominos.models;

import bg.dominos.exceptions.IllegalPriceException;
import bg.dominos.exceptions.IllegalTypeException;
import bg.dominos.exceptions.IllegalWeightException;
import bg.dominos.exceptions.InvalidQuantityException;
import bg.dominos.utils.Methods;

public class Pizza extends Food {
<<<<<<< HEAD
	private Size size;
	private Dough dough;
	
	public Pizza(float price, String type, int quantity, float weight, Size size, Dough dough)
			throws Exception {
		super(price, type, quantity, weight);
		setSize(size);
		setDough(dough);
	}

	public Size getSize() {
		return this.size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Dough getDough() {
		return this.dough;
	}

	public void setDough(Dough dough) {
		this.dough = dough;
=======

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
>>>>>>> 0dde1fff67a8f602bf67b39460aa97572d847dc2
	}
}
