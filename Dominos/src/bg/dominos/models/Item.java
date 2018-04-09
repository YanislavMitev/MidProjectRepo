package bg.dominos.models;

import bg.dominos.exceptions.ItemException;
import bg.dominos.utils.Utils;

public abstract class Item {
	private static final String ILLEGAL_PRICE = "Illegal price.";
	private static final int MAX_QUANTITY = 100;
	private static final String INVALID_QUANTITY = "Invalid quantity";
	static final String ILLEGAL_FOOD_TYPE= "Illegal food type.";
	static final String MAXIMUM_QUANTITY_MSG = "Maximum quantity reached. Cannot order more than %d pieces.";
	private float price;
	private String type;
	private byte quantity;
	
	
	public Item(String type,float price) throws ItemException{
		this.setPrice(price);
	}
	
	public void setPrice(float price) throws ItemException {
		if(price > 0.0f) {
			this.price = price;
		}else throw new ItemException(ILLEGAL_PRICE);
	}
	
	public float getPrice() {
		return this.price;
	}

	public void setType(String type) throws ItemException {
		if(Utils.checkString(type)) {
			this.type = type;
		}else throw new ItemException(ILLEGAL_FOOD_TYPE);
	}

	public String getType() {
		return this.type;
	}

	public void setQuantity(int quantity) throws ItemException {
		if(quantity >= 0 && quantity <= MAX_QUANTITY) {
			this.quantity = (byte)quantity;
		}else {
			if(quantity > MAX_QUANTITY) {
				System.out.printf(MAXIMUM_QUANTITY_MSG,  MAX_QUANTITY);
				this.quantity = MAX_QUANTITY;
			}else throw new ItemException(INVALID_QUANTITY);
		}
	}

	public byte getQuantity() {
		return this.quantity;
	}
	
}
