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

    public static Result updateBedrift(String bedriftId){
        HttpRequestData data = new HttpRequestData();
        System.out.println(data);

        Bedrift bedrift = Bedrift.find.byId(Long.parseLong(bedriftId));

        bedrift.setBedriftName(data.get("bedriftsName"));
        bedrift.setPriority(data.getInt("priority"));
        if(data.get("userId") == null){
            System.out.println("keeping current user");
        }
        else {
            bedrift.setResponsible(User.find.byId(Long.parseLong(data.get("userId"))));
        }

        bedrift.update();

        return redirect(bedkomdatabase.routes.Bedkomdatabase.index());
    }

    public static Result deleteBedrift(String bedriftId){
        Bedrift bedrift = Bedrift.find.byId(Long.parseLong(bedriftId));
        bedrift.delete();
        return redirect(bedkomdatabase.routes.Bedkomdatabase.index());
    }

    public static Result saveKontaktPerson(String id){
        HttpRequestData data = new HttpRequestData();
        Bedrift bedrift = Bedrift.find.byId(Long.parseLong(id));
        Contact contact = new Contact(data.get("telephone"), data.get("contact"), data.get("other"), data.get("email"), bedrift);
        contact.save();
        return redirect(bedkomdatabase.routes.Bedkomdatabase.index());
    }

    public static Result updateKontaktPerson(String id){
        Contact contact = Contact.find.byId(Long.parseLong(id));
        HttpRequestData data = new HttpRequestData();
        contact.setContact(data.get("contact"));
        contact.setEmail(data.get("email"));
        contact.setTelephone(data.get("telephone"));
        contact.setOther("other");
        contact.update();
        return redirect(bedkomdatabase.routes.Bedkomdatabase.index());
    }

    public static Result deleteKontaktPerson(String id){
        Contact contact = Contact.find.byId(Long.parseLong(id));
        contact.delete();
        return redirect(bedkomdatabase.routes.Bedkomdatabase.index());
    }

}