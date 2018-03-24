package bg.dominos.models;

import bg.dominos.exceptions.IllegalTypeException;
import bg.dominos.utils.Methods;

public class Ingredient {

	private static final String ILLEGAL_INGREDIENT = "Illegal ingredient";
	private String type;
	
	public Ingredient(String type) throws IllegalTypeException{
		setIngredientType(type);
	}
	
	private void setIngredientType(String type) throws IllegalTypeException {
		if(Methods.checkString(type)) {
			this.type = type;
		}else throw new IllegalTypeException(ILLEGAL_INGREDIENT);
	}
	
	public String getType() {
		return this.type;
	}
}
