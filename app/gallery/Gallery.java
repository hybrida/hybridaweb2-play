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
        return ok(layoutBoxPage.render("Galleri", gallery.views.html.index.render(GalleryImage.find.where().orderBy("dateUploaded desc").findList()))); //score
    }

    public static Result giveImageClickScore(long imageId) {
        GalleryImage image = GalleryImage.find.byId(imageId);
        if (image == null) return badRequest();
        image.giveClickScore();
        return ok();
    }

    // TODO: implement in Upload, also make a general GalleryImage for files
    // Switch from masonry to isotope and order the thumbs by date (or scrable) and use packery layout
    // Restylise hovering and look of the gallery, remove rounded corners and have a black banner
    // overlay when hovering over which displays the title.
    // Also make images with no metadata have the image centered once pressed (have author/date right under the image)
    // While images with metadata have the data shown next to the image, if too hard, have the user
    // able to switch to a new image with the required info
    // Maybe make a pageload animation for the boxes
    // Place a limit on title length and desciption
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
