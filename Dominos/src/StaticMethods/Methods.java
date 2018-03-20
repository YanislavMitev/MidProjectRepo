package StaticMethods;

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
	
}
