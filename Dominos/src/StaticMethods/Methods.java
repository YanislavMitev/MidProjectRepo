package StaticMethods;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Methods {
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

	public static boolean checkPhoneNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile("0"+"\\d{9}");
		Matcher matcher = pattern.matcher(phoneNumber); 
		 if (matcher.matches()) {
		      return true;
		 }
		return false;
	}
}
