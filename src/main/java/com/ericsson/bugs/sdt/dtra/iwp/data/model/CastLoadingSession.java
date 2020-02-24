package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the CAST_LOADING_SESSIONS database table.
 * 
 */
@Entity
@Table(name="CAST_LOADING_SESSIONS")
@NamedQuery(name="CastLoadingSession.findAll", query="SELECT c FROM CastLoadingSession c")
public class CastLoadingSession implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_LOADING")
	private Long idLoading;

	@Temporal(TemporalType.DATE)
	@Column(name="LOADING_DATE")
	private Date loadingDate;

	public CastLoadingSession() {
	}

	public Long getIdLoading() {
		return this.idLoading;
	}

	public void setIdLoading(Long idLoading) {
		this.idLoading = idLoading;
	}

	public Date getLoadingDate() {
		return this.loadingDate;
	}

	public void setLoadingDate(Date loadingDate) {
		this.loadingDate = loadingDate;
	}

}