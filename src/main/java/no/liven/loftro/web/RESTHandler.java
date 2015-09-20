package no.liven.loftro.web;

import no.liven.loftro.db.DatabaseHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
	import javax.ws.rs.Path;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
	 
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
	     * @throws IOException 
	     * @throws JsonMappingException 
	     * @throws JsonParseException 
	     */
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public String getIt() throws JsonParseException, JsonMappingException, IOException {
	    	DatabaseHandler dbh = new DatabaseHandler();
	    	//HashMap<String,Object> result =
	    	  //      new ObjectMapper().readValue(dbh.getAfterHoursRecords(), HashMap.class);
	    	ArrayList<Map<String,Object>> lm = (ArrayList<Map<String, Object>>) dbh.getAfterHoursRecords();
	    	System.out.println("######### : "+lm.toString());
	    
	    	/*JsonFactory jf = map.getJsonFactory();
	    	JsonNode jn = map.readTree(jf.createJsonParser(dbh.getAfterHoursRecords()));
	    	
	    	JsonToken jt = jn.asToken();*/
	        return new ObjectMapper()
	        		.writer()
	        		.withDefaultPrettyPrinter()
	        		.writeValueAsString(lm);
	    }
	}