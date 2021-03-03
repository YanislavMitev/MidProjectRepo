package order.models.address;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import order.exceptions.AddressException;

import order.utils.Utils;


public class Address {
	private static final String ILLEGAL_POSTCODE = "Illegal postcode";
	private static final String ILLEGAL_STREET_NUMBER = "Illegal street number";
	private static final String ILLEGAL_STREET_NAME = "Illegal street name";

	private static final int HIGHER_POSTCODE = 10000;
	private static final int LOWER_POSTCODE = 1000;

	@JsonProperty
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	private String alias;

	@JsonProperty
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	private String street;

	@JsonProperty
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	private String streetNumber;

	@JsonProperty
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	private int postCode;

	@JsonProperty
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	private City city;

	@JsonProperty
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	private int apartmentBuildingNumber;

	@JsonProperty
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	private String entrance;

	@JsonProperty
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	private byte floor;

	@JsonProperty
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	private int flatNumber;

	/**
	 * Constructor.
	 *
	 * @param street is the street of the address.
	 * @param streetNumber is the street number of the address.
	 * @param postCode is the postcode of the address.
	 * @param city is the address city.
	 * @param floor is the street of the address.
	 */
	public Address(String alias, String street, String streetNumber, int postCode, City city, byte floor) {
		this.alias = alias;
		this.street = street;
		this.streetNumber = streetNumber;
		this.postCode = postCode;
		this.city = city;
		this.floor = floor;
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
		Address other;
		if (!Utils.isNull(obj) && obj instanceof Address) {
			other = (Address)obj;
		} else {
			return false;
		}
		
		if (!this.getStreet().equals(other.getStreet())) {
			return false;
		}

		if (!this.getStreetNumber().equals(other.getStreetNumber())) {
			return false;
		}

		if (this.getPostCode() != other.getPostCode()) {
			return false;
		}

		if (this.getCity() != other.getCity()) {
			return false;
		}

		return this.getFloor() == other.getFloor();
	}

	public String getAlias() {
		return alias;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) throws AddressException {
		if (Utils.checkString(street)) {
			this.street = street;
		} else {
			throw new AddressException(ILLEGAL_STREET_NAME);
		}
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) throws AddressException {
		if (Utils.checkString(streetNumber)) {
			this.streetNumber = streetNumber;
		} else {
			throw new AddressException(ILLEGAL_STREET_NUMBER);
		}
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) throws AddressException {
		if (postCode >= LOWER_POSTCODE && postCode < HIGHER_POSTCODE) {
			this.postCode = postCode;
		} else {
			throw new AddressException(ILLEGAL_POSTCODE);
		}
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", streetNumber=" + streetNumber + ", postCode=" + postCode + ", city="
				+ city + ", floor=" + floor + "]";
	}

	public int getApartmentBuildingNumber() {
		return this.apartmentBuildingNumber;
	}

	public void setApartmentBuildingNumber(int apartmentBuildingNumber) {
		this.apartmentBuildingNumber = apartmentBuildingNumber;
	}

	public String getEntrance() {
		return this.entrance;
	}

	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}

	public int getFloor() {
		return this.floor;
	}

	public void setFloor(byte floor) {
		this.floor = floor;
	}

	public int getFlatNumber() {
		return this.flatNumber;
	}

	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}
}
