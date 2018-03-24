package bg.dominos.models;

import bg.dominos.exceptions.CannotAddIngredientException;
import bg.dominos.exceptions.CannotRemoveIngredientException;

public interface IFood {
	public void addIngredient(Ingredient ingredient) throws CannotAddIngredientException;
	public void removeIngredient(Ingredient ingredient) throws CannotRemoveIngredientException;
}
