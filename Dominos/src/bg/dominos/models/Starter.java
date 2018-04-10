package bg.dominos.models;

import bg.dominos.exceptions.ItemException;
import bg.dominos.utils.Utils;

public class Starter extends Item{
	public String getStarterType() {
		return starterType;
	}

	private String description;
	private static Starter starter = null;
	private String starterType;
	
	private Starter(String starterType, float price, String description) throws ItemException {
		super(starterType, price);
		setDescription(description);
		setStarterType(starterType);
	}

	private void setStarterType(String starterType) throws ItemException {
		if(Utils.checkString(starterType)) {
			this.starterType = starterType;
		}else throw new ItemException("Illegal starter type.");
	}

	public static Starter getInstance() throws ItemException {
		if(starter == null) {
			String description = "Freshly baked, topped with mozzarella and the special Domino's seasoning, served with tomato dip";
			starter = new Starter("Cheese bread", 3.5f, description);
		}
		return starter;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if(bg.dominos.utils.Utils.checkString(description)) {
			this.description = description;			
		}
	}

}
