package controllers;

import play.db.DB;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TestHome extends Controller{

    public static List<List<String>> getNews() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<List<String>> newsList = new ArrayList<>();
        try {
            connection = DB.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM feed ORDER BY id DESC");
            while (resultSet.next()){
                String newsID = new String();
                String newsTitle = new String();
                String newsContent = new String();
                newsID = resultSet.getString(1);
                newsTitle = resultSet.getString(2);
                newsContent = resultSet.getString(3);
                List<String> news = new ArrayList<>();
                news.add(newsID);
                news.add(newsTitle);
                news.add(newsContent);
                newsList.add(news);
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return newsList;
    }

    public static Result indexTest() throws SQLException{
        return ok(testHome.render(getNews()));
    }
}
