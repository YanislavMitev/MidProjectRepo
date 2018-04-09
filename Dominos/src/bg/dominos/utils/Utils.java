package bg.dominos.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bg.dominos.models.user.User;


public abstract class Utils {
	private static final int MAX_PASS_LENGTH = 25;
	private static final int MIN_PASS_LENGTH = 5;

	public static boolean checkString(String text) {
		if (text != null && text.trim().length() > 0) {
			return true;
		}
		return false;
	}

	public static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		}
		return false;
	}

	public static boolean checkPassword(String password) {
		if (checkString(password) && password.length() > MIN_PASS_LENGTH && password.length() < MAX_PASS_LENGTH) {
			return true;
		}
		return false;
	}

	public static boolean checkPhoneNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile("0"+"[89]"+"[789]" + "\\d{7}");
		Matcher matcher = pattern.matcher(phoneNumber);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
	
	public static boolean checkWorkingHoures(String workingTime) {
		Pattern pattern = Pattern.compile("\\d{2}:\\d{2}-\\d{2}:\\d{2}");
		Matcher matcher = pattern.matcher(workingTime);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
	
	public static boolean passwordMatching(User user, String oldPass, String newPass, String reNewPass) {
		if(!(checkString(oldPass) && checkString(newPass) && checkString(reNewPass))) {
			if(user.getPassword().equals(oldPass)) {
				if(newPass.equals(reNewPass)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
