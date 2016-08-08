package com.yhark.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.yhark.model.Activity;


//
public class ActivityClient {

	private Client client;
	
	public ActivityClient(){
		client= ClientBuilder.newClient();
	}
	
	public Activity get(String id){
		
		WebTarget target = client.target("http://localhost:8080/exercise-services3/webapi/");
		
		Response response = target.path("activities/"+ id).request(MediaType.APPLICATION_JSON).get(Response.class);
		
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus()+ ": error on the server side.");
		}
		return response.readEntity(Activity.class);
		
	}
	
	
	public List<Activity> get(){
		WebTarget target = client.target("http://localhost:8080/exercise-services3/webapi/");
		
		List<Activity> response = target.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>(){});
		
		return response;
	}
	
	

	public Activity create(Activity activity) {
		WebTarget target = client.target("http://localhost:8080/exercise-services3/webapi/");
		
       Response response = target.path("activities/activity").request(MediaType.APPLICATION_JSON).post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus()+ ": error on the server side.");
		}
		return response.readEntity(Activity.class);
	}

	
	public Activity update(Activity activity) {
		WebTarget target = client.target("http://localhost:8080/exercise-services3/webapi/");
		Response response = target.path("activities/"+activity.getId())
				            .request(MediaType.APPLICATION_JSON)
				            .put(Entity.entity(activity, MediaType.APPLICATION_JSON));
			
		
		
		return response.readEntity(Activity.class);
		
	}

	public void delete(String activityId) {
		WebTarget target = client.target("http://localhost:8080/exercise-services3/webapi/");
		
		Response response = target.path("activities/"+activityId).request(MediaType.APPLICATION_JSON).delete();
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus()+ ": error on the server side.");
		}
		
	}
}
