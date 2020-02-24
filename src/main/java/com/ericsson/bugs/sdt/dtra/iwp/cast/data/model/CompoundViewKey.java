package com.ericsson.bugs.sdt.dtra.iwp.cast.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompoundViewKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -512336786318573743L;

	@Column(name="IWPUniqueID")
	private String IWPUniqueID;
	
	@Column(name="ActivitySerialID")
	private Integer ActivitySerialID;

	public String getIWPUniqueID() {
		return IWPUniqueID;
	}

	public void setIWPUniqueID(String iWPUniqueID) {
		IWPUniqueID = iWPUniqueID;
	}

	public Integer getActivitySerialID() {
		return ActivitySerialID;
	}

	public void setActivitySerialID(Integer activitySerialID) {
		ActivitySerialID = activitySerialID;
	}
}