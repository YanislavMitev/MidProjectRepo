package bg.dominos.models;

import bg.dominos.exceptions.CannotAddIngredientException;

public interface IFood {
	public void addIngredient(Ingredient ingredient) throws CannotAddIngredientException;
	
}
