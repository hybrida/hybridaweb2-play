package util;

public class TextUtil {
	public static String bool2checked(boolean bool) {
		return bool ? "checked" : "";
	}
	public static String bool2selected(boolean bool) {
		return bool ? "selected" : "";
	}
    public static String capitalized(String string) {
        return string.substring(0,1).toUpperCase()+string.substring(1).toLowerCase();
    }
}
