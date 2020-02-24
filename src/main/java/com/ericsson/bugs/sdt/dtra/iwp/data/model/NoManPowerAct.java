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
@Table(name="NO_MANPOWER_ACT")
@NamedQuery(name="NoManPowerAct.findAll", query="SELECT s FROM NoManPowerAct s")
/**
 * 
 * @author ejuaolg
 *
 */
public class NoManPowerAct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ACTIVITY")
	private long idActivity;
	
	@Column(name="NAME")
	private String name;
	
	public NoManPowerAct() {
	}

	public long getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(long idActivity) {
		this.idActivity = idActivity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	

	

}