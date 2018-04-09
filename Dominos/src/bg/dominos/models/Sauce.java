package bg.dominos.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bg.dominos.exceptions.ItemException;
import bg.dominos.utils.Utils;

public class Sauce extends Item {
	private static final String TYPE = "Sauce";
	private static final float SAUCE_PRICE = 2.0f;
	private String sauceType;
	private static List<Sauce> sauces = new ArrayList<Sauce>();

	private Sauce(String sacueType, float price) throws ItemException {
		super(TYPE, price);
		setDipType(sauceType);
	}

	private void setDipType(String sauceType) throws ItemException {
		if (Utils.checkString(sauceType)) {
			this.sauceType = sauceType;
		} else
			throw new ItemException("Sauce: Invalid dip type.");
	}

	public String getSauceType() {
		return this.sauceType;
	}
	
	public static List<Sauce> getSauces(){
		if(sauces.isEmpty()) {
			try {
				sauces.add(new Sauce("Frank's hot sauce dip", SAUCE_PRICE));
				sauces.add(new Sauce("Honey-mustard dip", SAUCE_PRICE));
				sauces.add(new Sauce("Garlic & Herbs dip", SAUCE_PRICE));
				sauces.add(new Sauce("Barbecue dip", SAUCE_PRICE));
				sauces.add(new Sauce("Sweet chilli dip", SAUCE_PRICE));
				sauces.add(new Sauce("Tomato dip", SAUCE_PRICE));
				sauces.add(new Sauce("Milk based sauce", SAUCE_PRICE));
				sauces.add(new Sauce("Ranch dip", SAUCE_PRICE));
				sauces.add(new Sauce("Caesar dip", SAUCE_PRICE));
				sauces.add(new Sauce("Italian dip", SAUCE_PRICE));
			} catch (ItemException e) {
				e.printStackTrace();
			}
		}
		return Collections.unmodifiableList(sauces);
	}

}
