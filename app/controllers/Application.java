package controllers;

import play.*;
import play.mvc.*;
import views.html.*;


import play.db.*;


public class Application extends Controller {

    public static Result index() throws java.sql.SQLException {

    	javax.sql.DataSource ds = DB.getDataSource();
    	java.sql.Connection dc = ds.getConnection();
    	java.sql.Statement st = dc.createStatement();
  		java.sql.ResultSet re = st.executeQuery("SELECT * FROM users");

  		java.util.ArrayList<String> names = new java.util.ArrayList<String>();
  		for (int i = 1;; ++i)
		{
			boolean x = re.absolute(i);
			if (!x)
				break;
			String str = re.getString("name");
			names.add(str);
		}

    	return ok(layout.render("Hybrida", names));
    }

    public static Result getter(String str) {
    	return ok("A message was recorded: " + str);
    }

}