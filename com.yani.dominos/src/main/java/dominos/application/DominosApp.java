package dominos.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dominos.exceptions.UserException;
import dominos.models.address.Address;
import dominos.models.address.City;
import dominos.models.item.Drink;
import dominos.models.item.Item;
import dominos.models.user.User;

public class DominosApp {
	public static void main(String[] args) {
		try {
			User adminUser = new User("Yanislav", "Mitev", "yanislav@mitev.com", "123456");
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

			Address address = new Address("Home", "Neofit Rilski st.", "10A", 8500, City.AYTOS, (byte) 2);

			Item pizza = new Drink(
				"Juice of freshly drained apples.",
				"Apple juice",
				3.30f
			);

			String value = objectMapper.writeValueAsString(pizza);
			System.out.println(value);
		} catch (UserException | JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
