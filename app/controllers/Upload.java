package controllers;

import models.LoginState;
import models.User;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Result;

import java.io.File;
import java.util.HashMap;

/**
 * Created by ivar on 29.09.2015.
 */
public class Upload extends Controller {

    private enum FileType {IMAGE, PDF, DOCUMENT, OTHER}

    public static Result uploadTo(String uploadFolder) {
        User user = LoginState.getUser();
        if (user.isDefault()) return unauthorized();

        HashMap<String, FileType> extensionMap = new HashMap<>();
        extensionMap.put(".jpg", FileType.IMAGE);
        extensionMap.put(".jpeg", FileType.IMAGE);
        extensionMap.put(".gif", FileType.IMAGE);
        extensionMap.put(".png", FileType.IMAGE);
        extensionMap.put(".pdf", FileType.PDF);
        extensionMap.put(".doc", FileType.DOCUMENT);
        extensionMap.put(".docx", FileType.DOCUMENT);
        extensionMap.put(".gdoc", FileType.DOCUMENT);


        if(uploadFolder == null) {
            uploadFolder = user.getUsername();
        } else if (!uploadFolder.equals(user.getUsername()) && !user.admin) {
            //TODO: make sure user can upload to that folder, otherwise return unathorized()
            return unauthorized();
        }

        MultipartFormData formData = request().body().asMultipartFormData();
        MultipartFormData.FilePart filePart = formData.getFile("file");
        if(filePart != null) {
            File tempFile = filePart.getFile();
            String filename = filePart.getFilename();
            String extension = filename.substring(filename.lastIndexOf('.'));
            String filenameNoExtension = filename.substring(0, filename.lastIndexOf('.'));
            String folder = "uploads/" + uploadFolder + "/";
            File newFile = new File("public/" + folder + filename);
            for(int i = 1; newFile.exists(); i++) newFile = new File("public/" + folder + filenameNoExtension + "(" + i + ")" + extension);
            newFile.getParentFile().mkdirs();
            if(!tempFile.renameTo(newFile.getAbsoluteFile())) return internalServerError();
            return ok(controllers.routes.Assets.at(folder + newFile.getName()).url());
        } else {
            return badRequest("No file");
        }
    }

    public static Result upload() {
        return uploadTo(null);
    }
}