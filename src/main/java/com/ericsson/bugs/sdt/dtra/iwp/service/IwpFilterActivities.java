package com.ericsson.bugs.sdt.dtra.iwp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ericsson.bugs.sdt.dtra.iwp.data.model.IwpActivityCast;

/**
 * @author ejuaolg
 *
 */
public class IwpFilterActivities {
	private String iwpUnique;
	
	/**
	 * Filtered activities(those that are no manpower) 
	 */
	private List<IwpActivityCast> activityList;
	private HashMap<Integer,IwpActivityCast> serialIDActivities;
	
	
	/**
	 * 
	 */
	public IwpFilterActivities(String iwpUnique) {
		this.iwpUnique = iwpUnique;
		activityList=new ArrayList<IwpActivityCast>();
		serialIDActivities = new HashMap<Integer,IwpActivityCast>();
	}


	public String getIwpUnique() {
		return iwpUnique;
	}


	public void setIwpUnique(String iwpUnique) {
		this.iwpUnique = iwpUnique;
	}


	public List<IwpActivityCast> getActivityList() {
		return activityList;
	}


	public void setActivityList(List<IwpActivityCast> activityList) {
		this.activityList = activityList;
	}


	public HashMap<Integer, IwpActivityCast> getSerialIDActivities() {
		return serialIDActivities;
	}


	public void setSerialIDActivities(HashMap<Integer, IwpActivityCast> serialIDActivities) {
		this.serialIDActivities = serialIDActivities;
	}


	
	
}
