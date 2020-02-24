package com.ericsson.bugs.sdt.dtra.iwp.cast.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the vDTRAIntegration database table.
 * 
 */
@Entity
@Table(name="vDTRAIntegration")
@NamedQuery(name="VDTRAIntegration.findAll", query="SELECT v FROM VDTRAIntegration v")
/**
 * 
 * @author ejelgoz
 *
 */
public class VDTRAIntegration implements Serializable {
	
	
	private static final long serialVersionUID = 4665048209433186283L;
	
	/*@Id
    @Column(name="IWPUniqueID")
	private String IWPUniqueID;
	@Column(name="ActivitySerialID" )
    private Integer ActivitySerialID;
	*/
	
	
	
	
	@EmbeddedId
	private CompoundViewKey idCompound;
	
	@Column(name="IWPID")
	private String iwpid;
	@Column(name="ActivityCode")
	private String activityCode;

	
	@Column(name="ActivityCountry")
	private String activityCountry;

	@Column(name="ActivityDomain")
	private String activityDomain;

	@Column(name="ActivityDuration")
	private String activityDuration;

	@Column(name="ActivityEndDate")
	private Date activityEndDate;

	@Column(name="ActivityName")
	private String activityName;

	@Column(name="ActivityNormHourStatus")
	private String activityNormHourStatus;
	
    @Column(name="JobRole")
    private String jobRole;

    @Column(name="ActivityTotalHours")
    private String activityTotalHours;
	
	@Column(name="ActivityCount")
    private Integer activityCount;

	@Column(name="ActivityStartDate")
	private Date ActivityStartDate;

	@Column(name="ActivitySubDomain")
	private String activitySubDomain;
	
	@Column(name="ActivityCost")
	private Double ActivityCost;
	
	@Column(name="ActivityCurrency")
	private String ActivityCurrency;
	
	@Column(name="ActivityTime")
	private Double ActivityTime;

	@Column(name="Link1")
	private String link1;
	@Column(name="Link2")
    private String link2;
	@Column(name="Link3")
    private String link3;
	@Column(name="OtherLinks")
    private String otherLinks;
	@Column(name="WPTitle")
    private String WPTitle;
	
	
	
	@Column(name="DependentActivities")
	private String dependentActivities;

    @Column(name="JobStage")
    private String jobStage;

    @Column(name="LastUpdatedDate")
    private Date lastUpdatedDate;

    @Column(name="RegionalResourceArea")
    private String regionalResourceArea;

    @Column(name="Version")
    private String version;

    @Column(name="IWPCostCategory")
	private String IWPCostCategory;

    @Column(name="IWPCostStatus")
	private String IWPCostStatus;

    @Column(name="IWPDeliveryOrigin")
	private String IWPDeliveryOrigin;

    @Column(name="IWPDomain")
	private String IWPDomain;

    @Column(name="IWPExpiryDate")
	private Date IWPExpiryDate;

    @Column(name="IWPFireCode")
	private String IWPFireCode;
	
	@Column(name="WP_Quantity")
	private Integer WPQuantity;

	
    @Column(name="IWPOrderingOrigin")
	private String IWPOrderingOrigin;

    @Column(name="IWPServiceActivityArea")
	private String IWPServiceActivityArea;

    @Column(name="IWPSubDomain")
	private String IWPSubDomain;

    @Column(name="IWPTitle")
    private String IWPTitle;
    @Column(name="ScenarioTitle")
    private String ScenarioTitle;
	
    @Column(name="IWPType")
	private String IWPType;

    @Column(name="IWPUnit")
	private String IWPUnit;
	
    @Column(name="IsLatestData")
	private Integer IsLatestData;
    
    @Column(name="ActivityFireCode")
	private String ActivityFireCode;


	public VDTRAIntegration() {
	}

	public String getActivityCode() {
		return this.activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
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

	public Date getActivityStartDate() {
		return this.ActivityStartDate;
	}

	public void setActivityStartDate(Date activityStartDate) {
		this.ActivityStartDate = activityStartDate;
	}

	public String getActivitySubDomain() {
		return this.activitySubDomain;
	}

	public void setActivitySubDomain(String activitySubDomain) {
		this.activitySubDomain = activitySubDomain;
	}

	public String getActivityTotalHours() {
		return this.activityTotalHours;
	}

	public void setActivityTotalHours(String activityTotalHours) {
		this.activityTotalHours = activityTotalHours;
	}

	public String getLink1() {
		return this.link1;
	}

	public void setLink1(String link1) {
		this.link1 = link1;
	}


    public String getLink2() {
        return this.link2;
    }

    public void setLink2(String link2) {
        this.link2 = link2;
    }
	public String getDependentActivities() {
		return this.dependentActivities;
	}

	public void setDependentActivities(String dependentActivities) {
		this.dependentActivities = dependentActivities;
	}

	public String getIWPCostCategory() {
		return this.IWPCostCategory;
	}

	public void setIWPCostCategory(String IWPCostCategory) {
		this.IWPCostCategory = IWPCostCategory;
	}

	public String getIWPCostStatus() {
		return this.IWPCostStatus;
	}

	public void setIWPCostStatus(String IWPCostStatus) {
		this.IWPCostStatus = IWPCostStatus;
	}

	public String getIWPDeliveryOrigin() {
		return this.IWPDeliveryOrigin;
	}

	public void setIWPDeliveryOrigin(String IWPDeliveryOrigin) {
		this.IWPDeliveryOrigin = IWPDeliveryOrigin;
	}

	public String getIWPDomain() {
		return this.IWPDomain;
	}

	public void setIWPDomain(String IWPDomain) {
		this.IWPDomain = IWPDomain;
	}

	public Date getIWPExpiryDate() {
		return this.IWPExpiryDate;
	}

	public void setIWPExpiryDate(Timestamp IWPExpiryDate) {
		this.IWPExpiryDate = IWPExpiryDate;
	}

	public String getIWPFireCode() {
		return this.IWPFireCode;
	}

	public void setIWPFireCode(String IWPFireCode) {
		this.IWPFireCode = IWPFireCode;
	}

	public String getIwpid() {
		return this.iwpid;
	}

	public void setIwpid(String iwpid) {
		this.iwpid = iwpid;
	}

	

	public String getIWPOrderingOrigin() {
		return this.IWPOrderingOrigin;
	}

	public void setIWPOrderingOrigin(String IWPOrderingOrigin) {
		this.IWPOrderingOrigin = IWPOrderingOrigin;
	}

	public String getIWPServiceActivityArea() {
		return this.IWPServiceActivityArea;
	}

	public void setIWPServiceActivityArea(String IWPServiceActivityArea) {
		this.IWPServiceActivityArea = IWPServiceActivityArea;
	}

	public String getIWPSubDomain() {
		return this.IWPSubDomain;
	}

	public void setIWPSubDomain(String IWPSubDomain) {
		this.IWPSubDomain = IWPSubDomain;
	}

	public String getIWPTitle() {
		return this.IWPTitle;
	}

	public void setIWPTitle(String IWPTitle) {
		this.IWPTitle = IWPTitle;
	}

	public String getIWPType() {
		return this.IWPType;
	}

	public void setIWPType(String IWPType) {
		this.IWPType = IWPType;
	}

	

	public String getIWPUnit() {
		return this.IWPUnit;
	}

	public void setIWPUnit(String IWPUnit) {
		this.IWPUnit = IWPUnit;
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

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getRegionalResourceArea() {
		return this.regionalResourceArea;
	}

	public void setRegionalResourceArea(String regionalResourceArea) {
		this.regionalResourceArea = regionalResourceArea;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getLink3() {
		return link3;
	}

	public void setLink3(String link3) {
		this.link3 = link3;
	}

	public String getOtherLinks() {
		return otherLinks;
	}

	public void setOtherLinks(String otherLinks) {
		this.otherLinks = otherLinks;
	}

	public Integer getIsLatestData() {
		return IsLatestData;
	}

	public void setIsLatestData(Integer isLatestData) {
		IsLatestData = isLatestData;
	}

	public String getWPTitle() {
		return WPTitle;
	}

	public void setWPTitle(String wPTitle) {
		WPTitle = wPTitle;
	}

	public Double getActivityTime() {
		return ActivityTime;
	}

	public void setActivityTime(Double activityTime) {
		ActivityTime = activityTime;
	}

	public Double getActivityCost() {
		return ActivityCost;
	}

	public void setActivityCost(Double activityCost) {
		ActivityCost = activityCost;
	}

	public String getActivityCurrency() {
		return ActivityCurrency;
	}

	public void setActivityCurrency(String activityCurrency) {
		ActivityCurrency = activityCurrency;
	}

	public void setIWPExpiryDate(Date iWPExpiryDate) {
		IWPExpiryDate = iWPExpiryDate;
	}

	public CompoundViewKey getIdCompound() {
		return idCompound;
	}

	public void setIdCompound(CompoundViewKey idCompound) {
		this.idCompound = idCompound;
	}

	public String getScenarioTitle() {
		return ScenarioTitle;
	}

	public void setScenarioTitle(String scenarioTitle) {
		ScenarioTitle = scenarioTitle;
	}

	public Integer getWP_Quanitity() {
		return this.WPQuantity;
	}

	public void setWP_Quanitity(Integer WP_Quantity) {
		this.WPQuantity = WP_Quantity;
	}

	
	public void setActivityFireCode(String ActivityFireCode) {
		this.ActivityFireCode = ActivityFireCode;
	}
	
	public String getActivityFireCode() {
		return this.ActivityFireCode;
	}

}

