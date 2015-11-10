package controllers;

import models.LoginState;
import models.User;
import models.User.Access;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.File;

/**
 * Created by ivar on 05.11.2015.
 */
public class Restricted extends Controller {
	public static Result at(String restriction, String file) {
		if(!LoginState.isValidlyLoggedIn()) return redirect(sso.routes.SSOLogin.login(request().uri()));
		if(restriction.equals("innlogget")) return showFile("loggedin/" + file);
		Access committee = Access.fromString(restriction);
		if(committee != Access.NONE) return restrictByCommittee(committee, file);
		User user = User.findByUsername(restriction);
		if(user != null) return restrictByUser(user, file);
		return application.Application.show404("/restricted/" + restriction + "/" + file);
	}

	private static Result restrictByUser(User user, String file) {
		if(!user.getUsername().equals(LoginState.getUser().getUsername())) return application.Application.showUnauthorizedAccess();
		return showFile(user.getUsername() + "/" + file);
	}

	private static Result restrictByCommittee(Access committee, String file) {
		if(!committee.userHasAccess(LoginState.getUser())) return application.Application.showUnauthorizedAccess();
		return showFile(committee.toString().toLowerCase() + "/" + file);
	}

	private static Result showFile(String filePath) {
		File file = new File("restricted/" + filePath);
		if(!file.exists()) return application.Application.showNotFound();
		return ok(file).as("application/octet-stream");
	}

}

