package StaticMethods;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Methods {
	private static final int MAX_PASS_LENGTH = 25;
	private static final int MIN_PASS_LENGTH = 5;


	public static boolean checkString(String text) {
		if(text != null && text.trim().length() > 0) {
			return true;
		}return false;
	}
	
	public static boolean isNull(Object obj) {
		if(obj == null) {
			return true;
		}return false;
	}

	public static boolean checkPassword(String password) {
		if(checkString(password) && password.length() > MIN_PASS_LENGTH && password.length() < MAX_PASS_LENGTH) {
			return true;
		}
		return false;
	}

	public static boolean checkPhoneNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile("0"+"\\d{9}");
		Matcher matcher = pattern.matcher(phoneNumber); 
		 if (matcher.matches()) {
		      return true;
		 }
		return false;
	}
}
