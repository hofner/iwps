package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the IWPSRELATION database table.
 * 
 */
//@Entity
//@NamedQuery(name="Iwpsrelation.findAll", query="SELECT i FROM Iwpsrelation i")
/**
 * 
 * @author ejelgoz
 *
 */
public class Iwpsrelation implements Serializable {
	private static final long serialVersionUID = 1L;

	private String associationtype;

	@Column(name="\"CANCEL\"")
	private BigDecimal cancel;

	@Temporal(TemporalType.DATE)
	private Date cwcreated;

	private String cwcreatedby;

	private String cwdocstamp;

	private BigDecimal defaultquantity;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	private String groupsequence;

	private String itemcode;

	private String itemrelationcode;

	private String itemrelationtarget;

	private String itemrelationversionid;

	@Column(name="\"LABEL\"")
	private String label;

	@Temporal(TemporalType.DATE)
	private Date lastupdateddate;

	@Column(name="MAX_QUANTITY")
	private BigDecimal maxQuantity;

	@Column(name="MIN_QUANTITY")
	private BigDecimal minQuantity;

	private String name;

	private String ownerid;

	@Column(name="\"SEQUENCE\"")
	private BigDecimal sequence;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	private String status;

	private String updatedby;

	@Temporal(TemporalType.DATE)
	private Date versioncommitdate;

	public Iwpsrelation() {
	}

	public String getAssociationtype() {
		return this.associationtype;
	}

	public void setAssociationtype(String associationtype) {
		this.associationtype = associationtype;
	}

	public BigDecimal getCancel() {
		return this.cancel;
	}

	public void setCancel(BigDecimal cancel) {
		this.cancel = cancel;
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

	public BigDecimal getDefaultquantity() {
		return this.defaultquantity;
	}

	public void setDefaultquantity(BigDecimal defaultquantity) {
		this.defaultquantity = defaultquantity;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getGroupsequence() {
		return this.groupsequence;
	}

	public void setGroupsequence(String groupsequence) {
		this.groupsequence = groupsequence;
	}

	public String getItemcode() {
		return this.itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getItemrelationcode() {
		return this.itemrelationcode;
	}

	public void setItemrelationcode(String itemrelationcode) {
		this.itemrelationcode = itemrelationcode;
	}

	public String getItemrelationtarget() {
		return this.itemrelationtarget;
	}

	public void setItemrelationtarget(String itemrelationtarget) {
		this.itemrelationtarget = itemrelationtarget;
	}

	public String getItemrelationversionid() {
		return this.itemrelationversionid;
	}

	public void setItemrelationversionid(String itemrelationversionid) {
		this.itemrelationversionid = itemrelationversionid;
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

	public BigDecimal getMaxQuantity() {
		return this.maxQuantity;
	}

	public void setMaxQuantity(BigDecimal maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public BigDecimal getMinQuantity() {
		return this.minQuantity;
	}

	public void setMinQuantity(BigDecimal minQuantity) {
		this.minQuantity = minQuantity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerid() {
		return this.ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	public BigDecimal getSequence() {
		return this.sequence;
	}

	public void setSequence(BigDecimal sequence) {
		this.sequence = sequence;
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

	public String getUpdatedby() {
		return this.updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Date getVersioncommitdate() {
		return this.versioncommitdate;
	}

	public void setVersioncommitdate(Date versioncommitdate) {
		this.versioncommitdate = versioncommitdate;
	}

}