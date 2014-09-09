package controllers;

import models.Company;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;
import views.html.showsimple;

import java.util.ArrayList;

/**
 * Created by Henrik on 07.09.2014.
 */
public class GitGud extends Controller{
    public static Result shrek() {
        ArrayList<String> content = new ArrayList<>();
        content.add("<pre style =\"font-size:20px; color:#789922;\">>I was only 9 years old>I loved Shrek so much, I had all the merchandise and movies\n>I pray to Shrek every night before bed, thanking him for the life I've been given\n>\"Shrek is love\" I say; \"Shrek is life\"\n>My dad hears me and calls me a faggot\n>I know he was just jealous of my devotion for Shrek\n>I called him a cunt\n>He slaps me and sends me to go to sleep\n>I'm crying now, and my face hurts\n>I lay in bed and it's really cold\n>Suddenly, a warmth is moving towards me\n>It's Shrek\n>I am so happy\n>He whispers into my ear \"This is my swamp.\"\n>He grabs me with his powerful ogre hands and puts me down onto my hands and knees\n>I'm ready\n>I spread my ass-cheeks for Shrek\n>He penetrates my butt-hole\n>It hurts so much but I do it for Shrek\n>I can feel my butt tearing as my eyes start to water\n>I push against his force\n>I want to please Shrek\n>He roars in a mighty roar as he fills my butt with his love\n>My dad walks in\n>Shrek looks him straight in the eyes and says \"It's all ogre now.\"\n>Shrek leaves through my window\n>Shrek is love. Shrek is life.</pre>");

        return ok(layout.render("Better check yourself before you shrek yourself", content));
    }


}

