package StaticMethods;

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
}
