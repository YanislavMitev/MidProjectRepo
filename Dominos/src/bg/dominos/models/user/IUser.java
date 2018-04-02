package bg.dominos.models.user;

import bg.dominos.exceptions.AddressException;
import bg.dominos.exceptions.UserException;
import bg.dominos.models.Address;

public interface IUser {
	public static final String ILLEGAL_PASSWORD = "Illegal password";
	public static final String INVALID_AVATAR_PATH = "Invalid avatar path";
	public static final String LOGIN_FIRST = "Please, first login into your acount";
	public static final String NULL_BASKET = "Null basket as value";
	public static final String NULL_ADDRESS_AS_VALUE = "Null address as value";
	public static final String NON_EXISTING_ADDRESS = "Non-existing address";
	public static final String EXISTING_ADDRESS = "Existing address";
	public static final String ILLEGAL_LAST_NAME = "Illegal last name";
	public static final String ILLEGAL_FIRST_NAME = "Illegal first name";
	public static final String ILLEGAL_AVATAR = "Illegal avatar";
	public static final String CANNOT_ADD_TO_BASKET = "Cannot add to basket.";
	public static final String CANNOT_REMOVE_FROM_BASKET = "Cannot remove from basket.";
	public static final String EMPTY_BASKET = "Empty basket.";
	
	public void addAddress(Address address) throws AddressException, UserException;

	public void deleteAddress(Address address) throws AddressException, UserException;
}
