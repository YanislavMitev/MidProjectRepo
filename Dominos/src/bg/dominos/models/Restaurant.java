package bg.dominos.models;

import bg.dominos.exceptions.IlleagalPhoneNumberException;
import bg.dominos.exceptions.IllegalNameException;
import bg.dominos.exceptions.IllegalWorkingTimeException;
import bg.dominos.exceptions.NonExistingAddressException;
import bg.dominos.exceptions.NonExistingMenuException;
import bg.dominos.utils.Methods;

public class Restaurant {
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
			boolean delivery, boolean carryOut, boolean eatingPlaces) throws Exception {
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

	public void setName(String name) throws IllegalNameException {
		if (Methods.checkString(name)) {
			this.name = name;
		} else
			throw new IllegalNameException();
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) throws NonExistingAddressException {
		if (Methods.checkString(address)) {
			this.address = address;
		} else
			throw new NonExistingAddressException();
	}

	public String getWorkingTime() {
		return this.workingTime;
	}

	public void setWorkingTime(String workingTime) throws IllegalWorkingTimeException {
		if (Methods.checkString(workingTime) && Methods.checkWorkingHoures(workingTime)) {
			this.workingTime = workingTime;
		} else
			throw new IllegalWorkingTimeException();
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

	public void setPhoneNumber(String phoneNumber) throws IlleagalPhoneNumberException {
		if (Methods.checkString(phoneNumber) && Methods.checkPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		} else
			throw new IlleagalPhoneNumberException();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) throws NonExistingMenuException {
		if (menu != null) {
			this.menu = menu;
		} else
			throw new NonExistingMenuException();
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

}
