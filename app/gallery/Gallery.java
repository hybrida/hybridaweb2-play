package gallery;

import exceptions.NoFileInRequest;
import exceptions.ServerError;
import exceptions.Unauthorized;
import models.GalleryImage;
import models.Event;
import models.HttpRequestData;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;
import controllers.Upload;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tormod on 06.10.2015.
 */
public class Gallery extends Controller {
    public static Result display() {
        return ok(layout.render("Galleri", gallery.views.html.index.render(GalleryImage.find.all())));
    }

    public static Result uploadGalleryImage() {
        HttpRequestData data = new HttpRequestData();
        String description = data.get("description");
        String title = data.get("title");
        Long eventId = data.getLong("eventId");

        try {
            String url = null;
            url = Upload.upload("image");

            if (url != null) {
                Event event = null;
                if (eventId != null) event = Event.find.byId(eventId);
                GalleryImage image = new GalleryImage(title, description, event, url);
                image.save();
                return redirect(gallery.routes.Gallery.display());
            } else throw new ServerError();
        } catch (Unauthorized unauthorized) {
            return unauthorized();
        } catch (ServerError serverError) {
            return internalServerError();
        } catch (NoFileInRequest noFileInRequest) {
            return badRequest();
        }
    }
}
