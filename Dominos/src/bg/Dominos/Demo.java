package bg.Dominos;

import CustomExceptions.IllegalEMailException;
import CustomExceptions.IllegalNameException;
import CustomExceptions.IllegalPasswordException;
import StaticMethods.Methods;

public class Demo {

	public static void main(String[] args) throws IllegalPasswordException, IllegalEMailException, IllegalNameException {
		User ivan = new User("Ivan", "Ivanov", "ivan.ivanov@gmail.com", "ivangotiniq123");
		User mivan = new User("MIvan", "MIvanov", "mivan.mivanov@gmail.com", "mivangotiniq123");
	}

}
