package bg.Dominos;

import CustomExceptions.IlleagalPhoneNumberException;
import CustomExceptions.IlleagalPostcodeException;
import CustomExceptions.IlleagalRestaurantException;
import CustomExceptions.IllegalNameException;
import StaticMethods.Methods;

public class Address {
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
