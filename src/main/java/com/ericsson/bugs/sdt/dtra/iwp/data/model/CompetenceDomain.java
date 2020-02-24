package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the COMPETENCE_DOMAIN database table.
 * 
 */
@Entity
@Table(name="COMPETENCE_DOMAIN")
@NamedQuery(name="CompetenceDomain.findAll", query="SELECT c FROM CompetenceDomain c")
/**
 * 
 * @author ejelgoz
 *
 */
public class CompetenceDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_COMPETENCE_DOMAIN")
	private long idCompetenceDomain;

	@Column(name="NAME")
	private String name;

	

	public CompetenceDomain() {
	}

	public long getIdCompetenceDomain() {
		return this.idCompetenceDomain;
	}

	public void setIdCompetenceDomain(long idCompetenceDomain) {
		this.idCompetenceDomain = idCompetenceDomain;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	

}