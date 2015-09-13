package no.liven.loftro.db;

import static no.liven.web.loftro.generated.tables.Afterhours.AFTERHOURS;
import static org.jooq.impl.DSL.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import no.liven.web.loftro.generated.tables.records.AfterhoursRecord;

public class DatabaseHandler {
	
	private ArrayList<AfterhoursRecord> ahrl;
	
    public DatabaseHandler() {
        String userName = "loftro";
        String password = "loftro";
        String url = "jdbc:mysql://52.11.19.84:3306/loftro";
        
        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
        	DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        	Result<Record> result = create.select().from(AFTERHOURS).fetch();
        	ahrl = new ArrayList<AfterhoursRecord>();
        	for (Record r : result) {
        	    Integer id = r.getValue(AFTERHOURS.ID);
        	    String type = r.getValue(AFTERHOURS.TYPE);
        	    String name = r.getValue(AFTERHOURS.NAME);
        	    String review = r.getValue(AFTERHOURS.REVIEW);
        	    Double rate = r.getValue(AFTERHOURS.RATE);
                ahrl.add(new AfterhoursRecord(id, type, review, name, rate));
        	    System.out.println("ID: " + id + " first name: " + name + " last name: " + type);
        	}
        } 

        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<AfterhoursRecord> getAfterHoursRecords(){
    	if(ahrl != null) {
    	  return ahrl;
    	}
    	return null;
    }
}
