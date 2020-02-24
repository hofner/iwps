package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the READINESS_WORK_PACKAGE database table.
 * 
 */
@Entity
@Table(name="READINESS_WORK_PACKAGE")
@NamedQuery(name="ReadinessWorkPackage.findAll", query="SELECT r FROM ReadinessWorkPackage r")
/**
 * 
 * @author ejelgoz
 *
 */
public class ReadinessWorkPackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_WORK_PACKAGE")
	private long idWorkPackage;

	private String active;

	@Column(name="GENERATION_TIME")
	private Timestamp generationTime;

	@Column(name="TOTAL_TIME")
	private BigDecimal totalTime;

	//bi-directional many-to-one association to ReadinessRecord
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_READINESS_RECORD", referencedColumnName="ID_READINESS_RECORD"),
		@JoinColumn(name="IWP_ID", referencedColumnName="IWP_ID")
		})
	private ReadinessRecord readinessRecord;

	public ReadinessWorkPackage() {
	}

	public long getIdWorkPackage() {
		return this.idWorkPackage;
	}

	public void setIdWorkPackage(long idWorkPackage) {
		this.idWorkPackage = idWorkPackage;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Timestamp getGenerationTime() {
		return this.generationTime;
	}

	public void setGenerationTime(Timestamp generationTime) {
		this.generationTime = generationTime;
	}

	public BigDecimal getTotalTime() {
		return this.totalTime;
	}

	public void setTotalTime(BigDecimal totalTime) {
		this.totalTime = totalTime;
	}

	public ReadinessRecord getReadinessRecord() {
		return this.readinessRecord;
	}

	public void setReadinessRecord(ReadinessRecord readinessRecord) {
		this.readinessRecord = readinessRecord;
	}

}