package bg.dominos;

import bg.dominos.exceptions.IllegalEMailException;
import bg.dominos.exceptions.IllegalNameException;
import bg.dominos.exceptions.IllegalPasswordException;
import bg.dominos.utils.Methods;

public class Demo {

	public static void main(String[] args) throws IllegalPasswordException, IllegalEMailException, IllegalNameException {
		User ivan = new User("Ivan", "Ivanov", "ivan.ivanov@gmail.com", "ivangotiniq123");
		User mivan = new User("MIvan", "MIvanov", "mivan.mivanov@gmail.com", "mivangotiniq123");
	}

}
