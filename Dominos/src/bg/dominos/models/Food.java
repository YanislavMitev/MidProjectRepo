package bg.dominos.models;


import bg.dominos.exceptions.ItemException;

public abstract class Food extends Item  {
	private static final float MAX_WEIGHT = 4.0f;
	private static final String ILLEGAL_WEIGHT = "Illegal weight";
	private float weight;
	
	public Food(float price, String type, int quantity, float weight)
			throws ItemException {
		super(type,price);
		setQuantity(quantity);
		setWeight(weight);
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
	
}
