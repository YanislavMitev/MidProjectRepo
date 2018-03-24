package bg.dominos.models;

import bg.dominos.exceptions.IllegalPriceException;
import bg.dominos.exceptions.IllegalTypeException;
import bg.dominos.exceptions.IllegalWeightException;
import bg.dominos.exceptions.InvalidQuantityException;

public class Starter extends Item{
	private String description;
	
	public Starter(String type, float price, String description) throws IllegalPriceException {
		super(type, price);
		setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if(bg.dominos.utils.Methods.checkString(description)) {
			this.description = description;			
		}
	}

}
