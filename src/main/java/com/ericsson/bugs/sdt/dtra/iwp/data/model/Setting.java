package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SETTING database table.
 * 
 */
@Entity
@Table(name="SETTING")
@NamedQuery(name="Setting.findAll", query="SELECT s FROM Setting s")
/**
 * 
 * @author ejuaolg
 *
 */
public class Setting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_SETTING")
	private long idSetting;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="VALUE")
	private String value;
	
	@Column(name="DESCRIPTION")
	private String description;
	

	public Setting() {
	}


	public long getIdSetting() {
		return idSetting;
	}


	public void setIdSetting(long idSetting) {
		this.idSetting = idSetting;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	

}