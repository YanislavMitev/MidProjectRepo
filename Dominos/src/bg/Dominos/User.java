package bg.Dominos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import CustomExceptions.IllegalAvatarException;
import CustomExceptions.IllegalEMailException;
import CustomExceptions.IllegalNameException;
import CustomExceptions.IllegalPasswordException;
import CustomExceptions.NullBasketException;
import StaticMethods.Methods;

public class User  implements IUser{
	private static int userNumber = 0;
	private String firstName;
	private String lastName;
	private String eMail;
	private String password;
	private Set<Address> addresses;
	private List<Order> previousOrders;
	private File avatar;
	private Basket basket;
	private JSONObject saveInfo;
	
	
	public User(String firstName, String lastName, String eMail, String password)
			throws IllegalPasswordException, IllegalEMailException, IllegalNameException {
		this.saveInfo = new JSONObject();
        JSONArray list = new JSONArray();
        JSONObject obj = new JSONObject();

		
		setFirstName(firstName);
		setLastName(lastName);
		setEMail(eMail);
		setPassword(password);
		this.addresses = new HashSet<Address>();
		this.previousOrders = new ArrayList<Order>();
		
		list.add(this.saveInfo.put("first name", firstName));
		list.add(this.saveInfo.put("last name", lastName));
		list.add(this.saveInfo.put("e-mail", eMail));
		list.add(this.saveInfo.put("password", password));
		
		try (FileWriter file = new FileWriter("E:\\IT Talents Java EE\\MidProject\\Dominos\\src\\registeredUsers\\users.json")) {

            file.write(this.saveInfo.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		System.out.println(this.saveInfo);
		
	}

	
	
	@Override
	public void logIn(String userName, String password) {
		if(Methods.checkString(userName) && Methods.checkPassword(password)) {
			
		}
	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAddress(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword, String reenteredNewPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeAvatar(File avatar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAvatar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void emptyBasket() {
		// TODO Auto-generated method stub
		
	}

	
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) throws IllegalNameException {
		if (Methods.checkString(firstName)) {
			this.firstName = firstName;
		} else
			throw new IllegalNameException();
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) throws IllegalNameException {
		if (Methods.checkString(lastName)) {
			this.lastName = lastName;
		} else
			throw new IllegalNameException();
	}

	public String getEMail() {
		return this.eMail;
	}

	public void setEMail(String eMail) throws IllegalEMailException {
		if (Methods.checkString(eMail)) {
			this.eMail = eMail;
		} else
			throw new IllegalEMailException();
	}

	private String getPassword() {
		//read form JSON
		return this.password;
	}

	public void setPassword(String password) throws IllegalPasswordException {
		if (Methods.checkString(password)) {
			this.password = password;
		} else
			throw new IllegalPasswordException();
	}

	public Set<Address> getAddresses() {
		return Collections.unmodifiableSet(this.addresses);
	}

	public File getAvatar() {
		return this.avatar;
	}

	public void setAvatar(File avatar) throws IllegalAvatarException {
		if (avatar.exists() && avatar.isFile()) {
			this.avatar = avatar;
		} else
			throw new IllegalAvatarException();
	}

	public Basket getBasket() {
		return this.basket;
	}

	public void setBasket(Basket basket) throws NullBasketException {
		if (!Methods.isNull(basket)) {
			this.basket = basket;
		} else
			throw new NullBasketException();
	}
}
