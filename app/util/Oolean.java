package util;

/**
 * Created by ivar on 26.01.2016.
 */
public enum Oolean {
	TRUE;
	public static Oolean fromBoolean(Boolean bool) {
		return bool != null && bool ? TRUE : null;
	}
}
