package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the SERVICE_AREA database table.
 * 
 */
@Entity
@Table(name="SERVICE_AREA")
@NamedQuery(name="ServiceArea.findAll", query="SELECT s FROM ServiceArea s")
/**
 * 
 * @author ejelgoz
 *
 */
public class ServiceArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_SERVICE_AREA")
	private long idServiceArea;

	@Column(name="NAME")
	private String name;

	

	public ServiceArea() {
	}

	public long getIdServiceArea() {
		return this.idServiceArea;
	}

	public void setIdServiceArea(long idServiceArea) {
		this.idServiceArea = idServiceArea;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

}