package bg.dominos.models;


import java.util.ArrayList;
import java.util.List;

import bg.dominos.exceptions.CannotAddIngredientException;
import bg.dominos.exceptions.CannotRemoveIngredientException;
import bg.dominos.exceptions.IllegalPriceException;
import bg.dominos.exceptions.IllegalTypeException;
import bg.dominos.exceptions.IllegalWeightException;
import bg.dominos.exceptions.InvalidQuantityException;
import bg.dominos.utils.Methods;

public abstract class Food extends Item implements IFood {
	private static final float MAX_WEIGHT = 3.0f;
	private static final String ILLEGAL_WEIGHT = "Illegal weight";
	private static final String CANNOT_ADD_INGREDIENT = "Cannot add ingredient";
	private static final String CANNOT_REMOVE_INGREDIENT = "Cannot remove ingredient";
	private float weight;
	private List<Ingredient> ingredients;
	
	public Food(float price, String type, int quantity, float weight)
			throws IllegalPriceException, IllegalTypeException, InvalidQuantityException, IllegalWeightException {
		super(price);
		setType(type);
		setQuantity(quantity);
		setWeight(weight);
		this.ingredients = new ArrayList<Ingredient>();
	}
	
	public void setWeight(float weight) throws IllegalWeightException {
		if(weight > 0.0f && weight <= MAX_WEIGHT) {
			this.weight = weight;
		}else {
			if(weight > MAX_WEIGHT) {
				System.out.printf("Maximum weight of %f exceeded.", MAX_WEIGHT);
				this.weight = weight;
			}else throw new IllegalWeightException(ILLEGAL_WEIGHT);
		}
	}
	
	@Override
	public void addIngredient(Ingredient ingredient) throws CannotAddIngredientException{
		if(!Methods.isNull(ingredient) && !this.ingredients.contains(ingredient)) {
			this.ingredients.add(ingredient);
		}else throw new CannotAddIngredientException(CANNOT_ADD_INGREDIENT);
	}
	
	@Override
	public void removeIngredient(Ingredient ingredient) throws CannotRemoveIngredientException {
		if(!Methods.isNull(ingredient) && this.ingredients.contains(ingredient)) {
			int index = 0;
			for(Ingredient ingr : this.ingredients) {
				if(ingr.getType().equals(ingredient.getType())){
					index = this.ingredients.indexOf(ingr);
					break;
				}
			}
			this.ingredients.remove(index);
		}else throw new CannotRemoveIngredientException(CANNOT_REMOVE_INGREDIENT);
	}
	
}
