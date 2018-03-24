package bg.dominos.models;

import java.util.Collections;
import java.util.List;

import bg.dominos.exceptions.IllegalListException;
import bg.dominos.exceptions.IllegalNameException;
import bg.dominos.exceptions.IllegalPriceException;
import bg.dominos.utils.Methods;

public class Deal {
	private static final String ILLEGAL_DEAL_NAME = "Illegal name";
	private static final String ILLEGAL_DEAL_ITEMS = "Illegal deal items";
	private static final String ILLEGAL_DEAL_PRICE = "Illegal deal price";
	private String dealName;
	private List<Item> dealItems;
	private float dealPrice;
	
	public Deal(String dealName, List<Item> dealItems, float dealPrice)
			throws IllegalNameException, IllegalListException, IllegalPriceException {
		setDealName(dealName);
		setDealItems(dealItems);
		setDealPrice(dealPrice);
		
	}

	public String getDealName() {
		return this.dealName;
	}

	public void setDealName(String dealName) throws IllegalNameException {
		if(Methods.checkString(dealName)) {
			this.dealName = dealName;
		}else throw new IllegalNameException(ILLEGAL_DEAL_NAME);
	}

	public List<Item> getDealItems() {
		return Collections.unmodifiableList(this.dealItems);
	}

	public void setDealItems(List<Item> dealItems) throws IllegalListException{
		if(!Methods.isNull(dealItems) && this.dealItems.isEmpty()) {
			this.dealItems = dealItems;
		}else throw new IllegalListException(ILLEGAL_DEAL_ITEMS);
	}

	public float getDealPrice() {
		return this.dealPrice;
	}

	public void setDealPrice(float dealPrice) throws IllegalPriceException {
		if(dealPrice > 0) {
			this.dealPrice = dealPrice;
		}else throw new IllegalPriceException(ILLEGAL_DEAL_PRICE);
	}
	
	
	
}
