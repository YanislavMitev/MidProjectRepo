package bg.dominos.application;


import bg.dominos.business.logic.UserService;
import bg.dominos.models.Address;
import bg.dominos.models.City;
import bg.dominos.models.Menu;
import bg.dominos.models.Restaurant;
import bg.dominos.models.user.User;

public class Demo {

	public static void main(String[] args) throws Exception {
//		boolean exit = false;
//		UserService us;
//		while(!exit) {
//			us = UserService.getInstance();
//			us.extractRestaurants();
//			us.extractUsers();
//			
//			us.logIn("yanislav@gmail.com", "azSeKazvamKaktoMamaMeEKrystila");
//			
//			
//			System.exit(0);
//		}
		Loader loader = Loader.getInstance();
		loader.loadHomePage();
	}
}
