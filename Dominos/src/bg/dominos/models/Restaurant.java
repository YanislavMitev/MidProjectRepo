package bg.dominos.models;

import bg.dominos.exceptions.RestaurantException;
import bg.dominos.utils.Methods;

public class Restaurant {
	private static final String NULL_VALUE_AS_MENU = "Null value as menu";
	private static final String ILLEGAL_WORKING_TIME = "Illegal working time";
	private static final String ILLEGAL_ADDRESS_NAME = "Illegal address name";
	private static final String ILLEGAL_RESTAURANT_NAME = "Illegal restaurant name";
	private static final String ILLEGAL_PHONE_NUMBER = "Illegal restaurant phone number";
	private String name;
	private String address;
	private String workingTime;
	private boolean active;
	private String phoneNumber;
	private Menu menu;
	private boolean delivery;
	private boolean carryOut;
	private boolean eatingPlaces;

	public Restaurant(String name, String address, String workingTime, boolean active, String phoneNumber, Menu menu,
			boolean delivery, boolean carryOut, boolean eatingPlaces) throws RestaurantException {
		setName(name);
		setAddress(address);
		setWorkingTime(workingTime);
		setActive(active);
		setPhoneNumber(phoneNumber);
		setMenu(menu);
		setDelivery(delivery);
		setCarryOut(carryOut);
		setEatingPlaces(eatingPlaces);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) throws RestaurantException {
		if (Methods.checkString(name)) {
			this.name = name;
		} else
			throw new RestaurantException(ILLEGAL_RESTAURANT_NAME);
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) throws RestaurantException {
		if (Methods.checkString(address)) {
			this.address = address;
		} else
			throw new RestaurantException(ILLEGAL_ADDRESS_NAME);
	}

	public String getWorkingTime() {
		return this.workingTime;
	}

	public void setWorkingTime(String workingTime) throws RestaurantException {
		if (Methods.checkString(workingTime) && Methods.checkWorkingHoures(workingTime)) {
			this.workingTime = workingTime;
		} else
			throw new RestaurantException(ILLEGAL_WORKING_TIME);
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws RestaurantException {
		if (Methods.checkString(phoneNumber) && Methods.checkPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		} else
			throw new RestaurantException(ILLEGAL_PHONE_NUMBER);
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) throws RestaurantException{
		if (menu != null) {
			this.menu = menu;
		} else
			throw new RestaurantException(NULL_VALUE_AS_MENU);
	}

	public boolean isDelivery() {
		return delivery;
	}

	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}

	public boolean isCarryOut() {
		return carryOut;
	}

	public void setCarryOut(boolean carryOut) {
		this.carryOut = carryOut;
	}

	public boolean isEatingPlaces() {
		return eatingPlaces;
	}

	public void setEatingPlaces(boolean eatingPlaces) {
		this.eatingPlaces = eatingPlaces;
	}
	@Override
	public String toString() {
		return "Restaurant [name = " + name + ", address = " + address + ", workingTime = " + workingTime + ", active = "
				+ active + "]";
	}
}
