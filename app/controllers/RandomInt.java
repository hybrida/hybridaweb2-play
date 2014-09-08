package controllers;

import models.RandomForm;
import play.data.Form;
import play.mvc.*;
import views.html.*;

import java.util.Random;

import static play.data.Form.form;


public class RandomInt extends Controller{

    final static Form<RandomForm> randomForm = form(RandomForm.class);

    public static Result randomPage(){
        RandomForm created = new RandomForm();
        created.numberTo = 1;
        return ok(layoutString.render("random",randomview.render("",created).toString()));
    }

    public static Result newRandom(){
        Random rand = new Random();
        Form<RandomForm> input = randomForm.bindFromRequest();

        if(input.hasErrors()){
            RandomForm created = new RandomForm();
            created.numberTo = 1;
            return ok(randomview.render("",created));
        }else {
            RandomForm saved = input.get();
            int numberFrom = input.get().numberFrom;
            int numberTo = input.get().numberTo;
            if (numberFrom < numberTo) {
                int generated = rand.nextInt((numberTo - numberFrom) + 1) + numberFrom;
                return ok(randomview.render(generated + " er tilfeldig nok for meg", saved));
            } else {
                return ok(randomview.render(numberTo + " er ikke større enn " + numberFrom, saved));
            }
        }
    }


}
