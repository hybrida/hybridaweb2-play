package bedkomdatabase;

import play.mvc.Controller;
import play.mvc.Result;

import application.views.html.*;
import bedkomdatabase.views.html.*;
import views.html.*;
import models.*;
import bedkomdatabase.models.*;

import java.util.List;

public class Bedkomdatabase extends Controller {

    public static Result index(){
        if(!User.hasAccess(LoginState.getUser(), false, User.Access.BEDKOM, User.Access.VEVKOM)){
            return ok(layout.render("No access", application.views.html.showUnauthorizedAccess.render()));
        }
        List<Bedrift> bedriftList = Bedrift.find.orderBy("priority desc").findList();

        for(Bedrift i : bedriftList){
            System.out.println(i.getResponsible().getFullName());
        }



        return ok(layout.render("Bedriftsdatabase", beddb.render( bedriftList)));
    }

    public static Result saveBedrift(){

        HttpRequestData data = new HttpRequestData();
        System.out.println(data);

        Bedrift bedrift = new Bedrift(data.get("bedriftsName"), data.getInt("priority"), models.LoginState.getUser());

        bedrift.save();

        return redirect(bedkomdatabase.routes.Bedkomdatabase.index());
    }

    public static Result saveKontaktPerson(String id){
        HttpRequestData data = new HttpRequestData();
        Bedrift bedrift = Bedrift.find.byId(Long.parseLong(id));
        Contact contact = new Contact(data.get("telephone"), data.get("contact"), data.get("email"), data.get("other"), bedrift);
        contact.save();
        return redirect(bedkomdatabase.routes.Bedkomdatabase.index());
    }


}
