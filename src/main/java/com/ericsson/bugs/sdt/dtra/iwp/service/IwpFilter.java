package com.ericsson.bugs.sdt.dtra.iwp.service;

import java.util.ArrayList;
import java.util.List;

import com.ericsson.bugs.sdt.dtra.iwp.data.model.IwpCast;
import com.ericsson.bugs.sdt.dtra.iwp.data.model.ReadinessRecordError;

/**
 * @author ejuaolg
 *
 */
public class IwpFilter {
	/**
	 * Filtered iwps(withErrors in Validation) 
	 */
	private List<IwpCast> iwpsWithError;
	private List<IwpCast> iwpsPreList;
	private List<ReadinessRecordError> errorsList;
	
	public IwpFilter() {
		iwpsWithError = new ArrayList<IwpCast>();
		iwpsPreList = new ArrayList<IwpCast>();
		errorsList = new ArrayList<ReadinessRecordError>();
	}
	public List<IwpCast> getIwpsWithError() {
		return iwpsWithError;
	}
	public void setIwpsWithError(List<IwpCast> iwpsWithError) {
		this.iwpsWithError = iwpsWithError;
	}
	public List<IwpCast> getIwpsPreList() {
		return iwpsPreList;
	}
	public void setIwpsPreList(List<IwpCast> iwpsPreList) {
		this.iwpsPreList = iwpsPreList;
	}
	public List<ReadinessRecordError> getErrorsList() {
		return errorsList;
	}
	public void setErrorsList(List<ReadinessRecordError> errorsList) {
		this.errorsList = errorsList;
	}

}
