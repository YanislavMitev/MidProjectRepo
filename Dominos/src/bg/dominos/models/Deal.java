package bg.dominos.models;

import java.util.Collections;
import java.util.List;

import bg.dominos.exceptions.DealException;
import bg.dominos.utils.Methods;

public class Deal {
	private static final String INVALID_DESCRIPTION = "Invalid description";
	private static final String INVALID_LIST_ITEMS = "Invalid list of deal items";
	private static final String ILLEGAL_DEAL_NAME = "Illegal name";
	private static final String ILLEGAL_DEAL_PRICE = "Illegal deal price";
	
	private String dealName;
	private List<Item> dealItems;
	private float dealPrice;
	private String description;
	
	public Deal(String dealName, String description, List<Item> dealItems, float dealPrice)
			throws DealException {
		setDealName(dealName);
		setDealItems(dealItems);
		setDealPrice(dealPrice);
		
	}

	public String getDealName() {
		return this.dealName;
	}

	public void setDealName(String dealName) throws DealException {
		if(Methods.checkString(dealName)) {
			this.dealName = dealName;
		}else throw new DealException(ILLEGAL_DEAL_NAME);
	}

	public List<Item> getDealItems() {
		return Collections.unmodifiableList(this.dealItems);
	}

	public void setDealItems(List<Item> dealItems) throws DealException{
		if(!Methods.isNull(dealItems) && this.dealItems.isEmpty()) {
			this.dealItems = dealItems;
		}else throw new DealException(INVALID_LIST_ITEMS);
	}

	public float getDealPrice() {
		return this.dealPrice;
	}

	public void setDealPrice(float dealPrice) throws DealException {
		if(dealPrice > 0) {
			this.dealPrice = dealPrice;
		}else throw new DealException(ILLEGAL_DEAL_PRICE);
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description)throws DealException{
		if(Methods.checkString(description)) {
			this.description = description;
		}else throw new DealException(INVALID_DESCRIPTION);
			
	}
	
	
	
}
