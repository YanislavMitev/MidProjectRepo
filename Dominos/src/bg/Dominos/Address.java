package bg.Dominos;

import CustomExceptions.IlleagalPhoneNumberException;
import CustomExceptions.IlleagalPostcodeException;
import CustomExceptions.IlleagalRestaurantException;
import CustomExceptions.IllegalNameException;
import StaticMethods.Methods;

public class Address {
	private static final int HIGHER_POSTCODE = 100000;
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

	public void setName(String name) throws IllegalNameException {
		if (Methods.checkString(name)) {
			this.name = name;
		} else
			throw new IllegalNameException();
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) throws IllegalNameException {
		if (Methods.checkString(street)) {
			this.street = street;
		} else
			throw new IllegalNameException();
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) throws IllegalNameException {
		if (Methods.checkString(streetNumber)) {
			this.streetNumber = streetNumber;
		} else
			throw new IllegalNameException();
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) throws IlleagalPostcodeException {
		if (postCode >= LOWER_POSTCODE && postCode < HIGHER_POSTCODE) {
			this.postCode = postCode;
		}else throw new IlleagalPostcodeException();
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

	public void setRestaurant(Restaurant restaurant) throws IlleagalRestaurantException {
		// check if restaurant exist
		if(!Methods.isNull(restaurant)) {
			this.restaurant = restaurant;
		}else throw new IlleagalRestaurantException();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws IlleagalPhoneNumberException {
		if(Methods.checkPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		}else throw new IlleagalPhoneNumberException();
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public int getEntrance() {
		return entrance;
	}

	public void setEntrance(int entrance) {
		this.entrance = entrance;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getApartament() {
		return apartament;
	}

	public void setApartament(int apartament) {
		this.apartament = apartament;
	}

	public String getBell() {
		return bell;
	}

	public void setBell(String bell) {
		this.bell = bell;
	}

}
