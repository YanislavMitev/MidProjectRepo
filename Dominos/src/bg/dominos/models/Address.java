package bg.dominos.models;

import bg.dominos.exceptions.AddressException;
import bg.dominos.exceptions.RestaurantException;
import bg.dominos.utils.Methods;

public class Address {
	private static final String ILLEGAL_RESTAURANT = "Illegal restaurant";
	private static final String ILLEGAL_POSTCODE = "Illegal postcode";
	private static final String ILLEGAL_STREET_NUMBER = "Illegal street number";
	private static final String ILLEGAL_PHONE_NUMBER = "Illegal phone number";
	private static final String ILLEGAL_STREET_NAME = "Illegal street name";
	private static final String ILLEGAL_ADDRESS_NAME = "Illegal address name";
	private static final int HIGHER_POSTCODE = 10000;
	private static final int LOWER_POSTCODE = 1000;
	private String name;
	private String street;
	private String streetNumber;
	private int postCode;
	private Cities city;
	private Restaurant restaurant;
	private String phoneNumber;
	private int block;
	private int entrance;
	private int floor;
	private int apartament;
	private String bell;

	public Address(String street, String streetNumber, int postCode, Cities city, Restaurant restaurant,
			String phoneNumber, int floor) {
		this.street = street;
		this.streetNumber = streetNumber;
		this.postCode = postCode;
		this.city = city;
		this.restaurant = restaurant;
		this.phoneNumber = phoneNumber;
		this.floor = floor;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int hashCode() {
		return this.getStreet().hashCode() * 
			   this.getStreetNumber().hashCode() * 
			   this.getPostCode() * 
			   this.getCity().hashCode() * 
			   this.getFloor();
	}

	@Override
	public boolean equals(Object obj) {
		Address other = null;
		if(!Methods.isNull(obj) && obj instanceof Address) {
			other = (Address)obj;
		}else {
			return false;
		}
		
		if(this.getStreet().equals(other.getStreet())) {
			if(this.getStreetNumber().equals(other.getStreetNumber())) {
				if(this.getPostCode() == other.getPostCode()) {
					if(this.getCity() == other.getCity()) {
						if(this.getFloor() == other.getFloor()) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public void setName(String name) throws AddressException { 
		if (Methods.checkString(name)) {
			this.name = name;
		} else
			throw new AddressException(ILLEGAL_ADDRESS_NAME);
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) throws AddressException { 
		if (Methods.checkString(street)) {
			this.street = street;
		} else
			throw new AddressException(ILLEGAL_STREET_NAME);
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) throws AddressException {
		if (Methods.checkString(streetNumber)) {
			this.streetNumber = streetNumber;
		} else
			throw new AddressException(ILLEGAL_STREET_NUMBER);
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) throws AddressException {
		if (postCode >= LOWER_POSTCODE && postCode < HIGHER_POSTCODE) {
			this.postCode = postCode;
		}else throw new AddressException(ILLEGAL_POSTCODE);
	}

	public Cities getCity() {
		return city;
	}

	public void setCity(Cities city) {
		this.city = city;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) throws RestaurantException {
		// check if restaurant exist
		if(!Methods.isNull(restaurant)) {
			this.restaurant = restaurant;
		}else throw new RestaurantException(ILLEGAL_RESTAURANT);
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", streetNumber=" + streetNumber + ", postCode=" + postCode + ", city="
				+ city + ", restaurant=" + restaurant + ", phoneNumber=" + phoneNumber + ", floor=" + floor + "]";
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws AddressException {
		if(Methods.checkPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		}else throw new AddressException(ILLEGAL_PHONE_NUMBER);
	}

	public int getBlock() {
		return this.block;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public int getEntrance() {
		return this.entrance;
	}

	public void setEntrance(int entrance) {
		this.entrance = entrance;
	}

	public int getFloor() {
		return this.floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getApartament() {
		return this.apartament;
	}

	public void setApartament(int apartament) {
		this.apartament = apartament;
	}

	public String getBell() {
		return this.bell;
	}

	public void setBell(String bell) {
		if(Methods.checkString(bell)) {
			this.bell = bell;			
		}else {
			this.bell = "";
		}
	}

}
