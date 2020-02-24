package com.inc.ericsson.spom.structure.lookup;

import java.util.List;

public class StructureLookupObjUpdated {
	private String iwpId;
	private String name;
	private String competenceSubDomain;
	private String serviceArea;
	private String gsc;
	private String jobRole;

	public StructureLookupObjUpdated() {
		super();
	}

	public StructureLookupInfoUpdated getDataF(String questions, List<String> data) {
		// TODO Auto-generated method stub
		return null;
	}

	public StructureLookupObjUpdated(String iwpId, String name, String competenceSubDomain, String serviceArea,
			String gsc, String jobRole) {

		this.iwpId = iwpId;
		this.name = name;
		this.competenceSubDomain = competenceSubDomain;
		this.serviceArea = serviceArea;
		this.gsc = gsc;
		this.jobRole = jobRole;
	}

	public String getIwpId() {
		return iwpId;
	}

	public void setIwpId(String iwpId) {
		this.iwpId = iwpId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompetenceSubDomain() {
		return competenceSubDomain;
	}

	public void setCompetenceSubDomain(String competenceSubDomain) {
		this.competenceSubDomain = competenceSubDomain;
	}

	public String getServiceArea() {
		return serviceArea;
	}

	public void setServiceArea(String serviceArea) {
		this.serviceArea = serviceArea;
	}

	public String getGsc() {
		return gsc;
	}

	public void setGsc(String gsc) {
		this.gsc = gsc;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

}
