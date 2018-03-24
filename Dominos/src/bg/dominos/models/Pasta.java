package bg.dominos.models;


public class Pasta extends Food {
	private static final String TYPE = "Pasta";

	public Pasta(float price, int quantity, float weight) throws Exception {
		super(price, TYPE, quantity, weight);
	}

}
