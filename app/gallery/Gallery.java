package gallery;

import exceptions.IncorrectFileType;
import exceptions.NoFileInRequest;
import exceptions.ServerError;
import exceptions.Unauthorized;
import models.GalleryImage;
import models.Event;
import models.HttpRequestData;
import play.mvc.Controller;
import play.mvc.Result;
import controllers.Upload;
import views.html.layoutBoxPage;

/**
 * Created by Tormod on 06.10.2015.
 */
public class Gallery extends Controller {
    public static Result display() {
        return ok(layoutBoxPage.render("Galleri", gallery.views.html.index.render(GalleryImage.find.where().orderBy("imageId desc").findList()))); //score
    }

    public static Result giveImageClickScore(long imageId) {
        GalleryImage image = GalleryImage.find.byId(imageId);
        if (image == null) return badRequest();
        image.giveClickScore();
        return ok();
    }

    // TODO: implement in Upload, also make a general GalleryImage for files
    // Make viewer more mobile friendly (if aspect ratio is wrong/screen is too small then have the image in center and a button on the side)
    // If swiped to the side, text is shown in the middle of the screen
    // Make the viewer image size recalculate on resize and change mode on aspect change (if mobile is flipped)
    // Make cross browser
    // Fix calendar aspect ration so no scrolling is nessesary + remove whitespace
    // Fix being able to scroll to the left
    // can also make a formula for calculating how many images are needed per page floor((h+400)/100*w/100*(1-precBig*3-precMed))
    // Or just add images until the page length is longer than the screen
    // Remove code from suggestion box
    // Make infinitly scrolling wall, load pages of 50 images and check if the length of the gallery is longer than the screen bottom + 400px
    // Maybe make a pageload animation for the boxes
    // Place a limit on title length (50) and desciption
    public static Result uploadGalleryImage() {
        HttpRequestData data = new HttpRequestData();
        String description = data.get("description");
        String title = data.get("title");
        Long eventId = data.getLong("eventId");

        try {
            String[] urls = Upload.uploadAndMakeThumb("image");
            if (urls != null && urls.length == 4) {
                int width = Integer.parseInt(urls[2]);
                int height = Integer.parseInt(urls[3]);
                Event event = null;
                if (eventId != null) event = Event.find.byId(eventId);
                GalleryImage image = new GalleryImage(title, description, width, height, Upload.THUMB_SIZE, event, urls[0], urls[1]);
                image.save();
                return redirect(gallery.routes.Gallery.display());
            } else throw new ServerError();
        } catch (Unauthorized unauthorized) {
            unauthorized.printStackTrace();
            return unauthorized();
        } catch (ServerError serverError) {
            serverError.printStackTrace();
            return internalServerError();
        } catch (NoFileInRequest noFileInRequest) {
            noFileInRequest.printStackTrace();
            return badRequest();
        } catch (IncorrectFileType incorrectFileType) {
            incorrectFileType.printStackTrace();
            return badRequest();
        }
    }
}
