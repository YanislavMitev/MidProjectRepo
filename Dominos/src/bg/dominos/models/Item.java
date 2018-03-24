package bg.dominos.models;

import bg.dominos.exceptions.IllegalTypeException;
import bg.dominos.exceptions.IllegalPriceException;
import bg.dominos.exceptions.InvalidQuantityException;
import bg.dominos.utils.Methods;

public abstract class Item {
	private static final String ILLEGAL_PRICE = "Illegal price.";
	private static final int MAX_QUANTITY = 100;
	private static final String INVALID_QUANTITY = "Invalid quantity";
	static final String ILLEGAL_FOOD_TYPE= "Illegal food type.";
	static final String MAXIMUM_QUANTITY_MSG = "Maximum quantity reached. Cannot order more than %d pieces.";
	private float price;
	private String type;
	private byte quantity;
	
	
	public Item(String type,float price) throws IllegalPriceException{
		this.setPrice(price);
	}
	
	public void setPrice(float price) throws IllegalPriceException {
		if(price > 0.0f) {
			this.price = price;
		}else throw new IllegalPriceException(ILLEGAL_PRICE);
	}
	
	public float getPrice() {
		return this.price;
	}

	public void setType(String type) throws IllegalTypeException {
		if(Methods.checkString(type)) {
			this.type = type;
		}else throw new IllegalTypeException(ILLEGAL_FOOD_TYPE);
	}

	public String getType() {
		return this.type;
	}

	public void setQuantity(int quantity) throws InvalidQuantityException {
		if(quantity >= 0 && quantity <= MAX_QUANTITY) {
			this.quantity = (byte)quantity;
		}else {
			if(quantity > MAX_QUANTITY) {
				System.out.printf(MAXIMUM_QUANTITY_MSG,  MAX_QUANTITY);
				this.quantity = MAX_QUANTITY;
			}else throw new InvalidQuantityException(INVALID_QUANTITY);
		}
	}
	
}
