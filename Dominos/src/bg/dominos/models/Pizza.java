package bg.dominos.models;

import bg.dominos.exceptions.ItemException;
import bg.dominos.utils.Methods;

public class Pizza extends Food {
	private static final String TYPE = "Pizza";
	private static final String ILLEGAL_PIZZA_TYPE = "Illegal pizza type";
	private String pizzaType;
	private Size size;
	private Dough dough;

	public Pizza(float price, String pizzaType, int quantity, float weight, Size size, Dough dough) throws Exception {
		super(price, TYPE, quantity, weight);
		setSize(size);
		setDough(dough);
		setPizzaType(pizzaType);
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
	}
	
	private void setPizzaType(String pizzaType) throws ItemException {
		if (Methods.checkString(pizzaType)) {
			this.pizzaType = pizzaType;
		} else
			throw new ItemException(ILLEGAL_PIZZA_TYPE);
	}

	public String getPizzaType() {
		return this.pizzaType;
	}
}
