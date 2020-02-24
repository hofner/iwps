package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the COMPETENCE_SUB_DOMAIN database table.
 * 
 */
@Entity
@Table(name="COMPETENCE_SUB_DOMAIN")
@NamedQuery(name="CompetenceSubDomain.findAll", query="SELECT c FROM CompetenceSubDomain c")
/**
 * 
 * @author ejelgoz
 *
 */
public class CompetenceSubDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_COMPETENCE_SUB_DOMAIN")
	private long idCompetenceSubDomain;

	@Column(name="NAME")
	private String name;

	

	public CompetenceSubDomain() {
	}

	public long getIdCompetenceSubDomain() {
		return this.idCompetenceSubDomain;
	}

	public void setIdCompetenceSubDomain(long idCompetenceSubDomain) {
		this.idCompetenceSubDomain = idCompetenceSubDomain;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	

}