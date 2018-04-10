package bg.dominos.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bg.dominos.exceptions.ItemException;
import bg.dominos.utils.Utils;

public class Salad extends Food {
	public String getDescription() {
		return description;
	}
	private String saladType;
	private static List<Salad> salads = new ArrayList<Salad>();
	private String description;
	
	private Salad(String saladType, float price, int quantity, float weight, String description)
			throws Exception {
		super(price, saladType, quantity, weight);
		setDescription(description);
		setSaladType(saladType);
	}
	

	private void setSaladType(String saladType) throws ItemException {
		if(Utils.checkString(saladType)) {
			this.saladType = saladType;
		}else throw new ItemException("Illegal salad type.");
		
	}


	private void setDescription(String description) throws ItemException {
		if(Utils.checkString(description)) {
			this.description = description;
		}else throw new ItemException("Salad: Invalid description.");
	}


	
	public String getSaladType() {
		return this.saladType;
	}
	
	public static List<Salad> getSalads() throws Exception{
		
		if(salads.isEmpty()) {
			String description1 = "Iceberg lettuce, arugula, fresh tomatoes, parmesan cheese, olive oil, Italian dressing";
			String description2 = "Tomatoes, feta cheese, pesto sauce and olive oil";
			String description3 = "Iceberg, carrot, bacon, corn, croutons, Parmesan, Caesar dressing";
			String description4 = "Iceberg, carrot, chicken, corn, croutons, Parmesan cheese, Caesar dressing";
			String description5 = "Iceberg lettuce, tuna, corn, olives, lemon and olive oil";
			
			salads.add(new Salad("Rocket Salad", 5.3f, 1, 0.220f, description1));
			salads.add(new Salad("Salad Tricolore", 5.3f, 1, 0.380f, description2));
			salads.add(new Salad("Caesar's Bacon", 5.8f, 1, 0.330f, description3));
			salads.add(new Salad("Caesar's Chicken", 5.8f, 1, 0.330f, description4));
			salads.add(new Salad("Tuna Salad", 5.8f, 1, 0.280f, description5));
		}
		
		return Collections.unmodifiableList(salads);
	}
}
