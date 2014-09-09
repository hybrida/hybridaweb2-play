package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import views.html.layoutHtml;
import views.html.lolContent;
import java.sql.*;
import play.db.*;
import play.mvc.*;


import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by eliasbragstadhagen on 06.09.14.
 */
public class Lol extends Controller{

    public static ArrayList<String> savedNames = new ArrayList<String>();

    public static Result index(String name){
        ArrayList<String> content = new ArrayList<String>();
        if (name != null){
            savedNames.add("<p><h2>"+name+"</h2></p>");
        }
        for (int i = 0; i < savedNames.size(); i++ ){
            content.add(savedNames.get(i));
        }




        return ok(layoutHtml.render("Hybrida MLG proffesional LoL team: ", lolContent.render(content)));
    }
        public static Result noindex(){
            ArrayList<String> content = new ArrayList<String>();
            for (int i = 0; i < savedNames.size(); i++ ){
                content.add(savedNames.get(i));
            }

            return ok(layoutHtml.render("Hybrida MLG proffesional LoL team: ", lolContent.render(content)));
        }

    public static Html toHtml(ArrayList<String> list){

        String string = "";
        for (int i = 0; i < list.size(); i++){
            string += list.get(i);
        }
        return play.twirl.api.Html.apply(string);
    }

    public static ArrayList<String> getNameData() throws SQLException{
        javax.sql.DataSource ds = DB.getDataSource();
        java.sql.Connection connection = ds.getConnection("sa", "");
        java.sql.Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery("SELECT * FROM names");


       }
    }

}


