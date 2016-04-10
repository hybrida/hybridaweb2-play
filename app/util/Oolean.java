package util;

public enum Oolean {
	TRUE;
	public static Oolean fromBoolean(Boolean bool) {
		return bool != null && bool ? TRUE : null;
	}
}
