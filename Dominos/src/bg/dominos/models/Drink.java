package bg.dominos.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bg.dominos.exceptions.ItemException;
import bg.dominos.utils.Utils;

public class Drink extends Item {
	private static final String TYPE = "Drink";
	private static List<Drink> drinks = new ArrayList<Drink>();
	private String drinkType;
	
	private Drink(String drinkType, float price) throws ItemException {
		super(TYPE, price);
		setDrinkType(drinkType);
	}

	private void setDrinkType(String drinkType) throws ItemException {
		if(Utils.checkString(drinkType)) {
			this.drinkType = drinkType;
		}else throw new ItemException("Drink: Invalid drink type");
	}
	
	public static List<Drink> getDrinks(){
		if(drinks.isEmpty()) {
			try {
				drinks.add(new Drink("Ayran", 1.6f));
				drinks.add(new Drink("Coca-cola zero 1.25L", 2.8f));
				drinks.add(new Drink("Coca-cola 1.25L", 2.8f));
				drinks.add(new Drink("Fanta 1.25L", 2.8f));
				drinks.add(new Drink("Mineral water 1.5L", 1.5f));
				drinks.add(new Drink("Beer: Zagorka 1L", 2.6f));
				drinks.add(new Drink("Beer: Heineken 330ml", 2.2f));
				drinks.add(new Drink("Nestea Lemon 0.5L", 2.0f));
				drinks.add(new Drink("Nestea Peach 0.5L", 2.0f));
				drinks.add(new Drink("Cappy Orange 330ml", 2.0f));
				drinks.add(new Drink("San Pelegrino 0.5L", 2.1f));
			} catch (ItemException e) {
				e.printStackTrace();
			}
		}
		return Collections.unmodifiableList(drinks);
	}

	public String getDrinkType() {
		return this.drinkType;
	}

}
