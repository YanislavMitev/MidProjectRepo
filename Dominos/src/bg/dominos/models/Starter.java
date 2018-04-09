package bg.dominos.models;

import bg.dominos.exceptions.ItemException;

public class Starter extends Item{
	private String description;
	private static Starter starter = null;
	
	private Starter(String type, float price, String description) throws ItemException {
		super(type, price);
		setDescription(description);
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
