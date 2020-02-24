package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the READINESS_STATUS database table.
 * 
 */
@Entity
@Table(name="READINESS_STATUS")
@NamedQuery(name="ReadinessStatus.findAll", query="SELECT r FROM ReadinessStatus r")
/**
 * 
 * @author ejelgoz
 *
 */
public class ReadinessStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_READINESS_STATUS")
	private long idReadinessStatus;

	private String name;

	public ReadinessStatus() {
	}

	public long getIdReadinessStatus() {
		return this.idReadinessStatus;
	}

	public void setIdReadinessStatus(long idReadinessStatus) {
		this.idReadinessStatus = idReadinessStatus;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}