package models;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by ivar on 02.10.2015.
 */
public enum Specialization {
	NONE(""),
	GEOMATIKK("Geomatikk"),
	KONSTRUKSJON("Konstruksjonsteknikk"),
	MARIN("Marin teknikk"),
	MASKIN("Produktutvikling og materialer"),
	PETROLEUM("Petroleumsfag"),
	PRODUKSJONSLEDELSE("Produksjonsledelse"),
	VARME_OG_STROMNING("Varme- og strømningsteknikk");
	private final String displayName;
	Specialization(String displayName) {
			this.displayName = displayName;
	}
	@Override
	public String toString(){
		return displayName;
	}

	public static Specialization fromDisplayName(String displayName) {
		for (Specialization value : values()) {
			if(value.toString().equalsIgnoreCase(displayName)) return value;
		}
		return null;
	}

	public static String[] displayNames() {
		return Arrays.stream(values()).map(Objects::toString).toArray(String[]::new);
	}
}
