package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the READINESS_RECORD database table.
 * 
 */
@Embeddable
/**
 * 
 * @author ejelgoz
 *
 */
public class ReadinessRecordPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_READINESS_RECORD")
	private long idReadinessRecord;

	@Column(name="IWP_ID")
	private String iwpId;

	public ReadinessRecordPK() {
	}
	public long getIdReadinessRecord() {
		return this.idReadinessRecord;
	}
	public void setIdReadinessRecord(long idReadinessRecord) {
		this.idReadinessRecord = idReadinessRecord;
	}
	public String getIwpId() {
		return this.iwpId;
	}
	public void setIwpId(String iwpId) {
		this.iwpId = iwpId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReadinessRecordPK)) {
			return false;
		}
		ReadinessRecordPK castOther = (ReadinessRecordPK)other;
		return 
			(this.idReadinessRecord == castOther.idReadinessRecord)
			&& this.iwpId.equals(castOther.iwpId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idReadinessRecord ^ (this.idReadinessRecord >>> 32)));
		hash = hash * prime + this.iwpId.hashCode();
		
		return hash;
	}
}