package com.ericsson.bugs.sdt.dtra.iwp.data.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ericsson.bugs.sdt.dtra.iwp.cast.data.model.VDTRAIntegration;
import com.ericsson.bugs.sdt.dtra.iwp.data.dao.CompetenceDomainRepository;
import com.ericsson.bugs.sdt.dtra.iwp.data.dao.CompetenceSubDomainRepository;
import com.ericsson.bugs.sdt.dtra.iwp.data.dao.ProductAreaRepository;
import com.ericsson.bugs.sdt.dtra.iwp.data.dao.ServiceAreaRepository;
import com.ericsson.bugs.sdt.dtra.iwp.data.model.IwpActivityCast;
import com.ericsson.bugs.sdt.dtra.iwp.data.model.IwpCast;
import com.ericsson.bugs.sdt.dtra.iwp.data.model.ProductArea;
import com.ericsson.bugs.sdt.dtra.iwp.data.model.ReadinessRecordError;
import com.ericsson.bugs.sdt.dtra.iwp.service.IwpFilter;
import com.ericsson.bugs.sdt.dtra.iwp.service.SPCWPGeneratorService;

/**
 * Is meant to receive all the records in the view and transform them into an DTRA normalized dual tables.
 * @author ejuaolg
 *
 */
@Component
public class IWPViewMapperService {
	@Autowired(required=true)
	CompetenceDomainRepository domainDAO;
	@Autowired(required=true)
	CompetenceSubDomainRepository subDomainDAO;
	@Autowired(required=true)
	ServiceAreaRepository serviceAreaDAO;
	@Autowired(required=true)
    ProductAreaRepository productAreaDAO;
	@Autowired(required=true)
    SPCWPGeneratorService spcWPGeneratorService;
	
	List<String> domainSet;
	List<String> subDomainSet;
	List<String> serviceAreaSet;
	HashMap<String,ProductArea> fireCodes;
	
	public IWPViewMapperService() {
		//TODO SETTING DAOS
		/*
		
		*/
	}
	
	public HashMap <String,ProductArea> fillFireCodes(){
    	fireCodes = new HashMap <String,ProductArea>();
    	List<ProductArea> prodsAreas = productAreaDAO.findAll();
    	for(int i=0;i < prodsAreas.size();i++){
    		ProductArea productArea = prodsAreas.get(i);
    		fireCodes.put(productArea.getProductCode(), productArea);
    	}
    	return fireCodes;
    }
    
    public String mappingServiceArea(String fireCode){
    	ProductArea productArea = fireCodes.get(fireCode);
    	return productArea.getProductArea()+"-"+productArea.getProductAreaName();
    }
	
	/**
	 * 
	 * @param completeViewList list of view records to be transformed into a IwpCast
	 * @return array of IwpCast entities 
	 */
	public ArrayList<IwpCast> createIWPEntity(List<VDTRAIntegration> completeViewList){
		ArrayList<IwpCast> 	retList = new ArrayList<IwpCast>();
		HashMap<String,IwpCast> iwpHeaderCollection = new HashMap<String,IwpCast>();
		//HashMap<String,List<IwpActivityCast>> iwpActivityCollection = new HashMap<String,List<IwpActivityCast>>();
		
		//reading all rows from the parameter
		//for (Iterator<VDTRAIntegration> iterator = completeViewList.iterator(); iterator.hasNext();) {
		for (int i=0;i<completeViewList.size();++i){
			VDTRAIntegration view = completeViewList.get(i);
			
			//n - row
			String iwpUniqueID = view.getIdCompound().getIWPUniqueID();
			
			//looking for previous activities for this iwp
			IwpCast iwpCast = iwpHeaderCollection.get(iwpUniqueID);
			List<IwpActivityCast> activityList = null;
			if(iwpCast==null){
				//is the first time for this IWP
				//creating header
				iwpCast = new IwpCast();
				iwpCast.setIwpUniqueId(view.getIdCompound().getIWPUniqueID());
				iwpCast.setIwpTitle(view.getIWPTitle());
				if(view.getScenarioTitle() != null)
					iwpCast.setScnearioTitle(view.getScenarioTitle());
				else
					iwpCast.setScnearioTitle("");
				iwpCast.setIwpId(view.getIwpid());
				iwpCast.setIwpExperyDate(view.getIWPExpiryDate());
				iwpCast.setIwpDeliveryOrigin(view.getIWPDeliveryOrigin());
				iwpCast.setIwpOrderingOrigin(view.getIWPOrderingOrigin());
				//Map the activity Columns to IWP columns
				if(view.getActivityFireCode() != null)
					iwpCast.setIwpFireCode(view.getActivityFireCode());
				else
					iwpCast.setIwpFireCode(view.getIWPFireCode());
				
				if(view.getActivityDomain() != null)
					iwpCast.setIwpDomain(view.getActivityDomain());
				else
					iwpCast.setIwpDomain(view.getIWPDomain());
				
				if(view.getActivitySubDomain() != null)
					iwpCast.setIwpSubdomain(view.getActivitySubDomain());
				else
					iwpCast.setIwpSubdomain(view.getIWPSubDomain());
				
				iwpCast.setIwpUnit(view.getIWPUnit());
				iwpCast.setIwpType(view.getIWPType());
				iwpCast.setIwpCostCategory(view.getIWPCostCategory());
				iwpCast.setIwpCostStatus(view.getIWPCostStatus());				
				iwpCast.setIwpServiceActivityArea(view.getIWPServiceActivityArea());
//				if(view.getLink1() == null || view.getLink1().trim().equals(""))
//					iwpCast.setLink1("www.google.com");
//				else
					iwpCast.setLink1(view.getLink1());
//				if(view.getLink2() == null || view.getLink2().trim().equals(""))
//					iwpCast.setLink2("www.google.com");
//				else
					iwpCast.setLink2(view.getLink2());
//				if(view.getLink3() == null || view.getLink3().trim().equals(""))
//					iwpCast.setLink3("www.google.com");
//				else
					iwpCast.setLink3(view.getLink3());
				iwpCast.setOtherLinks(view.getOtherLinks());
				iwpCast.setVersion(view.getVersion());
				iwpCast.setLastUpdatedDate(view.getLastUpdatedDate());
				iwpCast.setIsLatestData(view.getIsLatestData());				
				activityList = new ArrayList<IwpActivityCast>();
				iwpCast.setIwpActivityCasts(activityList);
				retList.add(iwpCast);
				iwpHeaderCollection.put(iwpCast.getIwpUniqueId(), iwpCast);
				
			}
			IwpActivityCast activityNew = new IwpActivityCast();
			activityNew.setWpTitle(view.getIWPTitle());
			activityNew.setActivitySerialId(view.getIdCompound().getActivitySerialID());
			activityNew.setActivityName(view.getActivityName());
			activityNew.setActivityCount(view.getActivityCount());
			activityNew.setActivityCode(view.getActivityCode());
			activityNew.setJobRole(view.getJobRole());
			activityNew.setJobStage(view.getJobStage());
			activityNew.setRegionalResourceArea(view.getRegionalResourceArea());
			activityNew.setActivityDomain(view.getActivityDomain());
			activityNew.setActivitySubdomain(view.getActivitySubDomain());
			activityNew.setActivityCost(view.getActivityCost());
			activityNew.setActivityCurrency(view.getActivityCurrency());
			activityNew.setActivityTime(view.getActivityTime());
			activityNew.setActivityTotalHours(view.getActivityTotalHours());
			activityNew.setActivityDuration(view.getActivityDuration());
			activityNew.setActivityNormHourStatus(view.getActivityNormHourStatus());
			activityNew.setActivityCountry(view.getActivityCountry());
			activityNew.setActivityStartDate(view.getActivityStartDate());
			activityNew.setActivityEndDate(view.getActivityEndDate());
			activityNew.setDependentActivities(view.getDependentActivities());		
			activityNew.setWP_Quantity(view.getWP_Quanitity());
			activityList = iwpCast.getIwpActivityCasts();			
			activityList.add(activityNew);
		}
		return retList;
	}
	
	public IwpFilter validateIwpCast(List<IwpCast> listIwps, String iwplist){
		domainSet = domainDAO.getAllNames();
		subDomainSet = subDomainDAO.getAllNames();
		serviceAreaSet = serviceAreaDAO.getAllNames();
		serviceAreaSet.add("Build");
		fillFireCodes();
		
		HashMap<String, Boolean> iwpFlags = new HashMap<>();
		if(iwplist != null) {
			for(String iwpId : iwplist.split(",")) {
				if(!iwpId.trim().equals(""))
					iwpFlags.put(iwpId, Boolean.FALSE);
			}
		}
		
		IwpFilter filter = new IwpFilter();
		
		for (IwpCast iwpCast : listIwps) {
			
			/*
			String iwpSA = mappingServiceArea(iwpCast.getIwpFireCode());	
			iwpCast.setIwpServiceActivityArea(iwpSA);		*/	
			
			iwpFlags.put(iwpCast.getIwpUniqueId(), Boolean.TRUE);
			ArrayList<ReadinessRecordError> errorsLocal=new ArrayList<ReadinessRecordError>();
						
			if(iwpCast.getIwpTitle()==null ||iwpCast.getIwpTitle().trim().equals("")){
				ReadinessRecordError error = new ReadinessRecordError();
				error.setDescription("Title is empty");
				error = fillError(error,iwpCast,errorsLocal);
			}
			if(iwpCast.getIwpUniqueId()==null ||iwpCast.getIwpUniqueId().trim().equals("")){
				ReadinessRecordError error = new ReadinessRecordError();
				error.setDescription("IWP Unique ID is empty");
				error = fillError(error,iwpCast,errorsLocal);
				
			}
			if(iwpCast.getIwpId()==null ||iwpCast.getIwpId().trim().equals("")){
				ReadinessRecordError error = new ReadinessRecordError();
				error.setDescription("IWP ID is empty");
				error = fillError(error,iwpCast,errorsLocal);
			}
			if(iwpCast.getIwpDeliveryOrigin()==null ||iwpCast.getIwpDeliveryOrigin().trim().equals("")){
				ReadinessRecordError error = new ReadinessRecordError();
				error.setDescription("Delivery Origin is empty");
				error = fillError(error,iwpCast,errorsLocal);
			}
			if(iwpCast.getLink1()==null ||iwpCast.getLink1().trim().equals("")){
				ReadinessRecordError error = new ReadinessRecordError();
				error.setDescription("One pager link is empty");
				error = fillError(error,iwpCast,errorsLocal);
			}
			if(iwpCast.getLink1()!=null) {	
					if( iwpCast.getLink1().length()  > 255 ){		
						ReadinessRecordError error = new ReadinessRecordError();
						error.setDescription("One pager link is too long ("+iwpCast.getLink1().length()+") it was truncated");
						error = fillError(error,iwpCast,errorsLocal);
						iwpCast.setLink1(iwpCast.getLink1().substring(0, 200));
					}				
			}
			if(iwpCast.getLink2()==null ||iwpCast.getLink2().trim().equals("")){
				ReadinessRecordError error = new ReadinessRecordError();
				error.setDescription("Description link is empty");
				error = fillError(error,iwpCast,errorsLocal);
			}
			if(iwpCast.getLink2()!=null) {
				if( iwpCast.getLink2().length()  > 255 ){
					ReadinessRecordError error = new ReadinessRecordError();
					error.setDescription("Description link is too long ("+iwpCast.getLink2().length()+")  it was truncated");
					error = fillError(error,iwpCast,errorsLocal);
					iwpCast.setLink2(iwpCast.getLink2().substring(0, 200));
				}
			}
			if(iwpCast.getLink3()==null ||iwpCast.getLink3().trim().equals("")){
				ReadinessRecordError error = new ReadinessRecordError();
				error.setDescription("Instruction link is empty");
				error = fillError(error,iwpCast,errorsLocal);
			}
			if(iwpCast.getLink3()!=null) { 
					if( iwpCast.getLink3().length() > 255){
						ReadinessRecordError error = new ReadinessRecordError();
						error.setDescription("Instruction link is too long ("+iwpCast.getLink3().length()+")  it was truncated");
						error = fillError(error,iwpCast,errorsLocal);
						iwpCast.setLink3(iwpCast.getLink3().substring(0, 200));
					}
			}
			
			if(iwpCast.getIwpDomain()==null ||iwpCast.getIwpDomain().trim().equals("")){
				ReadinessRecordError error = new ReadinessRecordError();
				error.setDescription("Competence Domain is empty");
				error = fillError(error,iwpCast,errorsLocal);
			}else{
				if(!this.domainSet.contains(iwpCast.getIwpDomain())){
					ReadinessRecordError error = new ReadinessRecordError();
					error.setDescription("Competence Domain not found");
					error = fillError(error,iwpCast,errorsLocal);
				}
				
			}
			if(iwpCast.getIwpSubdomain()==null ||iwpCast.getIwpSubdomain().trim().equals("")){
				ReadinessRecordError error = new ReadinessRecordError();
				error.setDescription("Competence SubDomain is empty");
				error = fillError(error,iwpCast,errorsLocal);
			}else{
				if(!this.subDomainSet.contains(iwpCast.getIwpSubdomain())){
					ReadinessRecordError error = new ReadinessRecordError();
					error.setDescription("Competence SubDomain not found");
					error = fillError(error,iwpCast,errorsLocal);
				}
				
			}
			
			/*
			if(iwpCast.getIwpServiceActivityArea()==null ||iwpCast.getIwpServiceActivityArea().trim().equals("")){
				ReadinessRecordError error = new ReadinessRecordError();
				error.setDescription("Service Area is empty");
				error = fillError(error,iwpCast,errorsLocal);
			}else{
				if(!this.serviceAreaSet.contains(iwpCast.getIwpServiceActivityArea())){
					ReadinessRecordError error = new ReadinessRecordError();
					error.setDescription("Service Area not found");
					error = fillError(error,iwpCast,errorsLocal);
				}
				
			} */
			
			
			//Calculate the total IWP Quantity refering to WP_Quantity and ActivityCount 
			int iTotalActivityCount = 0;
			for(IwpActivityCast activity : iwpCast.getIwpActivityCasts()) {
				boolean valid = spcWPGeneratorService.isActivityValid(activity);
				if(activity.getWP_Quantity() != null && activity.getActivityCount() != null && valid == true)
					iTotalActivityCount += activity.getActivityCount() * activity.getWP_Quantity() ;
				else if(valid == true)
					iTotalActivityCount += activity.getActivityCount();
			}
			
			if(iTotalActivityCount > 250) {				
				ReadinessRecordError error = new ReadinessRecordError();
				error.setDescription("Total Activities Count ("+iTotalActivityCount+") is greater than the limit");
				error = fillError(error,iwpCast,errorsLocal);
			}
			
			//Get All ACtivities dependencies
			HashMap<String, String> allDependencies = new HashMap<>();
			for(IwpActivityCast activity : iwpCast.getIwpActivityCasts()) {				
				if(activity.getDependentActivities() != null)		
					allDependencies.put(activity.getActivitySerialId()+"", activity.getDependentActivities());																						
			}
			//Test each Dependency
			boolean dependencyErrorFlag = false;
			for(IwpActivityCast activity : iwpCast.getIwpActivityCasts()) {																				
				if(activity.getDependentActivities() != null) {								
					if(TestDependency(allDependencies, activity.getDependentActivities(), 1) == true) {
						dependencyErrorFlag = true;						
					}
				}					
			}
			if(dependencyErrorFlag == true) {
				ReadinessRecordError error = new ReadinessRecordError();
				error.setDescription("Dependecy Activities are not valid, there is an infinity loop");
				error = fillError(error,iwpCast,errorsLocal);
			}
								
			
			boolean hasError = false;
			if(errorsLocal.size() > 0) {
				for(ReadinessRecordError error : errorsLocal) {
					filter.getErrorsList().add(error);
					//Ignore the link is too long as error, considering as Warning
					if(!error.getDescription().contains("link is too long"))					
						hasError = true;												
				}
				//if the IWP has errors (no warnings)
				if(hasError == true) 
					filter.getIwpsWithError().add(iwpCast);
				else
					filter.getIwpsPreList().add(iwpCast);				
			} else{
				filter.getIwpsPreList().add(iwpCast);
			}
			
			
		}
		//Verify that the requested iwp are in the list
		for(Map.Entry<String, Boolean> entry : iwpFlags.entrySet()) {
			if(entry.getValue() == Boolean.FALSE) {
				ReadinessRecordError error = new ReadinessRecordError();
				error.setDescription("IWP " + entry.getKey() + " was not found in the entries.");
				error.setIwpId(entry.getKey());
				error.setIwpcodeVersion("NA");
				error.setServiceArea("NA");
				error.setCompetenceDomain("NA");
				error.setCompetenceSubDomain("NA");					
				filter.getErrorsList().add(error);
			}
		}
		/*
		if(filter.getIwpsPreList().size()>75){
			filter.getIwpsWithError().add(iwpCast);
			filter.getErrorsList().addAll(errorsLocal);
		}else{
			filter.getIwpsPreList().add(iwpCast);
		}
		*/
		return filter;
		
	}
	private ReadinessRecordError fillError(ReadinessRecordError error,IwpCast iwpCast,List<ReadinessRecordError> list){
				error.setIwpId(iwpCast.getIwpUniqueId());
				error.setIwpcodeVersion(iwpCast.getIwpUniqueId());
				error.setServiceArea(iwpCast.getIwpServiceActivityArea());
				error.setCompetenceDomain(iwpCast.getIwpDomain());
				error.setCompetenceSubDomain(iwpCast.getIwpSubdomain());
				list.add(error);
	return error;
	}
	
	 private boolean TestDependency(HashMap<String, String> allDependencies, String dependencies, int cycles) {
	    	//if it is the cycle number 100 and hasn't been solved then it is redundancy
	    	if(cycles > 100)
	    		return true;    	
	    	if(dependencies == null || dependencies.trim().equals(""))
	    		return false;    	
	    	else {
	    		for(String act : dependencies.split(",")) {
	    			if(allDependencies.containsKey(act)) {
		    			boolean result = TestDependency(allDependencies, allDependencies.get(act), cycles+1);
		    			if(result == true)
		    				return true;
	    			}
	    		}
	    		return false;
	    	}
	 }

}
