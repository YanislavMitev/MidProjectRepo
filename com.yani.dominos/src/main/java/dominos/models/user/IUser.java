package dominos.models.user;

import dominos.exceptions.AddressException;
import dominos.exceptions.UserException;
import dominos.models.address.Address;

public interface IUser {
	String ILLEGAL_PASSWORD = "Illegal password";
	String LOGIN_FIRST = "Please, first login into your acount";
	String NULL_BASKET = "Null basket as value";
	String NULL_ADDRESS_AS_VALUE = "Null address as value";
	String NON_EXISTING_ADDRESS = "Non-existing address";
	String EXISTING_ADDRESS = "Existing address";
	String ILLEGAL_LAST_NAME = "Illegal last name";
	String ILLEGAL_FIRST_NAME = "Illegal first name";
	String CANNOT_ADD_TO_BASKET = "Cannot add to basket.";
	String CANNOT_REMOVE_FROM_BASKET = "Cannot remove from basket.";
	String EMPTY_BASKET = "Empty basket.";
}
