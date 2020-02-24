package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the READINESS_FILE database table.
 * 
 */
@Entity
@Table(name="READINESS_FILE")
@NamedQuery(name="ReadinessFile.findAll", query="SELECT r FROM ReadinessFile r")
/**
 * 
 * @author ejelgoz
 *
 */
public class ReadinessFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_READINESS_FILE")
	private long idReadinessFile;

	private String crc;

	@Column(name="DOWNLOAD_DATE")
	private Timestamp downloadDate;

	@Column(name="DOWNLOAD_SUCCESS")
	private String downloadSuccess;

	@Column(name="ERROR_MESSAGE")
	private String errorMessage;

	@Column(name="FILE_NAME")
	private String fileName;

	//bi-directional many-to-many association to ReadinessRecord
	@ManyToMany(mappedBy="readinessFiles")
	private List<ReadinessRecord> readinessRecords;

	public ReadinessFile() {
	}

	public long getIdReadinessFile() {
		return this.idReadinessFile;
	}

	public void setIdReadinessFile(long idReadinessFile) {
		this.idReadinessFile = idReadinessFile;
	}

	public String getCrc() {
		return this.crc;
	}

	public void setCrc(String crc) {
		this.crc = crc;
	}

	public Timestamp getDownloadDate() {
		return this.downloadDate;
	}

	public void setDownloadDate(Timestamp downloadDate) {
		this.downloadDate = downloadDate;
	}

	public String getDownloadSuccess() {
		return this.downloadSuccess;
	}

	public void setDownloadSuccess(String downloadSuccess) {
		this.downloadSuccess = downloadSuccess;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<ReadinessRecord> getReadinessRecords() {
		return this.readinessRecords;
	}

	public void setReadinessRecords(List<ReadinessRecord> readinessRecords) {
		this.readinessRecords = readinessRecords;
	}

}