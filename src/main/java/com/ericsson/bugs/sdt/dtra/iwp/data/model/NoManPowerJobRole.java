package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the SETTING database table.
 * 
 */
@Entity
@Table(name="NO_MANPOWER_JOBROLE")
@NamedQuery(name="NoManPowerJobRole.findAll", query="SELECT s FROM NoManPowerJobRole s")
/**
 * 
 * @author ejuaolg
 *
 */
public class NoManPowerJobRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_JOB_ROLE")
	private long idJobRole;
	
	@Column(name="NAME")
	private String name;
	
	public NoManPowerJobRole() {
	}

	public long getIdJobRole() {
		return idJobRole;
	}

	public void setIdJobRole(long idJobRole) {
		this.idJobRole = idJobRole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	

	

}