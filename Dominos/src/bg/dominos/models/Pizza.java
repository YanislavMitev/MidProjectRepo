package bg.dominos.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bg.dominos.exceptions.ItemException;
import bg.dominos.utils.Utils;

public class Pizza extends Food {
	
	private static final byte DEFAULT_QUANTITY = 1;
	private static List<Pizza> pizzas = new ArrayList<Pizza>();
	private String pizzaType;
	private Size size;
	private Dough dough;

	private Pizza(String pizzaType, int quantity, Size size, Dough dough) throws Exception {
		super(size.getPrice(), pizzaType, quantity, size.getWeight());
		setSize(size);
		setDough(dough);
		setPizzaType(pizzaType);
	}
	
	private void setPizzaType(String pizzaType) throws ItemException {
		if(Utils.checkString(pizzaType)) {
			this.pizzaType = pizzaType;
		}else throw new ItemException("Illegal pizza type.");
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
	
	public static List<Pizza> getPizzaList() {
		if(pizzas.isEmpty()) {
			try {
				pizzas.add(new Pizza("Margarita", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("Mediterraneo", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("Alfredo", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("Chickenita", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("Domino's Special", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("Chick - Chi - Rick", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("Carbonara", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("American Hot", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("Gardern Classic", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("Barbecue Chicken", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("New York", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("Ham Classic", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("Italian Classic", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("Hawaii", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("4 Cheese", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("Meat Mania", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("Burger Pizza", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
				pizzas.add(new Pizza("Master Burger Pizza", DEFAULT_QUANTITY, Size.MEDIUM, Dough.HAND_TOSSED));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Collections.unmodifiableList(pizzas);
	}
	public String getPizzaType() {
		return this.pizzaType;
	}
	
	@Override
	public String toString() {
		return this.pizzaType + " | size: "  + this.size + " | dough: " + this.dough;
	}
}
