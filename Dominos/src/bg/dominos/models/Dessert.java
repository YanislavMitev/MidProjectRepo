package bg.dominos.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bg.dominos.exceptions.ItemException;
import bg.dominos.utils.Utils;

public class Dessert extends Item{
	private static final float ICE_CREAM_PRICE = 2.99f;
	private static final float DESSERT_PRICE = 5.5f;
	private static List<Dessert> desserts = new ArrayList<Dessert>();
	private String dessertType;
	
	private Dessert(String dessertType, float price) throws ItemException {
		super(dessertType, price);
		setDessertType(dessertType);
	}

	public String getDessertType() {
		return this.dessertType;
	}
	
	private void setDessertType(String dessertType) throws ItemException {
		if(Utils.checkString(dessertType)) {
			this.dessertType = dessertType;
		}else throw new ItemException("Illegal dessert type.");
	}
	
	public static List<Dessert> getDesserts(){
		if(desserts.isEmpty()) {
			try {
				desserts.add(new Dessert("Chocko pie with Nutella", DESSERT_PRICE));
				desserts.add(new Dessert("Chocolate souffle", DESSERT_PRICE));
				desserts.add(new Dessert("Nirvana pralines & cream", ICE_CREAM_PRICE));
				desserts.add(new Dessert("Nirvana cookies & cream", ICE_CREAM_PRICE));
				desserts.add(new Dessert("Nirvana chocolate nocciola", ICE_CREAM_PRICE));
				desserts.add(new Dessert("Brownie bites", DESSERT_PRICE));
				desserts.add(new Dessert("Nirvana chocolate & chocolate chips", ICE_CREAM_PRICE));
			} catch (ItemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Collections.unmodifiableList(desserts);
	}
	
	

}
