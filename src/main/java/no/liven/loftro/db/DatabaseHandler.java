package no.liven.loftro.db;

import static no.liven.web.loftro.generated.tables.Afterhours.AFTERHOURS;

import java.sql.*;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;


public class DatabaseHandler {
	
	private String json;
	
    public DatabaseHandler() {
        String userName = "loftro";
        String password = "loftro";
        String url = "jdbc:mysql://52.11.19.84:3306/loftro";
        
        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
        	DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        	json = create.select().from(AFTERHOURS).fetch().formatJSON();
        } 

        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getAfterHoursRecords(){
    	  return json;
    }
}
