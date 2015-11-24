package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import play.data.Form;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by ivar on 06.10.2015.
 */
public class Validator {

	private static class Field {
		private String name;
		private Pattern pattern;
		private String message;
		private boolean required = false;

		public Field(String name, String pattern, boolean required, boolean caseSensitive, String message) {
			this.name = name;
			this.pattern = Pattern.compile(pattern, Pattern.UNICODE_CHARACTER_CLASS + (caseSensitive ? 0 : Pattern.CASE_INSENSITIVE));
			this.message = message;
			this.required = required;
		}

		public String getMessage() {
			return message;
		}

		public String getName() {
			return name;
		}

		public boolean isRequired() {
			return required;
		}

		public boolean isValid(String value) {
			return pattern.matcher(value).matches();
		}
	}

	public static class JSONValidator {
		public static class JSONField {
			public String name;
			public String pattern;
			public boolean required;
			public boolean caseSensitive;
			public String message;
		}
		public ArrayList<JSONField> fields;
	}

	private Field[] fields;

	public static Validator fromJSON(File source) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JSONValidator jsonValidator = mapper.readValue(source, JSONValidator.class);
		int fieldsNum = jsonValidator.fields.size();
		Validator validator = new Validator();
		validator.fields = new Field[fieldsNum];
		for(int i = 0; i < fieldsNum; i++) {
			JSONValidator.JSONField jsonField = jsonValidator.fields.get(i);
			validator.fields[i] = new Field(jsonField.name, jsonField.pattern, jsonField.required, jsonField.caseSensitive, jsonField.message);
		}
		return validator;
	}

	public Map<String, String> validate(Form form) {
		HashMap<String, String> messages = new HashMap<>();
		for(Field field : fields) {
			Form.Field formField = form.apply(field.getName());
			if(formField.value() == null || formField.value().isEmpty()) {
				if(field.isRequired()) messages.put(field.getName(), "Feltet kan ikke være tomt.");
			} else if(!field.isValid(formField.value())) {
				messages.put(field.getName(), field.getMessage());
			}
		}
		return messages;
	}

	public Map<String, String> validate(Map<String, String> data) {
		HashMap<String, String> messages = new HashMap<>();
		for(Field field : fields) {
			String value;
			if(!data.containsKey(field.getName()) || (value = data.get(field.getName())).isEmpty()) {
				if(field.isRequired()) messages.put(field.getName(), "Feltet kan ikke være tomt.");
			} else if(!field.isValid(value)) {
				messages.put(field.getName(), field.getMessage());
			}
		}
		return messages;
	}

	public boolean isRequired(String fieldName) {
		for(Field field : fields) if(field.getName().equals(fieldName)) return field.isRequired();
		return false;
	}
}
