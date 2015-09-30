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

    public static Result upload() {
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

        MultipartFormData formData = request().body().asMultipartFormData();
//        return ok(formData.toString());

        MultipartFormData.FilePart filePart = formData.getFile("file");
        if(filePart != null) {
            File tempFile = filePart.getFile();
            String filename = filePart.getFilename();
            String extension = filename.substring(filename.lastIndexOf('.'));
            String noExtension = filename.substring(0, filename.lastIndexOf('.'));
            String folder = "public/upload/" + user.getUsername() + "/";
            File newFile = new File(folder + filename);
            for(int i = 1; newFile.exists(); i++) newFile = new File(folder + noExtension + "(" + i + ")" + extension);
            if(!tempFile.renameTo(newFile.getAbsoluteFile())) return internalServerError();
            return ok("assets/" + user.getUsername() + "/" + newFile.getName());
        } else {
            return badRequest("No file");
        }
    }
}