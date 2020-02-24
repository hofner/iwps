package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the READINESS_RECORD_STATUS database table.
 * 
 */
@Entity
@Table(name="READINESS_RECORD_STATUS")
@NamedQuery(name="ReadinessRecordStatus.findAll", query="SELECT r FROM ReadinessRecordStatus r")
/**
 * 
 * @author ejelgoz
 *
 */
public class ReadinessRecordStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_READINESS_RECORD_STATUS")
	private long idReadinessRecordStatus;

	private String name;

	//bi-directional many-to-one association to ReadinessRecord
	@OneToMany(mappedBy="readinessRecordStatus")
	private List<ReadinessRecord> readinessRecords;

	public ReadinessRecordStatus() {
	}

	public long getIdReadinessRecordStatus() {
		return this.idReadinessRecordStatus;
	}

	public void setIdReadinessRecordStatus(long idReadinessRecordStatus) {
		this.idReadinessRecordStatus = idReadinessRecordStatus;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ReadinessRecord> getReadinessRecords() {
		return this.readinessRecords;
	}

	public void setReadinessRecords(List<ReadinessRecord> readinessRecords) {
		this.readinessRecords = readinessRecords;
	}

	public ReadinessRecord addReadinessRecord(ReadinessRecord readinessRecord) {
		getReadinessRecords().add(readinessRecord);
		readinessRecord.setReadinessRecordStatus(this);

		return readinessRecord;
	}

	public ReadinessRecord removeReadinessRecord(ReadinessRecord readinessRecord) {
		getReadinessRecords().remove(readinessRecord);
		readinessRecord.setReadinessRecordStatus(null);

		return readinessRecord;
	}

}