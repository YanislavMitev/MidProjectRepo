	package bg.dominos.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bg.dominos.exceptions.ItemException;
import bg.dominos.utils.Utils;

public class Chicken extends Item {
	public String getChickenType() {
		return chickenType;
	}
	private static final String INVALID_DESCRIPTION = "Chicken: Invalid description";
	private static List<Chicken> chicken = new ArrayList<Chicken>(4);
	private String description;
	private String chickenType;
	
	private Chicken(String chickenType, float price, String description) throws ItemException {
		super(chickenType, price);
		setDescription(description);
		setChickenType(chickenType);
	}

	private void setChickenType(String chickenType) throws ItemException {
		if(Utils.checkString(chickenType)) {
			this.chickenType = chickenType;
		}else throw new ItemException("Illegal chicken type.");
	}

	private void setDescription(String description) throws ItemException {
		if(Utils.checkString(description)) {
			this.description = description;
		}else throw new ItemException(INVALID_DESCRIPTION);
	}

	public String getDescription() {
		return this.description;
	}
	public static List<Chicken> getListWithChicken() throws ItemException{
		if(chicken.isEmpty()) {
			String description = "Oven baked chicken nuggets in a spicy breadcrumb coating. Served with Barbecue dip";
			String description2 = "Succulent pieces of white chicken breast coated in breadcrumbs cooked in the oven. Served with sweet chilli sauce";
			String description3 = "8 freshly baked chicken wings covered in Domino's barbecue sauce";
			String description4 = "8 freshly baked chicken wings in Franks sauce";
			try {
				chicken.add(new Chicken("Chicken kickers single portion", 6.5f, description));
				chicken.add(new Chicken("Chicken strippers single portion", 6.5f, description2));
				chicken.add(new Chicken("Buffalo wings single portion", 6.5f, description3));
				chicken.add(new Chicken("Hot buffalo wings", 6.5f, description4));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Collections.unmodifiableList(chicken);
	}
	
}
