package controllers;

import exceptions.*;
import models.LoginState;
import profile.models.User;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Result;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ivar on 29.09.2015.
 */
public class Upload extends Controller {

	private enum FileType {IMAGE, PDF, DOCUMENT, OTHER}
	private static final Map<String, FileType> EXTENSION_MAP;
	static {
		HashMap<String, FileType> extensionMap = new HashMap<>();
		extensionMap.put(".jpg", FileType.IMAGE);
		extensionMap.put(".jpeg", FileType.IMAGE);
		extensionMap.put(".gif", FileType.IMAGE);
		extensionMap.put(".png", FileType.IMAGE);
		extensionMap.put(".pdf", FileType.PDF);
		extensionMap.put(".doc", FileType.DOCUMENT);
		extensionMap.put(".docx", FileType.DOCUMENT);
		extensionMap.put(".gdoc", FileType.DOCUMENT);
		EXTENSION_MAP = Collections.unmodifiableMap(extensionMap);
	}

	public static final int LOCAL_PATH           = 1;
	public static final int RESTRICTED_USER      = 1<<1;
	public static final int RESTRICTED           = 1<<2 + RESTRICTED_USER;
	public static final int REQUIRE_IMAGE        = 1<<3;
	public static final int REQUIRE_PDF          = 1<<4;
	public static final int REQUIRE_DOCUMENT     = 1<<5;

	public static final int THUMB_SIZE = 256; // 2^8
	public static final String THUMB_URL_END = "_thumb";

	public static File getFileFromRequest(String inputName) throws NoFileInRequest {
		MultipartFormData formData = request().body().asMultipartFormData();
		MultipartFormData.FilePart filePart = formData.getFile(inputName);
		if(filePart != null) {
			return filePart.getFile();
		} else {
			throw new NoFileInRequest();
		}
	}

	public static String getFileNameFromRequest(String inputName) throws NoFileInRequest {
		MultipartFormData formData = request().body().asMultipartFormData();
		MultipartFormData.FilePart filePart = formData.getFile(inputName);
		if(filePart != null) {
			return filePart.getFilename();
		} else {
			throw new NoFileInRequest();
		}
	}

	public static String uploadTo(String inputName, String uploadFolder, int flags) throws Unauthorized, ServerError, NoFileInRequest, IncorrectFileType {

		User user = LoginState.getUser();
		if (user.isDefault()) throw new Unauthorized();

		if(uploadFolder == null) {
			uploadFolder = user.getUsername();
		} else if (!uploadFolder.equals(user.getUsername()) && !user.admin) {
			//TODO: make sure user is authorized to ajaxUpload to that folder, otherwise block access
			throw new Unauthorized();
		}

		File tempFile = getFileFromRequest(inputName);
		String filename = getFileNameFromRequest(inputName);
		String extension = filename.substring(filename.lastIndexOf('.'));
		String filenameNoExtension = filename.substring(0, filename.lastIndexOf('.'));
		String folder = "uploads/" + uploadFolder + "/";
		String path;
		if((flags & RESTRICTED) != 0) {
			path = "restricted/" + ((flags & RESTRICTED_USER) != 0 ? user.getUsername() + "/" : "loggedin/") + folder;
		} else path = "public/" + folder;

		if(EXTENSION_MAP.containsKey(extension)){
			FileType fileType = EXTENSION_MAP.get(extension);
			if(((flags & REQUIRE_IMAGE) == REQUIRE_IMAGE && fileType != FileType.IMAGE)
					|| ((flags & REQUIRE_PDF) == REQUIRE_PDF && fileType != FileType.PDF)
					|| ((flags & REQUIRE_DOCUMENT) == REQUIRE_DOCUMENT && fileType != FileType.DOCUMENT)) {
				throw new IncorrectFileType();
			}
		}

		File newFile = new File(path + filename);
		for(int i = 1; newFile.exists(); i++) newFile = new File(path + filenameNoExtension + " (" + i + ")" + extension);
		newFile.getParentFile().mkdirs();
		if(!tempFile.renameTo(newFile.getAbsoluteFile())) throw new ServerError();
		if((flags & LOCAL_PATH) == LOCAL_PATH) {
			return newFile.getPath();
		} else if((flags & RESTRICTED) != 0) {
			String restriction = (flags & RESTRICTED_USER) != 0 ? user.getUsername() : "innlogget";
			return controllers.routes.Restricted.at(restriction, folder + newFile.getName()).url();
		} else {
			return controllers.routes.Assets.at(folder + newFile.getName()).url();
		}
	}

	public static String[] uploadAndMakeThumb(String inputName) throws Unauthorized, NoFileInRequest, ServerError, IncorrectFileType {
		// Save original image
		String imagePath = upload(inputName, LOCAL_PATH);
		if (imagePath == null) throw new ServerError();
        File tempFile = new File(imagePath);

		// Load file
		BufferedImage tempThumb = null;
		try {
			tempThumb = ImageIO.read(tempFile);
		} catch (IOException e) {
			throw new IncorrectFileType();
		}
		if (tempThumb == null) throw new ServerError();

		// Center and make 1:1 aspect ratio
		int width = tempThumb.getWidth();
		int height = tempThumb.getHeight();
		int smallestBound = height > width ? width : height;
		int halfDeltaWidth = (width - smallestBound)/2;
		int halfDeltaHeight = (height - smallestBound)/2;
		tempThumb = tempThumb.getSubimage(halfDeltaWidth, halfDeltaHeight, smallestBound, smallestBound);

		// Shrink
		Image tempThumbImg = tempThumb.getScaledInstance(THUMB_SIZE, THUMB_SIZE, BufferedImage.SCALE_SMOOTH);
		tempThumb = new BufferedImage(THUMB_SIZE, THUMB_SIZE, tempThumb.getType());
		tempThumb.getGraphics().drawImage(tempThumbImg, 0, 0 , null);

		// Write
		int fileFormatStartIndex = imagePath.lastIndexOf('.');
		int rootURLLength = imagePath.lastIndexOf('/');
		if (fileFormatStartIndex == -1 || rootURLLength > fileFormatStartIndex) throw new IncorrectFileType();
		String filename = imagePath.substring(fileFormatStartIndex + 1);
		String thumbPathWithoutFormat = imagePath.substring(0, fileFormatStartIndex) + Upload.THUMB_URL_END;

		File newFile = new File(thumbPathWithoutFormat + "." + filename);
		for (int i = 1; newFile.exists(); i++) newFile = new File(thumbPathWithoutFormat + " (" + i + ")" + "." + filename);
		newFile.getParentFile().mkdirs();

		try {
			if (!ImageIO.write(tempThumb, filename, newFile)) throw new ServerError();
		} catch (IOException e) {
			throw new ServerError();
		}
		return new String[]{
                controllers.routes.Assets.at(tempFile.getPath().substring(7)).url(),  //TODO: HACKY!!
                controllers.routes.Assets.at(newFile.getPath().substring(7)).url(),
                ""+width, ""+height}; //sorry, not sorry
	}

	public static String uploadTo(String inputName, String uploadFolder) throws Unauthorized, NoFileInRequest, ServerError {
		try {
			return uploadTo(inputName, uploadFolder, 0);
		} catch (IncorrectFileType incorrectFileType) {
			return null;
		}
	}

	public static String upload(String inputName, int flags) throws Unauthorized, NoFileInRequest, ServerError, IncorrectFileType {
		return uploadTo(inputName, null, flags);
	}


	public static String upload(String inputName) throws Unauthorized, NoFileInRequest, ServerError {
		try {
			return uploadTo(inputName, null, 0);
		} catch (IncorrectFileType incorrectFileType) {
			return null;
		}
	}

	public static String uploadOptional(String inputName) throws Unauthorized, ServerError {
		try {
			return upload(inputName);
		} catch (UploadException uploadException) {
			return null;
		}
	}

	public static Result ajaxUploadTo(String uploadFolder, int flags) {
		try {
			return ok(uploadTo("file", uploadFolder, flags));
		} catch (Unauthorized unauthorized) {
			return unauthorized();
		} catch (UploadException uploadException) {
			return badRequest();
		} catch (ServerError serverError) {
			return internalServerError();
		}
	}

	public static Result ajaxUploadTo(String uploadFolder) {
		return ajaxUploadTo(uploadFolder, 0);
	}

	public static Result ajaxUpload(int flags) {
		return ajaxUploadTo(null, flags);
	}

	public static Result ajaxUpload() {
		return ajaxUploadTo(null, 0);
	}
}
