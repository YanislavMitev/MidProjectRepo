package com.pizza.order.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pizza.order.main.models.user.User;


public abstract class Utils {
	private static final int MAX_PASS_LENGTH = 25;
	private static final int MIN_PASS_LENGTH = 5;

	private Utils() {
		// No ops.
	}

	public static boolean checkString(String text) {
		return text != null && text.trim().length() > 0;
	}

	public static boolean isNull(Object obj) {
		return obj == null;
	}

	public static boolean checkPassword(String password) {
		return checkString(password)
				&& password.length() > MIN_PASS_LENGTH
				&& password.length() < MAX_PASS_LENGTH;
	}

	public static boolean checkPhoneNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile("0"+"[89]"+"[789]" + "\\d{7}");
		Matcher matcher = pattern.matcher(phoneNumber);

		return matcher.matches();
	}
	
	public static boolean checkWorkingHoures(String workingTime) {
		Pattern pattern = Pattern.compile("\\d{2}:\\d{2}-\\d{2}:\\d{2}");
		Matcher matcher = pattern.matcher(workingTime);

		return matcher.matches();
	}
	
	public static boolean passwordMatching(User user, String oldPass, String newPass, String reNewPass) {
		return checkPassword(oldPass)
				&& checkPassword(newPass)
				&& checkPassword(reNewPass)
				&& user.getPassword().equals(oldPass)
				&& newPass.equals(reNewPass);
	}
}
