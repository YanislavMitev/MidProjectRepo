package bg.dominos.models;

public enum Size {
	MEDIUM(0.400f, 7.9f),LAGRGE(0.600f, 10.9f),JUMBO(0.900f, 14.9f);
	
	private float weight;
	private float price;
	
	Size(float weigth, float price){
		this.price = price;
		this.weight = weigth;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public float getWeight() {
		return this.weight;
	}
}
