package bg.dominos.models;

import bg.dominos.exceptions.RestaurantException;
import bg.dominos.utils.Utils;

public class Restaurant {
	private static final String ILLEGAL_WORKING_TIME = "Illegal working time";
	private static final String ILLEGAL_ADDRESS_NAME = "Illegal address name";
	private static final String ILLEGAL_RESTAURANT_NAME = "Illegal restaurant name";
	private static final String ILLEGAL_PHONE_NUMBER = "Illegal restaurant phone number";
	private String name;
	private String address;
	private String workingTime;
	private boolean active;
	private String phoneNumber;
	private boolean delivery;
	private boolean carryOut;
	private boolean eatingPlaces;

	public Restaurant(String name, String address, String workingTime, boolean active, String phoneNumber,
			boolean delivery, boolean carryOut, boolean eatingPlaces) throws RestaurantException {
		setName(name);
		setAddress(address);
		setWorkingTime(workingTime);
		setActive(active);
		setPhoneNumber(phoneNumber);
		setDelivery(delivery);
		setCarryOut(carryOut);
		setEatingPlaces(eatingPlaces);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) throws RestaurantException {
		if (Utils.checkString(name)) {
			this.name = name;
		} else
			throw new RestaurantException(ILLEGAL_RESTAURANT_NAME);
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) throws RestaurantException {
		if (Utils.checkString(address)) {
			this.address = address;
		} else
			throw new RestaurantException(ILLEGAL_ADDRESS_NAME);
	}

	public String getWorkingTime() {
		return this.workingTime;
	}

	public void setWorkingTime(String workingTime) throws RestaurantException {
		if (Utils.checkString(workingTime) && Utils.checkWorkingHoures(workingTime)) {
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
		if (Utils.checkString(phoneNumber) && Utils.checkPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		} else
			throw new RestaurantException(ILLEGAL_PHONE_NUMBER);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) { {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
<<<<<<< HEAD
	
=======
	}

>>>>>>> aca44e8fdf06433ba9859cd216bd6c54c2b9422f
}
