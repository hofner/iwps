package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the IWPS database table.
 * 
 */
//@Entity
//@Table(name="IWPS")
@NamedQuery(name="Iwp.findAll", query="SELECT i FROM Iwp i")
/**
 * 
 * @author ejelgoz
 *
 */
public class Iwp implements Serializable {
	private static final long serialVersionUID = 1L;

	private String baseitemcode;

	private String classificationtypes;

	@Temporal(TemporalType.DATE)
	private Date cwcreated;

	private String cwcreatedby;

	private String cwdocstamp;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	private BigDecimal enforceactions;

	private String itemcode;

	private String itemtype;

	@Column(name="\"LABEL\"")
	private String label;

	@Temporal(TemporalType.DATE)
	private Date lastupdateddate;

	private String name;

	private BigDecimal orderable;

	private String ownerid;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	private String status;

	@Column(name="\"TYPE\"")
	private BigDecimal type;

	private String updatedby;

	public Iwp() {
	}

	public String getBaseitemcode() {
		return this.baseitemcode;
	}

	public void setBaseitemcode(String baseitemcode) {
		this.baseitemcode = baseitemcode;
	}

	public String getClassificationtypes() {
		return this.classificationtypes;
	}

	public void setClassificationtypes(String classificationtypes) {
		this.classificationtypes = classificationtypes;
	}

	public Date getCwcreated() {
		return this.cwcreated;
	}

	public void setCwcreated(Date cwcreated) {
		this.cwcreated = cwcreated;
	}

	public String getCwcreatedby() {
		return this.cwcreatedby;
	}

	public void setCwcreatedby(String cwcreatedby) {
		this.cwcreatedby = cwcreatedby;
	}

	public String getCwdocstamp() {
		return this.cwdocstamp;
	}

	public void setCwdocstamp(String cwdocstamp) {
		this.cwdocstamp = cwdocstamp;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public BigDecimal getEnforceactions() {
		return this.enforceactions;
	}

	public void setEnforceactions(BigDecimal enforceactions) {
		this.enforceactions = enforceactions;
	}

	public String getItemcode() {
		return this.itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getItemtype() {
		return this.itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getLastupdateddate() {
		return this.lastupdateddate;
	}

	public void setLastupdateddate(Date lastupdateddate) {
		this.lastupdateddate = lastupdateddate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getOrderable() {
		return this.orderable;
	}

	public void setOrderable(BigDecimal orderable) {
		this.orderable = orderable;
	}

	public String getOwnerid() {
		return this.ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getType() {
		return this.type;
	}

	public void setType(BigDecimal type) {
		this.type = type;
	}

	public String getUpdatedby() {
		return this.updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

}