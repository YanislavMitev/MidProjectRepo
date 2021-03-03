package com.pizza.order.main.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.pizza.order.exceptions.RestaurantException;

import com.pizza.order.main.models.address.Address;

import com.pizza.order.utils.Utils;

/**
 * Restaurant representation class.
 */
public class Restaurant {
	private static final String ILLEGAL_WORKING_TIME = "Illegal working time";
	private static final String ILLEGAL_ADDRESS_NAME = "Illegal address name";
	private static final String ILLEGAL_RESTAURANT_NAME = "Illegal restaurant name";
	private static final String ILLEGAL_PHONE_NUMBER = "Illegal restaurant phone number";

	@JsonProperty
	private String name;

	@JsonProperty
	private Address address;

	@JsonProperty
	private String workingTime;

	@JsonProperty
	private boolean active;

	@JsonProperty
	private String phoneNumber;

	@JsonProperty
	private boolean delivery;

	@JsonProperty
	private boolean carryOut;

	@JsonProperty
	private boolean eatingPlaces;

	/**
	 * Constructor.
	 */
	public Restaurant() {
		// No ops.
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

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) throws RestaurantException {
		if (!Utils.isNull(address)) {
			this.address = address;
		} else {
			throw new RestaurantException(ILLEGAL_ADDRESS_NAME);
		}
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
	public boolean equals(Object obj) {
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
}
