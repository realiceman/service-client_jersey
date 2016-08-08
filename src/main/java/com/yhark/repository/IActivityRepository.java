package com.yhark.repository;

import java.util.List;

import com.yhark.model.Activity;
import com.yhark.model.ActivitySearch;



public interface IActivityRepository {

	List<Activity> findAllActivities();

	Activity findActivity(String actvityId);

	void create(Activity activity);

	Activity update(Activity activity);

	void delete(String activityId);

	List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo);

	List<Activity> findByConstraints(ActivitySearch search);

}