package com.yhark.repository;

import java.util.ArrayList;
import java.util.List;

import com.yhark.model.Activity;
import com.yhark.model.ActivitySearch;
import com.yhark.model.User;





public class ActivityRepositoryStub implements IActivityRepository {

	public List<Activity> findAllActivities(){
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity activity1 = new Activity();
		activity1.setDescription("swimming");
		activity1.setDuration(55);
		activities.add(activity1);
		
		Activity activity2 = new Activity();
		activity2.setDescription("cycling");
		activity2.setDuration(120);
		activities.add(activity2);
		
		return activities;
	}

	public Activity findActivity(String actvityId) {
		
		if(actvityId.equals("7777")){
			return null;
		}
		
		Activity activity1 = new Activity();
		activity1.setId("1234");
		activity1.setDescription("swimming");
		activity1.setDuration(55);
		
		User user = new User();
		user.setId("5678");
		user.setName("youssef");
		activity1.setUser(user);
		
		return activity1;
	}

	public void create(Activity activity) {
		//should issue an insert statement
		
	}

	@Override
	public Activity update(Activity activity) {
		// search the db
		//select * from activity where id = ?
		//if rs size == 0
		//insert into activity table
		//else
		//update the activity 
		
		return activity;
		
	}

	@Override
	public void delete(String activityId) {
		// delete from activity where activityId = ?
		
	}

	@Override
	public List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo) {
		//select * from activity where description in(?,?,?) and duration > ? and duration < ?;
		List<Activity> activities = new ArrayList<Activity>();
		Activity activity = new Activity();
		activity.setId("2345");
		activity.setDescription("swimmmmm");
		activity.setDuration(89);
		
		activities.add(activity);
		return activities;
	}

	@Override
	public List<Activity> findByConstraints(ActivitySearch search) {
		List<Activity> activities = new ArrayList<Activity>();
		Activity activity = new Activity();
		activity.setId("2345");
		activity.setDescription("swimmmmm");
		activity.setDuration(89);
		
		activities.add(activity);
		return activities;
	}
}
