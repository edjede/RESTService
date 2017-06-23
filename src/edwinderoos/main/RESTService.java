package edwinderoos.main;


/**
 * @author Edwin de Roos
 * 
 */
 
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
@Path("/")
public class RESTService {
	@POST
	@Path("/RESTService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response REST(InputStream incomingData) {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				stringBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + stringBuilder.toString());
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(stringBuilder.toString()).build();
	}
 
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "RESTService Successfully started..";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/AverageCalculation/{value1},{value2}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response AverageCalculation(@PathParam("value1") float value1 ,@PathParam("value2") float value2 )throws JSONException {
		String message;
		JSONObject json = new JSONObject();
		
		Average averageObj = new Average(value1,value2);
		averageObj.calculateAverage();
		
		float average = averageObj.getAverage();

		JSONArray array = new JSONArray();
		array.put(value1);
		array.put(value2);
		json.put("InputValues",array);
		json.put("Average", average);

		message = json.toString();
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(message).build();
	}
	@GET
	@Path("/WindmillPower/{windspeed}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response WindmillPower(@PathParam("windspeed") float windspeed)throws JSONException {
		String message;
		JSONObject json = new JSONObject();
		
		WindMill windmill = new WindMill(windspeed);
		windmill.calculatePower();

		json.put("Windspeed",windspeed);
		json.put("Power", windmill.getPower());

		message = json.toString();
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(message).build();
	}
 
}