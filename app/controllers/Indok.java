package controllers;

import models.Company;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;
import views.html.showsimple;

import java.util.ArrayList;

/**
 * Created by Sindre on 06.09.2014.
 */

public class Indok extends Controller {


    public static Result facepalm(){
      String str =  "<pre style =\"font-size:20px; line-height: 200%;\">        ............................................________................................." +
              "\n        ....................................,.-‘”...................``~.,...................." +
                "\n        .............................,.-”...................................“-.,............." +
              "\n        .........................,/...............................................”:,........" +
              "\n        .....................,?......................................................),......" +
              "\n        .................../...........................................................,}...." +
              "\n        ................./......................................................,:`^`..}....." +
              "\n        .............../...................................................,:”........./....." +
              "\n        ..............?.....__.........................................:`.........../....." +
              "\n        ............./__.(.....“~-,_..............................,:`..." +
              "......./........" +
              "\n        .........../(_....”~,_........“~,_....................,:`........_/..........." +
              "\n        ..........{.._$;_......”=,_.......“-,_......" +
              ".,.-~-,},.~”;/....}..........." +
              "\n        ...........((.....*~_.......”=-._......" +
              "“;,,./`..../”............../............" +
              "\n        ...,,,___.)`~,......“~.,....................`.....}............../............." +
              "\n        ............(....`=-,,.......`........................(......;_,,-”..............." +
              "\n        ............/.`~,......`-...............................)....../)..................." +
              "\n        .............)`~.*-,.....................................|,./.....)" +
              ",__..........." +
              "\n        ,,_..........}.>-._)...................................|..............`=~-,...." +
              "\n        .....`=~-,_)_......`),....................." +
              "............)........................" +
              "\n        .........." +
              ".........`=~-,,.),...............................)......................." +
              "\n        ......." +
        ".........................`:,,...........................`)..............__.." +
              "\n        ......................." +
        "..............`=-,...................,%`>--==``......." +
              "\n        ........................................_)..........._,-%.......`)..............." +
              "\n        ...................................,<`.._|_,-&``................`)..............</pre>";

        ArrayList<String> content = new ArrayList<>();
        content.add(str);
        return ok(layout.render("mehmehmehmehmeh", content));
        }
        }