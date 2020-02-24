package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the WORKPACKAGE_FILE database table.
 * 
 */
@Entity
@Table(name="WORKPACKAGE_FILE")
@NamedQuery(name="WorkpackageFile.findAll", query="SELECT w FROM WorkpackageFile w")
/**
 * 
 * @author ejelgoz
 *
 */
public class WorkpackageFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_WORKPACKAGE_FILE")
	private long idWorkpackageFile;

	@Column(name="FILE_PATH")
	private String filePath;

	@Column(name="GENERATION_TIME")
	private Timestamp generationTime;

	//bi-directional many-to-many association to ReadinessRecord
	@ManyToMany
	@JoinTable(
		name="WORKPACKAGE_FILE_REFERENCE"
		, joinColumns={
			@JoinColumn(name="ID_WORKPACKAGE_FILE")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_READINESS_RECORD", referencedColumnName="ID_READINESS_RECORD"),
			@JoinColumn(name="IWP_ID", referencedColumnName="IWP_ID")
			}
		)
	private List<ReadinessRecord> readinessRecords;

	public WorkpackageFile() {
	}

	public long getIdWorkpackageFile() {
		return this.idWorkpackageFile;
	}

	public void setIdWorkpackageFile(long idWorkpackageFile) {
		this.idWorkpackageFile = idWorkpackageFile;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Timestamp getGenerationTime() {
		return this.generationTime;
	}

	public void setGenerationTime(Timestamp generationTime) {
		this.generationTime = generationTime;
	}

	public List<ReadinessRecord> getReadinessRecords() {
		return this.readinessRecords;
	}

	public void setReadinessRecords(List<ReadinessRecord> readinessRecords) {
		this.readinessRecords = readinessRecords;
	}

}