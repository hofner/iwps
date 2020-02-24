package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the READINESS_RECORD database table.
 * 
 */
@Entity
@Table(name="READINESS_RECORD")
@NamedQuery(name="ReadinessRecord.findAll", query="SELECT r FROM ReadinessRecord r")
/**
 * 
 * @author ejelgoz
 *
 */
public class ReadinessRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReadinessRecordPK id;

	private String active;

	@Column(name="CHINA_CONTACT")
	private String chinaContact;

	@Column(name="CREATION_TIME")
	private Timestamp creationTime;

	@Column(name="DEMAND_LINE")
	private String demandLine;

	private String description;

	@Column(name="GANTT_XML")
	private String ganttXml;

	@Column(name="\"HASH\"")
	private String hash;

	@Column(name="INDIA_CONTACT")
	private String indiaContact;

	private String instruction;

	@Column(name="IWP_TITLE")
	private String iwpTitle;

	@Column(name="IWPCODE_VERSION")
	private String iwpcodeVersion;

	@Column(name="MEXICO_CONTACT")
	private String mexicoContact;

	private String onepager;

	@Column(name="PRODUCT_MANAGER")
	private String productManager;

	@Column(name="TARGET_DELIVERY_ORGANIZATION")
	private String targetDeliveryOrganization;

	@Column(name="VERSION_NUMBER")
	private String versionNumber;

	@Column(name="WFM_REPORT")
	private String wfmReport;

	//bi-directional many-to-many association to ReadinessFile
	@ManyToMany
	@JoinTable(
		name="READINESS_FILE_RECORD"
		, joinColumns={
			@JoinColumn(name="ID_READINESS_RECORD", referencedColumnName="ID_READINESS_RECORD"),
			@JoinColumn(name="IWP_ID", referencedColumnName="IWP_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_READINESS_FILE")
			}
		)
	private List<ReadinessFile> readinessFiles;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="ID_CATEGORY")
	private Category category;

	//bi-directional many-to-one association to CompetenceDomain
	@ManyToOne
	@JoinColumn(name="ID_COMPETENCE_DOMAIN")
	private CompetenceDomain competenceDomain;

	//bi-directional many-to-one association to CompetenceSubDomain
	@ManyToOne
	@JoinColumn(name="ID_COMPETENCE_SUB_DOMAIN")
	private CompetenceSubDomain competenceSubDomain;

	//bi-directional many-to-one association to ReadinessRecordStatus
	@ManyToOne
	@JoinColumn(name="ID_READINESS_RECORD_STATUS")
	private ReadinessRecordStatus readinessRecordStatus;

	//bi-directional many-to-one association to ServiceArea
	@ManyToOne
	@JoinColumn(name="ID_SERVICE_AREA")
	private ServiceArea serviceArea;

	

	//bi-directional many-to-one association to ReadinessWorkPackage
	@OneToMany(mappedBy="readinessRecord")
	private List<ReadinessWorkPackage> readinessWorkPackages;

	//bi-directional many-to-many association to WorkpackageFile
	@ManyToMany(mappedBy="readinessRecords")
	private List<WorkpackageFile> workpackageFiles;

	public ReadinessRecord() {
	}

	public ReadinessRecordPK getId() {
		return this.id;
	}

	public void setId(ReadinessRecordPK id) {
		this.id = id;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getChinaContact() {
		return this.chinaContact;
	}

	public void setChinaContact(String chinaContact) {
		this.chinaContact = chinaContact;
	}

	public Timestamp getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public String getDemandLine() {
		return this.demandLine;
	}

	public void setDemandLine(String demandLine) {
		this.demandLine = demandLine;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGanttXml() {
		return this.ganttXml;
	}

	public void setGanttXml(String ganttXml) {
		this.ganttXml = ganttXml;
	}

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getIndiaContact() {
		return this.indiaContact;
	}

	public void setIndiaContact(String indiaContact) {
		this.indiaContact = indiaContact;
	}

	public String getInstruction() {
		return this.instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getIwpTitle() {
		return this.iwpTitle;
	}

	public void setIwpTitle(String iwpTitle) {
		this.iwpTitle = iwpTitle;
	}

	public String getIwpcodeVersion() {
		return this.iwpcodeVersion;
	}

	public void setIwpcodeVersion(String iwpcodeVersion) {
		this.iwpcodeVersion = iwpcodeVersion;
	}

	public String getMexicoContact() {
		return this.mexicoContact;
	}

	public void setMexicoContact(String mexicoContact) {
		this.mexicoContact = mexicoContact;
	}

	public String getOnepager() {
		return this.onepager;
	}

	public void setOnepager(String onepager) {
		this.onepager = onepager;
	}

	public String getProductManager() {
		return this.productManager;
	}

	public void setProductManager(String productManager) {
		this.productManager = productManager;
	}

	public String getTargetDeliveryOrganization() {
		return this.targetDeliveryOrganization;
	}

	public void setTargetDeliveryOrganization(String targetDeliveryOrganization) {
		this.targetDeliveryOrganization = targetDeliveryOrganization;
	}

	public String getVersionNumber() {
		return this.versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getWfmReport() {
		return this.wfmReport;
	}

	public void setWfmReport(String wfmReport) {
		this.wfmReport = wfmReport;
	}

	public List<ReadinessFile> getReadinessFiles() {
		return this.readinessFiles;
	}

	public void setReadinessFiles(List<ReadinessFile> readinessFiles) {
		this.readinessFiles = readinessFiles;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public CompetenceDomain getCompetenceDomain() {
		return this.competenceDomain;
	}

	public void setCompetenceDomain(CompetenceDomain competenceDomain) {
		this.competenceDomain = competenceDomain;
	}

	public CompetenceSubDomain getCompetenceSubDomain() {
		return this.competenceSubDomain;
	}

	public void setCompetenceSubDomain(CompetenceSubDomain competenceSubDomain) {
		this.competenceSubDomain = competenceSubDomain;
	}

	public ReadinessRecordStatus getReadinessRecordStatus() {
		return this.readinessRecordStatus;
	}

	public void setReadinessRecordStatus(ReadinessRecordStatus readinessRecordStatus) {
		this.readinessRecordStatus = readinessRecordStatus;
	}

	public ServiceArea getServiceArea() {
		return this.serviceArea;
	}

	public void setServiceArea(ServiceArea serviceArea) {
		this.serviceArea = serviceArea;
	}

	public List<ReadinessWorkPackage> getReadinessWorkPackages() {
		return this.readinessWorkPackages;
	}

	public void setReadinessWorkPackages(List<ReadinessWorkPackage> readinessWorkPackages) {
		this.readinessWorkPackages = readinessWorkPackages;
	}

	public ReadinessWorkPackage addReadinessWorkPackage(ReadinessWorkPackage readinessWorkPackage) {
		getReadinessWorkPackages().add(readinessWorkPackage);
		readinessWorkPackage.setReadinessRecord(this);

		return readinessWorkPackage;
	}

	public ReadinessWorkPackage removeReadinessWorkPackage(ReadinessWorkPackage readinessWorkPackage) {
		getReadinessWorkPackages().remove(readinessWorkPackage);
		readinessWorkPackage.setReadinessRecord(null);

		return readinessWorkPackage;
	}

	public List<WorkpackageFile> getWorkpackageFiles() {
		return this.workpackageFiles;
	}

	public void setWorkpackageFiles(List<WorkpackageFile> workpackageFiles) {
		this.workpackageFiles = workpackageFiles;
	}

}