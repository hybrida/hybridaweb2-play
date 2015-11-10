package restricted;

import models.LoginState;
import models.User;
import models.User.Access;
import org.apache.commons.io.FileUtils;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by ivar on 05.11.2015.
 */
public class Restricted extends Controller {
	public static Result restrict(String restriction, String file) {
		if(!LoginState.isValidlyLoggedIn()) return redirect(sso.routes.SSOLogin.login(request().uri()));
		if(restriction.equals("innlogget")) return showTempFile("loggedin/" + file);
		Access committee = Access.fromString(restriction);
		if(committee != Access.NONE) return restrictByCommittee(committee, file);
		User user = User.findByUsername(restriction);
		if(user != null) return restrictByUser(user, file);
		return application.Application.show404("/restricted/" + restriction + "/" + file);
	}

	private static Result restrictByUser(User user, String file) {
		if(!user.getUsername().equals(LoginState.getUser().getUsername())) return application.Application.showUnauthorizedAccess();
		return showTempFile(user.getUsername() + "/" + file);
	}

	private static Result restrictByCommittee(Access committee, String file) {
		if(!committee.userHasAccess(LoginState.getUser())) return application.Application.showUnauthorizedAccess();
		return showTempFile(committee.toString().toLowerCase() + "/" + file);
	}

	private static String createToken() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}

	private static void setFileForDeletion(String token, int seconds) {
		Thread t = new Thread(() -> {
			try {
				System.out.println("Deleting file in " + seconds + " seconds");
				TimeUnit.SECONDS.sleep(seconds);
				System.out.println("Deleting file");
				FileUtils.deleteDirectory(new File("public/temp/" + token));
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
		});
		t.setDaemon(true);
		t.start();
	}

	public static String makeTempFile(String file) throws IOException {
		String token = createToken();
		File origFile = new File("restricted/" + file);
		System.out.println("restricted/" + file);
		String temp = "temp/" + token + "/" + file;
		File tempFile = new File("public/" + temp);
		tempFile.getParentFile().mkdirs();
		FileUtils.copyFile(origFile, tempFile);
		setFileForDeletion(token, 10);
		return temp;
	}

	private static Result showTempFile(String file) {
		String temp;
		try {
			temp = makeTempFile(file);
		} catch (IOException e) {
			e.printStackTrace();
			return application.Application.showNotFound();
		}
		return ok(views.html.layoutBoxPage.render(
				"Hybrida - nedlasting",
				restricted.views.html.index.render(
						temp,
						file.substring(file.lastIndexOf('/')+1)
				)
		));
	}

}

