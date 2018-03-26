package bg.dominos.models;

import bg.dominos.exceptions.ItemException;

public class Starter extends Item{
	private String description;
	
	public Starter(String type, float price, String description) throws ItemException {
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