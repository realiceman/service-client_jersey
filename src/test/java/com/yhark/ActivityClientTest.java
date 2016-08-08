package com.yhark;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yhark.client.ActivityClient;
import com.yhark.client.ActivitySearchClient;
import com.yhark.model.Activity;
import com.yhark.model.ActivitySearch;

public class ActivityClientTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testSearchObject(){
		ActivitySearchClient client = new ActivitySearchClient();
		
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("biking");
		searchValues.add("fighting");
		
		ActivitySearch search = new ActivitySearch();
		search.setDescriptions(searchValues);
		search.setDurationFrom(30);
		search.setDurationTo(55);
		
		List<Activity> activities = client.search(search);
		
		System.out.println(activities);
		assertNotNull(activities);
	}
	
	@Test
	public void testSearch(){
		ActivitySearchClient client = new ActivitySearchClient();
		String param = "description";
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("swimmmmingggg");
		searchValues.add("runnnnnn");
		
		String secondParam = "durationFrom";
		int durationFrom = 30;
		
		String thirdParam = "durationTo";
		int durationTo = 25;
		
		List<Activity> activities = client.search(param, searchValues, secondParam, durationFrom, thirdParam, durationTo);
		
		//System.out.println(activities);
		
		assertNotNull(activities);
	}
	
	
	@Test
	public void testDelete(){
		ActivityClient client = new ActivityClient();
		client.delete("1234");
	}

	@Test
	public void testPut(){
		Activity activity = new Activity();
		
		activity.setId("3456");
        activity.setDescription("yoga");
        activity.setDuration(90);
        
        ActivityClient client = new ActivityClient();
        
        client.update(activity);
        
        assertNotNull(activity);
	}
	
	@Test
	public void testCreate(){
ActivityClient client = new ActivityClient();
		
		Activity activity = new Activity();
		activity.setDescription("fighting");
		activity.setDuration(90);
		
		activity = client.create(activity);
		
		assertNotNull(activity);
	}
	
	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		
		Activity activity = client.get("1234");
		
		System.out.println(activity);
		assertNotNull(activity);
	}
	
	
	@Test
	public void test1(){
		String one = "string";
		String two = "string";
		
		assertNotNull(two);
	}
	
	@Test
	public void testGetList(){
		ActivityClient client = new ActivityClient();
		List<Activity> activities = client.get();
		
		assertNotNull(activities);
	}
	
	
	@Test(expected=RuntimeException.class)
	public void testGetWithBadRequest(){
		ActivityClient client = new ActivityClient();
		
		client.get("123");
	}
	
	
	@Test(expected=RuntimeException.class)
	public void testGetWithNoFound(){
		ActivityClient client = new ActivityClient();
		
		client.get("7777");
	}
	

}
