package bg.dominos.models;

import bg.dominos.exceptions.ItemException;

public interface IFood {
	public void addIngredient(Ingredient ingredient) throws ItemException;
	public void removeIngredient(Ingredient ingredient) throws ItemException;
}
