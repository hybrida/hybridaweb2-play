package admintools;

import controllers.Upload;
import exceptions.*;
import models.LoginState;
import profile.*;
import profile.models.Specialization;
import profile.models.User;
import play.mvc.Controller;
import play.mvc.Result;
import util.Validator;
import play.twirl.api.Html;
import models.HttpRequestData;

import java.io.*;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import admintools.models.PasswordHash;
import admintools.views.html.*;

public class Admin extends Controller {
	public static Result index() {
		Boolean loggedIn = models.LoginState.isValidlyLoggedIn();
		User loginUser = models.LoginState.getUser();
		return ok(admintools.views.html.adminLayout.render("Admin", admintools.views.html.index.render(loggedIn, loginUser), false));
	}

	public static Result login() {
		try {
			HttpRequestData data = new HttpRequestData();
			String password = data.get("adminpass");
			String hash = "1000:273fad43db7f567593c84d7eab74256fb569d9328e21f938:02a4f3199ffc2c12389ca9bfb55a07f4692f180cc13083e0";
			boolean correct = PasswordHash.validatePassword(password, hash);
			if (correct) {
				session("user", play.api.libs.Crypto.encryptAES("hybrid," + String.valueOf(System.currentTimeMillis())));
				return redirect(admintools.routes.Admin.index());
			} else {
				return ok("password incorrect");
			}
		} catch (java.security.NoSuchAlgorithmException exc) {
			return ok(exc.toString());
		} catch (java.security.spec.InvalidKeySpecException exc) {
			return ok(exc.toString());
		}
	}

	public static Result logout() {
		session().remove("user");
		return redirect(admintools.routes.Admin.index());
	}

	public static Result allUsers() {
		User loginUser = models.LoginState.getUser();
		if (!loginUser.isAdmin()) {
			return redirect(application.routes.Application.showUnauthorizedAccess().url());
		} else {
			java.util.List<User> users = User.find.all();
			Collections.sort(users, new Comparator<User>() {
				@Override
				public int compare(final User lhs, User rhs)
				{
					return lhs.getUsername().compareTo(rhs.getUsername());
				}
			});
			String all_forms = "";
			String formheads = "";
			for (User user : users) {
				formheads += formHead.render(
					user.getId()).toString();
			}
			int period = 0;
			for (User user : users) {
				Html gen = userForm.render(
					user, period++ % 10 == 0, user.getId(), loginUser.isRoot());
				all_forms += gen.toString();
			}
			if(loginUser.isRoot()) {
				formheads += formHeadNew.render().toString();
				all_forms = newForm.render().toString() + all_forms;
			}
			Html html = Html.apply(formheads + all_forms);
			html = allUsersIndex.render(html);
			return ok(admintools.views.html.adminLayout.render("Hybrida - brukeradministrasjon", html, true));
		}
	}

	public static Result editUser(String uid) {
		User loginUser = models.LoginState.getUser();
		if (!loginUser.isAdmin()) {
			return redirect(application.routes.Application.showUnauthorizedAccess().url());
		}
		if (HttpRequestData.isGiven("delete")) {
			User toRemove = User.find.byId(Long.parseLong(uid));
			if (toRemove != null) {
//				toRemove.delete(); FIXME: Needs confirmation before deleting entry
			}
			return redirect(admintools.routes.Admin.allUsers());
		} else {
			User toUpdate = User.createUserFromRequest(loginUser.isRoot());
			toUpdate.setId(Long.parseLong(uid));
			toUpdate.update();
			return redirect(admintools.routes.Admin.allUsers());
		}
	}

	public static Result newUser() {
		User loginUser = models.LoginState.getUser();
		if (!loginUser.isRoot()) {
			return redirect(application.routes.Application.showUnauthorizedAccess().url());
		}
		User user = User.createUserFromRequest(loginUser.isRoot());
		user.setUsername(new HttpRequestData().get("username"));
		user.save();
		return redirect(profile.routes.Profile.edit(user.getUsername()));
	}

	public static Result updateUser() {
		return ok("Not implemented 1239543890127937");
	}

	private static String[] BULK_FIELDS = new String[]{
			"username",
			"firstName",
			"lastName",
			"middleName",
			"email",
			"phone",
			"graduationYear",
			"specialization",
			"member",
			"bedkom",
			"gender",
			"dateOfBirth"};

	public static Result bulkUsers() throws IOException {
		if(!LoginState.isValidlyLoggedIn() || !LoginState.getUser().isRoot()) return application.Application.showUnauthorizedAccess();
		BufferedReader inputReader;
		StringBuilder output = new StringBuilder();
		HttpRequestData formData = new HttpRequestData();
		String inputText = formData.get("userdata");

		try{
			File inputFile = Upload.getFileFromRequest("userdataFile");
			inputReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
			output.append("Using file.\n");
		} catch (NoFileInRequest|FileNotFoundException e) {
			inputReader = new BufferedReader(new StringReader(inputText));
			output.append("No file supplied. Using textfield instead.\n");
		}

		String line;
		Pattern linePattern = Pattern.compile("(([^,]*),){" + BULK_FIELDS.length + "}");
		List<String> users = new ArrayList<>();
		while((line = inputReader.readLine()) != null) {
			if(!linePattern.matcher(line).matches()) {
				output.append("Incorrect line format: " + line + "\n");
			} else {
				users.add(URLEncoder.encode(line, "UTF-8"));
			}
		}
		return bulkUsersForm(output.toString(), inputText, users);
	}

	public static Result bulkUsersForm() {
		if(!LoginState.isValidlyLoggedIn() || !LoginState.getUser().isRoot()) return application.Application.showUnauthorizedAccess();
		return bulkUsersForm(null, null, new ArrayList<>());
	}

	private static Result bulkUsersForm(String output, String input, List<String> users) {
		return ok(admintools.views.html.adminLayout.render("Hybrida - legg til mange brukere", admintools.views.html.bulkUserForm.render(output, input, users), true));
	}

	public static Result bulkAddSingle() throws UnsupportedEncodingException, ParseException {
		if(!LoginState.isValidlyLoggedIn() || !LoginState.getUser().isRoot()) return application.Application.showUnauthorizedAccess();
		if(!HttpRequestData.isGiven("data")) return application.Application.showBadRequest();
		String output = "";
		String data = new HttpRequestData().get("data");
//		data = new String(data.getBytes("ISO-8859-1"), "UTF-8");
		String[] userArray = data.split(" ?+, ?+", -1);
		Map<String, String> userMap = new HashMap<>();
		for(int i = 0; i < BULK_FIELDS.length; i++) userMap.put(BULK_FIELDS[i], userArray[i]);
		Map<String, String> errors;
		Validator validator;
		try {
			errors = (validator = Validator.fromJSON(new File("public/json/userValidation.json"))).validate(userMap);
		} catch (IOException e) {
			return application.Application.showInternalServerError();
		}
		output += "User: '" + userMap.get("username") + "'\n";
		if(User.findByUsername(userMap.get("username")) != null) return ok(output + "  User already extists.\n");
		if(!errors.isEmpty()) {
			output += "  Validation issue(s): " + data + "\n";
			for (String error : errors.values()) output += "    " + error + "\n";
			for (String key : errors.keySet()) {
				if (validator.isRequired(key)) return ok(output);
				else userMap.put(key, "");
			}
		}
		User user = new User(userMap.get("username"), userMap.get("firstName"), userMap.get("lastName"));
		user.setMiddleName(userMap.get("middleName"));
		user.setEmail(userMap.get("email"));
		user.setPhone(userMap.get("phone"));
		if(!userMap.get("graduationYear").isEmpty()) user.setGraduationYear(Integer.parseInt(userMap.get("graduationYear")));
		String specName = userMap.get("specialization");
		if(specName.toLowerCase().startsWith("integrerte operasjoner")) specName = Specialization.PETROLEUM.toString();
		if(specName.equalsIgnoreCase("petroleumsgeologi")) specName = Specialization.PETROLEUM.toString();
		if(specName.equalsIgnoreCase("produksjon og ledelse")) specName = Specialization.PRODUKSJONSLEDELSE.toString();
		Specialization specialization = Specialization.fromDisplayName(specName);
		if(specialization == null) output += "  Specialization not recognized: '" + specName + "'\n";
		else user.setSpecialization(specialization);
		user.member = Boolean.parseBoolean(userMap.get("member"));
		user.bedkom = Boolean.parseBoolean(userMap.get("bedkom"));
		user.gender = userMap.get("gender").charAt(0);
		String dateOfBirth = userMap.get("dateOfBirth");
		if(!dateOfBirth.isEmpty() && !dateOfBirth.equals("0000-00-00")) {
			user.dateOfBirth = Timestamp.from(new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth).toInstant());
		}
		user.save();
		return ok(output);
	}
}
