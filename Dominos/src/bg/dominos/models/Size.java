package bg.dominos.models;

public enum Size {
	MEDIUM(400, 7.9f),LAGRGE(600, 10.9f),JUMBO(900, 14.9f);
	
	private int weight;
	private float price;
	
	Size(int weigth, float price){
		this.price = price;
		this.weight = weigth;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public int getWeight() {
		return this.weight;
	}
}
