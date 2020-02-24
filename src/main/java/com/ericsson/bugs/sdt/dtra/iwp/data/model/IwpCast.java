package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * The persistent class for the IWP_CAST database table.
 * 
 */
@Entity
@Table(name="IWP_CAST")
@NamedQuery(name="IwpCast.findAll", query="SELECT i FROM IwpCast i")
public class IwpCast implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_IWP_CAST")
	private long idIwpCast;

	@Column(name="IS_LATEST_DATA")
	private Integer isLatestData;

	@Column(name="IWP_COST_CATEGORY")
	private String iwpCostCategory;

	@Column(name="IWP_COST_STATUS")
	private String iwpCostStatus;

	@Column(name="IWP_DELIVERY_ORIGIN")
	private String iwpDeliveryOrigin;

	@Column(name="IWP_DOMAIN")
	private String iwpDomain;

	@Temporal(TemporalType.DATE)
	@Column(name="IWP_EXPERY_DATE")
	private Date iwpExperyDate;

	@Column(name="IWP_FIRE_CODE")
	private String iwpFireCode;

	@Column(name="IWP_ID")
	private String iwpId;

	@Column(name="IWP_ORDERING_ORIGIN")
	private String iwpOrderingOrigin;

	@Column(name="IWP_SERVICE_ACTIVITY_AREA")
	private String iwpServiceActivityArea;

	@Column(name="IWP_SUBDOMAIN")
	private String iwpSubdomain;

	@Column(name="IWP_TITLE")
	private String iwpTitle;
	
	@Column(name="SCENARIO_TITLE")
	private String scnearioTitle;

	@Column(name="IWP_TYPE")
	private String iwpType;

	@Column(name="IWP_UNIQUE_ID")
	private String iwpUniqueId;

	@Column(name="IWP_UNIT")
	private String iwpUnit;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name="LINK1")
	private String link1;

	@Column(name="LINK2")
	private String link2;

	@Column(name="LINK3")
	private String link3;

	@Column(name="OTHER_LINKS")
	private String otherLinks;

	@Column(name="\"VERSION\"")
	private String version;
	

	//bi-directional many-to-one association to IwpActivityCast
	@OneToMany(mappedBy="iwpCast")
	private List<IwpActivityCast> iwpActivityCasts;
	
	@Transient
	private List<IwpActivityCast> iwpActivityClear;
	
	@Column(name="TOTAL_HOURS")
	private Integer totalHours;

	public IwpCast() {
	}

	public long getIdIwpCast() {
		return this.idIwpCast;
	}

	public void setIdIwpCast(long idIwpCast) {
		this.idIwpCast = idIwpCast;
	}

	

	public String getIwpCostCategory() {
		return this.iwpCostCategory;
	}

	public void setIwpCostCategory(String iwpCostCategory) {
		this.iwpCostCategory = iwpCostCategory;
	}

	public String getIwpCostStatus() {
		return this.iwpCostStatus;
	}

	public void setIwpCostStatus(String iwpCostStatus) {
		this.iwpCostStatus = iwpCostStatus;
	}

	public String getIwpDeliveryOrigin() {
		return this.iwpDeliveryOrigin;
	}

	public void setIwpDeliveryOrigin(String iwpDeliveryOrigin) {
		this.iwpDeliveryOrigin = iwpDeliveryOrigin;
	}

	public String getIwpDomain() {
		return this.iwpDomain;
	}

	public void setIwpDomain(String iwpDomain) {
		this.iwpDomain = iwpDomain;
	}

	public Date getIwpExperyDate() {
		return this.iwpExperyDate;
	}

	public void setIwpExperyDate(Date iwpExperyDate) {
		this.iwpExperyDate = iwpExperyDate;
	}

	public String getIwpFireCode() {
		return this.iwpFireCode;
	}

	public void setIwpFireCode(String iwpFireCode) {
		this.iwpFireCode = iwpFireCode;
	}

	public String getIwpId() {
		return this.iwpId;
	}

	public void setIwpId(String iwpId) {
		this.iwpId = iwpId;
	}

	public String getIwpOrderingOrigin() {
		return this.iwpOrderingOrigin;
	}

	public void setIwpOrderingOrigin(String iwpOrderingOrigin) {
		this.iwpOrderingOrigin = iwpOrderingOrigin;
	}

	public String getIwpServiceActivityArea() {
		return this.iwpServiceActivityArea;
	}

	public void setIwpServiceActivityArea(String iwpServiceActivityArea) {
		this.iwpServiceActivityArea = iwpServiceActivityArea;
	}

	public String getIwpSubdomain() {
		return this.iwpSubdomain;
	}

	public void setIwpSubdomain(String iwpSubdomain) {
		this.iwpSubdomain = iwpSubdomain;
	}

	public String getIwpTitle() {
		return this.iwpTitle;
	}

	public void setIwpTitle(String iwpTitle) {
		this.iwpTitle = iwpTitle;
	}

	public String getIwpType() {
		return this.iwpType;
	}

	public void setIwpType(String iwpType) {
		this.iwpType = iwpType;
	}

	public String getIwpUniqueId() {
		return this.iwpUniqueId;
	}

	public void setIwpUniqueId(String iwpUniqueId) {
		this.iwpUniqueId = iwpUniqueId;
	}

	public String getIwpUnit() {
		return this.iwpUnit;
	}

	public void setIwpUnit(String iwpUnit) {
		this.iwpUnit = iwpUnit;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
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

	public String getLink3() {
		return this.link3;
	}

	public void setLink3(String link3) {
		this.link3 = link3;
	}

	public String getOtherLinks() {
		return this.otherLinks;
	}

	public void setOtherLinks(String otherLinks) {
		this.otherLinks = otherLinks;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<IwpActivityCast> getIwpActivityCasts() {
		return this.iwpActivityCasts;
	}

	public void setIwpActivityCasts(List<IwpActivityCast> iwpActivityCasts) {
		this.iwpActivityCasts = iwpActivityCasts;
	}

	public IwpActivityCast addIwpActivityCast(IwpActivityCast iwpActivityCast) {
		getIwpActivityCasts().add(iwpActivityCast);
		iwpActivityCast.setIwpCast(this);

		return iwpActivityCast;
	}

	public IwpActivityCast removeIwpActivityCast(IwpActivityCast iwpActivityCast) {
		getIwpActivityCasts().remove(iwpActivityCast);
		iwpActivityCast.setIwpCast(null);

		return iwpActivityCast;
	}

	public Integer getIsLatestData() {
		return isLatestData;
	}

	public void setIsLatestData(Integer isLatestData) {
		this.isLatestData = isLatestData;
	}

	public Integer getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Integer totalHours) {
		this.totalHours = totalHours;
	}

	public List<IwpActivityCast> getIwpActivityClear() {
		return iwpActivityClear;
	}

	public void setIwpActivityClear(List<IwpActivityCast> iwpActivityClear) {
		this.iwpActivityClear = iwpActivityClear;
	}

	public String getScnearioTitle() {
		return scnearioTitle;
	}

	public void setScnearioTitle(String scnearioTitle) {
		this.scnearioTitle = scnearioTitle;
	}
	
	

}