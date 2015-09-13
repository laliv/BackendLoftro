package no.liven.loftro.web;

import no.liven.loftro.db.DatabaseHandler;
import no.liven.web.loftro.generated.tables.records.AfterhoursRecord;

import java.util.ArrayList;

import javax.ws.rs.GET;
	import javax.ws.rs.Path;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;
	 
	/**
	 * Root resource (exposed at "myresource" path)
	 */
	@Path("resthandler")
	public class RESTHandler {
	 
	    /**
	     * Method handling HTTP GET requests. The returned object will be sent
	     * to the client as "text/plain" media type.
	     *
	     * @return String that will be returned as a text/plain response.
	     */
	    @GET
	    @Produces(MediaType.TEXT_PLAIN)
	    public String getIt() {
	    	DatabaseHandler dbh = new DatabaseHandler();
	    	ArrayList<AfterhoursRecord> ahrl = dbh.getAfterHoursRecords();
	    	StringBuffer sb = new StringBuffer();
	    	for (AfterhoursRecord a : ahrl) {
	    		sb.append("Name: " + a.getName());
	    		sb.append("Type: " + a.getType());
	    	}
	        return sb.toString();
	    }
	}