package com.inc.ericsson.spom.structure.lookup;

public class StructureLookupObj {
	private String competenceSubDomain;
	private String serviceArea;
	private String gsc;
	private String jobRole;

	public StructureLookupObj() {

	}

	public StructureLookupObj(String competenceSubDomain, String serviceArea, String gsc, String jobRole) {
		this.competenceSubDomain = competenceSubDomain;
		this.serviceArea = serviceArea;
		this.gsc = gsc;
		this.jobRole = jobRole;
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
