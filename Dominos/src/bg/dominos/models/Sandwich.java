package bg.dominos.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bg.dominos.exceptions.ItemException;
import bg.dominos.utils.Utils;

public class Sandwich extends Food {
	private static final String TYPE = "Sandwich";
	private static List<Sandwich> sandwiches = new ArrayList<Sandwich>();
	private String sandwichType;
	private String description;
	
	private Sandwich(String sandwichType, float price, int quantity, float weight, String description) throws Exception {
		super(price, TYPE, quantity, weight);
		setDescription(description);
		setSandwichType(sandwichType);
	}
	
	public void setSandwichType(String sandwichType) throws ItemException {
		if(Utils.checkString(sandwichType)) {
			this.sandwichType = sandwichType;
		}else throw new ItemException("Sandwich: Invalid type.");
	}
	
	public void setDescription(String description) throws ItemException {
		if(Utils.checkString(description)) {
			this.description = description;
		}else throw new ItemException("Sandwich: Invalid description.");
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getSandwichType() {
		return this.sandwichType;
	}
	
	public static List<Sandwich> getSandwiches(){
		if(sandwiches.isEmpty()) {
			String description1 = "tomato sauce, emmental, Philadelphia cheese, pepperoni|\n";
			String description2 = "barbecue sauce, emmental, chicken fillet, bacon|\n";
			String description3 = "ranch sauce, emmental, white cheese, tomatoes, olives, green peppers|\n";
			try {
				sandwiches.add(new Sandwich("Pepperoni Sandwich", 5.5f, 1, 0.300f, description1));
				sandwiches.add(new Sandwich("BBQ Chicken Sandwich", 5.3f, 1, 0.250f, description2));
				sandwiches.add(new Sandwich("Pepperoni sandwich", 4.9f, 1, 0.280f, description3));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Collections.unmodifiableList(sandwiches);
	}
	@Override
	public String toString() {
		return this.sandwichType + " | price: " + this.getPrice() + " lv." + " | weight: " + this.getWeight() + "\n" + this.description;
	}
}
