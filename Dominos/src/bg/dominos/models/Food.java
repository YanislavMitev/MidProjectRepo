package bg.dominos.models;


import java.util.ArrayList;
import java.util.List;

import bg.dominos.exceptions.ItemException;
import bg.dominos.utils.Methods;

public abstract class Food extends Item implements IFood {
	private static final float MAX_WEIGHT = 3.0f;
	private static final String ILLEGAL_WEIGHT = "Illegal weight";
	private static final String CANNOT_ADD_INGREDIENT = "Cannot add ingredient";
	private static final String CANNOT_REMOVE_INGREDIENT = "Cannot remove ingredient";
	private float weight;
	private List<Ingredient> ingredients;
	
	public Food(float price, String type, int quantity, float weight)
			throws ItemException {
		super(type,price);
		setQuantity(quantity);
		setWeight(weight);
		this.ingredients = new ArrayList<Ingredient>();
	}
	
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) throws ItemException {
		if(weight > 0.0f && weight <= MAX_WEIGHT) {
			this.weight = weight;
		}else {
			if(weight > MAX_WEIGHT) {
				System.out.printf("Maximum weight of %f exceeded.", MAX_WEIGHT);
				this.weight = weight;
			}else throw new ItemException(ILLEGAL_WEIGHT);
		}
	}
	
	@Override
	public void addIngredient(Ingredient ingredient) throws ItemException{
		if(!Methods.isNull(ingredient) && !this.ingredients.contains(ingredient)) {
			this.ingredients.add(ingredient);
		}else throw new ItemException(CANNOT_ADD_INGREDIENT);
	}
	
	@Override
	public void removeIngredient(Ingredient ingredient) throws ItemException {
		if(!Methods.isNull(ingredient) && this.ingredients.contains(ingredient)) {
			int index = 0;
			for(Ingredient ingr : this.ingredients) {
				if(ingr.getType().equals(ingredient.getType())){
					index = this.ingredients.indexOf(ingr);
					break;
				}
			}
			this.ingredients.remove(index);
		}else throw new ItemException(CANNOT_REMOVE_INGREDIENT);
	}
	
}
