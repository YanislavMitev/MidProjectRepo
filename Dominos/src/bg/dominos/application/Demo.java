package bg.dominos.application;


import bg.dominos.business.logic.UserService;
import bg.dominos.models.Address;
import bg.dominos.models.Cities;
import bg.dominos.models.Menu;
import bg.dominos.models.Restaurant;

public class Demo {

	public static void main(String[] args) throws Exception {
		boolean exit = false;
		UserService us;
		while(!exit) {
			us = UserService.getInstance();
			us.extractUsers();
			System.out.println(us.reigsteredUsers.toString());
			Menu menu = new Menu();
			Restaurant restaurant = new Restaurant("Dominos", "South Park", "09:00-23:01", true, "0891234567", menu, true, true, false );
			Address address = new Address("Daskal Manol", "18", 1606, Cities.SOFIA, restaurant, "0899716512", 1);
			us.register("Yanislav", "Mitev", "yanislav@gmail.com", "azSeKazvamKaktoMamaMeEKrystila");
			
			us.saveChangesToUsers();
			exit = true;
		}
	}
}
