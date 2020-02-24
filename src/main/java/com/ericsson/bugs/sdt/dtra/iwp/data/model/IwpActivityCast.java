package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * The persistent class for the IWP_ACTIVITY_CAST database table.
 * 
 */
@Entity
@Table(name="IWP_ACTIVITY_CAST")
@SequenceGenerator(name="IWP_ACTIVITY_CAST_SEQ", sequenceName="IWP_ACTIVITY_CAST_SEQ", allocationSize=1)
@NamedQuery(name="IwpActivityCast.findAll", query="SELECT i FROM IwpActivityCast i")
public class IwpActivityCast implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="IWP_ACTIVITY_CAST_SEQ")
	@Column(name="ID_IWP_ACTIVITY_CAST")
	private long idIwpActivityCast;

	@Column(name="ACTIVITY_CODE")
	private String activityCode;

	@Column(name="ACTIVITY_COST")
	private Double activityCost;

	@Column(name="ACTIVITY_COUNT")
	private Integer activityCount;
	

	@Column(name="ACTIVITY_COUNTRY")
	private String activityCountry;

	@Column(name="ACTIVITY_CURRENCY")
	private String activityCurrency;

	@Column(name="ACTIVITY_DOMAIN")
	private String activityDomain;

	@Column(name="ACTIVITY_DURATION")
	private String activityDuration;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTIVITY_END_DATE")
	private Date activityEndDate;

	@Column(name="ACTIVITY_NAME")
	private String activityName;

	@Column(name="ACTIVITY_NORM_HOUR_STATUS")
	private String activityNormHourStatus;

	@Column(name="ACTIVITY_SERIAL_ID")
	private Integer activitySerialId;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTIVITY_START_DATE")
	private Date activityStartDate;

	@Column(name="ACTIVITY_SUBDOMAIN")
	private String activitySubdomain;

	@Column(name="ACTIVITY_TIME")
	private Double activityTime;

	@Column(name="ACTIVITY_TOTAL_HOURS")
	private String activityTotalHours;

	@Column(name="DEPENDENT_ACTIVITIES")
	private String dependentActivities;

	@Column(name="JOB_ROLE")
	private String jobRole;

	@Column(name="JOB_STAGE")
	private String jobStage;

	@Column(name="REGIONAL_RESOURCE_AREA")
	private String regionalResourceArea;

	@Column(name="WP_TITLE")
	private String wpTitle;
	
	@Column(name="DTRA_TOTAL_HOURS")
	private Integer dtraTotalHours;
	
	@Column(name="DTRA_SERIAL_ID")
	private Integer dtraSerialId;
	
	@Transient
	private Integer WPQuantity;

	//bi-directional many-to-one association to IwpCast
	@ManyToOne
	@JoinColumn(name="ID_IWP_CAST")
	private IwpCast iwpCast;

	public IwpActivityCast() {
	}

	public long getIdIwpActivityCast() {
		return this.idIwpActivityCast;
	}

	public void setIdIwpActivityCast(long idIwpActivityCast) {
		this.idIwpActivityCast = idIwpActivityCast;
	}

	public String getActivityCode() {
		return this.activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public Double getActivityCost() {
		return this.activityCost;
	}

	public void setActivityCost(Double activityCost) {
		this.activityCost = activityCost;
	}

	public Integer getActivityCount() {
		return this.activityCount;
	}
	
	

	public void setActivityCount(Integer activityCount) {
		this.activityCount = activityCount;
	}
	


	public String getActivityCountry() {
		return this.activityCountry;
	}

	public void setActivityCountry(String activityCountry) {
		this.activityCountry = activityCountry;
	}

	public String getActivityCurrency() {
		return this.activityCurrency;
	}

	public void setActivityCurrency(String activityCurrency) {
		this.activityCurrency = activityCurrency;
	}

	public String getActivityDomain() {
		return this.activityDomain;
	}

	public void setActivityDomain(String activityDomain) {
		this.activityDomain = activityDomain;
	}

	public String getActivityDuration() {
		return this.activityDuration;
	}

	public void setActivityDuration(String activityDuration) {
		this.activityDuration = activityDuration;
	}

	public Date getActivityEndDate() {
		return this.activityEndDate;
	}

	public void setActivityEndDate(Date activityEndDate) {
		this.activityEndDate = activityEndDate;
	}

	public String getActivityName() {
		return this.activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityNormHourStatus() {
		return this.activityNormHourStatus;
	}

	public void setActivityNormHourStatus(String activityNormHourStatus) {
		this.activityNormHourStatus = activityNormHourStatus;
	}

	public Integer getActivitySerialId() {
		return this.activitySerialId;
	}

	public void setActivitySerialId(   Integer activitySerialId) {
		this.activitySerialId = activitySerialId;
	}

	public Date getActivityStartDate() {
		return this.activityStartDate;
	}

	public void setActivityStartDate(Date activityStartDate) {
		this.activityStartDate = activityStartDate;
	}

	public String getActivitySubdomain() {
		return this.activitySubdomain;
	}

	public void setActivitySubdomain(String activitySubdomain) {
		this.activitySubdomain = activitySubdomain;
	}

	public Double getActivityTime() {
		return this.activityTime;
	}

	public void setActivityTime(Double activityTime) {
		this.activityTime = activityTime;
	}

	public String getActivityTotalHours() {
		return this.activityTotalHours;
	}

	public void setActivityTotalHours(String activityTotalHours) {
		this.activityTotalHours = activityTotalHours;
	}

	public String getDependentActivities() {
		return this.dependentActivities;
	}

	public void setDependentActivities(String dependentActivities) {
		this.dependentActivities = dependentActivities;
	}

	public String getJobRole() {
		return this.jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getJobStage() {
		return this.jobStage;
	}

	public void setJobStage(String jobStage) {
		this.jobStage = jobStage;
	}

	public String getRegionalResourceArea() {
		return this.regionalResourceArea;
	}

	public void setRegionalResourceArea(String regionalResourceArea) {
		this.regionalResourceArea = regionalResourceArea;
	}

	public String getWpTitle() {
		return this.wpTitle;
	}

	public void setWpTitle(String wpTitle) {
		this.wpTitle = wpTitle;
	}

	public IwpCast getIwpCast() {
		return this.iwpCast;
	}

	public void setIwpCast(IwpCast iwpCast) {
		this.iwpCast = iwpCast;
	}

	public Integer getDtraTotalHours() {
		return dtraTotalHours;
	}

	public void setDtraTotalHours(Integer dtraTotalHours) {
		this.dtraTotalHours = dtraTotalHours;
	}

	public Integer getDtraSerialId() {
		return dtraSerialId;
	}

	public void setDtraSerialId(Integer dtraSerialId) {
		this.dtraSerialId = dtraSerialId;
	}

	public Integer getWP_Quantity() {
		return this.WPQuantity;
	}

	public void setWP_Quantity(Integer WP_Quantity) {
		this.WPQuantity = WP_Quantity;
	}

}