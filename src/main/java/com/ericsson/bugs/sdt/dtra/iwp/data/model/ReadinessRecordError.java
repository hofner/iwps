package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the READINESS_RECORD_ERROR database table.
 * 
 */
@Entity
@Table(name="READINESS_RECORD_ERROR")
@NamedQuery(name="ReadinessRecordError.findAll", query="SELECT r FROM ReadinessRecordError r")
/**
 * 
 * @author ejelgoz
 *
 */
public class ReadinessRecordError implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_READINESS_RECORD_ERROR")
	private long idReadinessRecordError;

	@Column(name="IWP_ID")
	private String iwpId;
	
	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="IWPCODE_VERSION")
	private String iwpcodeVersion;

	@Column(name="SERVICE_AREA")
	private String serviceArea;
	
	@Column(name="COMPETENCE_DOMAIN")
	private String competenceDomain;
	
	@Column(name="COMPETENCE_SUBDOMAIN")
	private String competenceSubDomain;
	
	

	public ReadinessRecordError() {
	}



	public long getIdReadinessRecordError() {
		return idReadinessRecordError;
	}



	public void setIdReadinessRecordError(long idReadinessRecordError) {
		this.idReadinessRecordError = idReadinessRecordError;
	}



	public String getIwpId() {
		return iwpId;
	}



	public void setIwpId(String iwpId) {
		this.iwpId = iwpId;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getIwpcodeVersion() {
		return iwpcodeVersion;
	}



	public void setIwpcodeVersion(String iwpcodeVersion) {
		this.iwpcodeVersion = iwpcodeVersion;
	}



	public String getServiceArea() {
		return serviceArea;
	}



	public void setServiceArea(String serviceArea) {
		this.serviceArea = serviceArea;
	}



	public String getCompetenceDomain() {
		return competenceDomain;
	}



	public void setCompetenceDomain(String competenceDomain) {
		this.competenceDomain = competenceDomain;
	}



	public String getCompetenceSubDomain() {
		return competenceSubDomain;
	}



	public void setCompetenceSubDomain(String competenceSubDomain) {
		this.competenceSubDomain = competenceSubDomain;
	}

	

	

}