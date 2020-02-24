package com.ericsson.bugs.sdt.dtra.iwp.service;

import java.io.File;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ericsson.bugs.sdt.dtra.iwp.data.dao.NoManPowerActRepository;
import com.ericsson.bugs.sdt.dtra.iwp.data.dao.NoManPowerJobRoleRepository;
import com.ericsson.bugs.sdt.dtra.iwp.data.dao.ProductAreaRepository;
import com.ericsson.bugs.sdt.dtra.iwp.data.model.IwpActivityCast;
import com.ericsson.bugs.sdt.dtra.iwp.data.model.IwpCast;
import com.ericsson.bugs.sdt.dtra.iwp.data.model.ProductArea;
import com.ericsson.dtra.spc.SPCBulkLoader;
import com.ericsson.dtra.spc.SPCBulkLoaderException;
import com.inc.ericsson.spom.structure.lookup.Structure;
import com.inc.ericsson.spom.structure.lookup.StructureLookupInfo;
import com.inc.ericsson.spom.structure.lookup.StructureLookupInfoUpdated;
import com.inc.ericsson.spom.xsd.spc.Spc;
import com.inc.ericsson.spom.xsd.spc.Spc.Iwp;
import com.inc.ericsson.spom.xsd.spc.Spc.Iwp.Activities;
import com.inc.ericsson.spom.xsd.spc.Spc.Iwp.Activities.Activity;


/**
 * @author ejuaolg
 *
 */
@Component
public class SPCWPGeneratorService {
	
	

	private static final String NON_MANPOWER_LCASE = "non manpower";
	/** The Constant RELEASED. */
    private static final String RELEASED = "Released";
    /** The Constant R1A. */
    private static final String R1A = "R1A";
    /** The Constant GLOBAL. */
    private static final String GLOBAL = "Global";
    
    /** The Constant UNDERSCORE. */
    private static final String UNDERSCORE = "_";
    
    /** The Constant RANDOM. */
    private static final SecureRandom RANDOM = new SecureRandom();
    
    /** The Constant FILE_EXTENSION. */
    private static final String XML_FILE_EXTENSION = ".xml";
    
    @Autowired(required=true)
    RetriveSettingsService retriveSettingService;
    
    @Autowired(required=true)
    NoManPowerActRepository noManPowerActDAO;
    
    @Autowired(required=true)
    ProductAreaRepository productAreaDAO;
    
    @Autowired(required=true)
    NoManPowerJobRoleRepository noManPowerJobRoleDAO;
    
    @Autowired(required=true)
    WorkPackageNotification  workPackageNotification;
    
    List<String> noManPowerActSet;
	List<String> noManPowerJobRoleSet;
	
	HashMap<String,ProductArea> fireCodes;
	
	
	
     
    public boolean isActivityValid(IwpActivityCast activity){
    	noManPowerActSet = noManPowerActDAO.getAllNames();
		noManPowerJobRoleSet = noManPowerJobRoleDAO.getAllNames();
    	boolean ret=true;
    	if( activity.getWpTitle().toLowerCase().contains(NON_MANPOWER_LCASE)){
    		ret=false;
    		return ret;
    	}
    	if( noManPowerActSet.contains(activity.getActivityName())){
    		ret=false;
    		return ret;
    	}
    	if( activity.getJobRole()==null || activity.getJobRole().equals("") ||
    			activity.getJobStage()==null || activity.getJobStage().equals("") ){
    		ret=false;
    		return ret;
    	}
    	if( noManPowerJobRoleSet.contains(activity.getJobRole())){
    		ret=false;
    		return ret;
    	}
    	
    	return ret;
    	
    }
    
    
    
    /**
     * @return
     */
    private IwpFilterActivities calculateNormalHoursAndFilter(IwpCast iwpHeader){
    	List<IwpActivityCast> activityListCasts = iwpHeader.getIwpActivityCasts();
    	IwpFilterActivities normalHoursFiltered = new IwpFilterActivities(iwpHeader.getIwpUniqueId());
    	
    	Integer durationTotal = 0;
    	int newSequence = 1;
    	for (Iterator<IwpActivityCast> iterator = activityListCasts.iterator(); iterator.hasNext();) {
			IwpActivityCast activity = iterator.next();
			if(activity.getWpTitle()!=null){
				//if( !activity.getWpTitle().toLowerCase().contains(NON_MANPOWER_LCASE)){
				if( isActivityValid(activity) ){
					normalHoursFiltered.getActivityList().add(activity);
					normalHoursFiltered.getSerialIDActivities().put(activity.getActivitySerialId(), activity);
					activity.setDtraSerialId(newSequence++);
					
					String durationString = activity.getActivityTotalHours();
					Double duration = Double.parseDouble(durationString);
					Integer conv =(int)(duration*3600);
					activity.setDtraTotalHours(conv);
					
					durationTotal += conv;
				}
			}
			iwpHeader.setTotalHours(durationTotal);
		}
    	return normalHoursFiltered;
    	
    }
    /**
     * @param dependentActivities
     * @return
     */
    private String calculateDependentActivities(String dependentActivities,IwpFilterActivities filterActivities){
    	if(dependentActivities==null) 
    		return null;
    	String[] seriales = dependentActivities.split(",");
    	String dependentResult = "";
    	for (String serialStr : seriales) {
    		if(serialStr.equals(""))
    			continue;
    		Integer serial = null;
    		try{
    			serial = Integer.parseInt(serialStr);
    		}catch(Exception ex){
    			ex.printStackTrace();
    			continue;
    		}
    		
    		IwpActivityCast activity = filterActivities.getSerialIDActivities().get(serial);
    		if(activity!=null){
    			if(!dependentResult.equals("")){
        			dependentResult += ",";
        		}
        		dependentResult += (filterActivities.getIwpUnique() + UNDERSCORE+ activity.getDtraSerialId());
    		}
    		
		}
    	if(dependentResult.equals("")){
    		dependentResult=null;
    	} 
    	return dependentResult; 
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
     * Generate file by specific IWP ids.
     *
     * @param iwpIds the iwp ids
     * @return the string
     */
    public void generateSPCIWPList(List<IwpCast> records, String extraemails) {
    	
    	fillFireCodes();
    	
    	String workPackageFileName=null;
    	IwpFilterActivities filterActivities = null;
        

    	Spc spcContainer =new Spc();
        List<Iwp> listIwps = spcContainer.getIwp();
        ArrayList<String> listIwpsCodes = new ArrayList<String>();        
        
        //List<Iwp> iwps = new ArrayList<Iwp>();
        for (Iterator<IwpCast> iterator = records.iterator(); iterator.hasNext();) {
        	IwpCast iwpHead = iterator.next();
        	
        	
        	Iwp iwp = new Iwp();
            iwpHead.setIwpId(iwpHead.getIwpUniqueId());
            

            iwp.setCatalogCode(iwpHead.getIwpUniqueId());
            iwp.setCatalogName(iwpHead.getIwpTitle());
            iwp.setCompetenceSubDomain(iwpHead.getIwpSubdomain());
            iwp.setLcmStatus(RELEASED);
            //iwp.setServiceArea(iwpHead.getIwpServiceActivityArea());
            iwp.setServiceArea(mappingServiceArea(iwpHead.getIwpFireCode()));
            iwpHead.setIwpServiceActivityArea(iwp.getServiceArea());
            iwp.setWpID(iwpHead.getIwpId());
            iwp.setRelease(R1A);
            iwp.setOrderingOrigin(GLOBAL);
            List<IwpActivityCast> iwpActivityCasts = iwpHead.getIwpActivityCasts();
            if(iwpActivityCasts!=null && iwpActivityCasts.size()>0){
            	IwpActivityCast iwpActivityCast = iwpActivityCasts.get(0);
            	if(iwpActivityCast.getActivityCountry()!=null){
            		if(iwpActivityCast.getActivityCountry().startsWith("IN")){
                		iwp.setDeliveryOrg("GSC India");
                	}
                	if(iwpActivityCast.getActivityCountry().startsWith("CN")){
                		iwp.setDeliveryOrg("GSC China");
                	}
                	if(iwpActivityCast.getActivityCountry().startsWith("MX")){
                		iwp.setDeliveryOrg("GSC Mexico");
                	}
                	if(iwpActivityCast.getActivityCountry().startsWith("RO")){
                		iwp.setDeliveryOrg("GSC Romania");
                	}
            	}else{
            		if(iwpHead.getIwpDeliveryOrigin().startsWith("IN")){
                		iwp.setDeliveryOrg("GSC India");
                	}
                	if(iwpHead.getIwpDeliveryOrigin().startsWith("CN")){
                		iwp.setDeliveryOrg("GSC China");
                	}
                	if(iwpHead.getIwpDeliveryOrigin().startsWith("MX")){
                		iwp.setDeliveryOrg("GSC Mexico");
                	}
                	if(iwpHead.getIwpDeliveryOrigin().startsWith("RO")){
                		iwp.setDeliveryOrg("GSC Romania");
                	}
            		
            	}
            	
            }
            
            iwp.setWpOnePage(iwpHead.getLink1());
            iwp.setDescription(iwpHead.getLink2());
            iwp.setWorkInstruction(iwpHead.getLink3());            
            if(iwpHead.getIwpType()!=null && iwpHead.getIwpType().trim().toLowerCase().indexOf("fix")>=0){
            	iwp.setCategory("IWP");
            }else{
            	if(iwpHead.getIwpType()!=null && (iwpHead.getIwpType().trim().toLowerCase().indexOf("dc configured")>=0
            			||iwpHead.getIwpType().trim().toLowerCase().indexOf("self configured")>=0
            			)){
            		iwp.setCategory("IWPV");
            	} 
            }
            iwp.setWpName(iwpHead.getIwpTitle());
            
            filterActivities = calculateNormalHoursAndFilter(iwpHead);
            iwpHead.setIwpActivityClear(filterActivities.getActivityList());
            
            iwp.setNormalHours(iwpHead.getTotalHours());
            iwp.setLeadTime(iwpHead.getTotalHours());
            
            Activities activitiesContainer = new Activities(); 
            iwp.setActivities(activitiesContainer);
            List<Activity> activityLst = activitiesContainer.getActivity();
            
            //Get the number of WP to rebuild based on WP_Quantity
            int totalWPQuantity = 0;	// the number of Work Package Grouped represented by WP_Quanity
            int ActivityCount = 0;		// The counter of total activities including WP_Quantity and ActivityCount
            int WPActivityCount = 0;	// The Activity Count in the last WPGroup
            for (Iterator<IwpActivityCast> iterat = filterActivities.getActivityList().iterator(); iterat.hasNext();) {
            	IwpActivityCast activCast = iterat.next();
            	if(activCast.getWP_Quantity() != null ) {
            		if(totalWPQuantity < activCast.getWP_Quantity())
            			totalWPQuantity = activCast.getWP_Quantity();
            	}
            }
            
            if(totalWPQuantity == 0)
            	totalWPQuantity = 1;
            
            //Counter of the WP used for WP_Quantity > 0
            for(int countWPQuantity = 0; countWPQuantity < totalWPQuantity; countWPQuantity++) {
            	WPActivityCount = ActivityCount;
	            for (Iterator<IwpActivityCast> iterat = filterActivities.getActivityList().iterator(); iterat.hasNext();) {
	            		            	
	            	IwpActivityCast activCast = iterat.next();
	            	Integer WP_Quantity = activCast.getWP_Quantity();
	            	if(WP_Quantity == null)
	            		WP_Quantity = 1;
	            	if(WP_Quantity == 0)
	            		WP_Quantity = 1;
	            	
	            	//if the current WP Copy is greater than the WP_Quantity then do not duplicate Activity
	            	if(countWPQuantity >= WP_Quantity) 
	            		continue;
	            	
	            	Activity actSpc = new Activity();
	            	String wpCodeIdentifier = generateWPCode(countWPQuantity);     
	                actSpc.setCatalogCode(iwpHead.getIwpUniqueId()+ UNDERSCORE + wpCodeIdentifier + activCast.getDtraSerialId());
	                //actSpc.setCatalogCode(iwpHead.getIwpUniqueId()+ UNDERSCORE + (activCast.getDtraSerialId() + WPActivityCount));
	                actSpc.setCatalogName(activCast.getActivityName());
	                //actSpc.setServiceArea(iwpHead.getIwpServiceActivityArea());
	                actSpc.setServiceArea(iwp.getServiceArea());
	                actSpc.setJobRoleStage(activCast.getJobStage());
	                actSpc.setCompetenceSubDomain(activCast.getActivitySubdomain());
	                actSpc.setJobRole(activCast.getJobRole());
	                actSpc.setNormalHours(activCast.getDtraTotalHours());
	                actSpc.setActivityName(activCast.getActivityName());
	                actSpc.setLeadTime(activCast.getDtraTotalHours());
	                actSpc.setIntensity((byte)100);
	                actSpc.setLagTime((byte)0);
	                String dependents = this.calculateDependentActivities(activCast.getDependentActivities(), filterActivities);
	                if (dependents != null) {
	                    actSpc.setTimeDependency((byte)0);
	                	actSpc.setTimeDependentActivity(dependents);
	                }
	
	                activityLst.add(actSpc);
	                
	                Integer activityCount = activCast.getActivityCount();
	                
	                                                  	                		                
	                if(activityCount!=null && activityCount>1){
	                	for(int i=1;i<activityCount;++i){                		
	                		Activity newSpc = new Activity(); 
	                    	try {
	    						//BeanUtils.copyProperties(newSpc, actSpc);
	                    		wpCodeIdentifier = generateWPCode(countWPQuantity);           		                    		
	                    		newSpc = (Activity) BeanUtils.cloneBean(actSpc);
	                    		newSpc.setCatalogCode(iwpHead.getIwpUniqueId()+ UNDERSCORE + wpCodeIdentifier + (activCast.getDtraSerialId()*100+(i+1)));//	                    		
	                    		//newSpc.setCatalogCode(iwpHead.getIwpUniqueId()+ UNDERSCORE + ((activCast.getDtraSerialId()+WPActivityCount)*100+(i+1)));
	                    		activityLst.add(newSpc);
	    					} catch (IllegalAccessException | InvocationTargetException e) {
	    						// TODO Auto-generated catch block
	    						e.printStackTrace();
	    					} catch (InstantiationException e) {
	    						// TODO Auto-generated catch block
	    						e.printStackTrace();
	    					} catch (NoSuchMethodException e) {
	    						// TODO Auto-generated catch block
	    						e.printStackTrace();
	    					}                   		                       
	                	}                	                	
	                }  
	                
	                ActivityCount++;
					
				}
            }
            
            listIwps.add(iwp);
            listIwpsCodes.add(iwp.getWpID());
        }
        
        //PARA UN SOLO IWP
        //Iwp iwptmp = listIwps.get(0);
        //String stringtmp = listIwpsCodes.get(0);
        //listIwps.clear();
        //listIwpsCodes.clear();
        //listIwps.add(iwptmp);
        //listIwpsCodes.add(stringtmp);
            
            
            
            
        if (listIwps.size() > 0) {
            

            String spcDirectory = null;
            spcDirectory = retriveSettingService.getSettingParameterValue("WP_CREATION_DIRECTORY");
            workPackageFileName = retriveSettingService.getSettingParameterValue("WP_FILE_NAME");
            

            File spDirecotryFile = new File(spcDirectory);
            spDirecotryFile.mkdir();

            StringBuilder fileName = new StringBuilder();
            fileName.append(workPackageFileName);
            fileName.append(UNDERSCORE);
            fileName.append(new BigInteger(130, RANDOM).toString(32));
            fileName.append(XML_FILE_EXTENSION);

            Path filePath = Paths.get(spcDirectory, fileName.toString());
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Spc.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                File spc_newFile = new File(filePath.toString());
                jaxbMarshaller.marshal(spcContainer, spc_newFile);
                StringWriter bswContent = new StringWriter(); 
                jaxbMarshaller.marshal(spcContainer, bswContent);
                //TODO agregar el log
                //logger.info("File: " + filePath.toString());
                //logger.info("Total IWPs: " + fileDescription.getRecords().size());
                
                //////////////////
        		///create bulk
                String namefl = filePath.toString().substring(filePath.toString().lastIndexOf("\\")+1);
                String carpetaDestino = filePath.toString().substring(0,filePath.toString().lastIndexOf("\\"));
                SPCBulkLoader spcBulkLoader = SPCBulkLoader.getInstance();
                List<String> ecmXMLFromXML = null;
            	try {
					ecmXMLFromXML = spcBulkLoader.ecmXMLFromXML(bswContent.toString(),new File(carpetaDestino),100,namefl);
					
				} catch (SPCBulkLoaderException e) {
					e.printStackTrace();
				}
            	
            	//generating Structuture Lookup
            	String structureLookupFile = this.generateStructureLookupFile(records);
            	
            	
            	
            	ArrayList<File> listFiles=new ArrayList<File>();
                listFiles.add(spc_newFile);
                listFiles.add(new File(structureLookupFile));
                for (int i = 0; i < ecmXMLFromXML.size(); i++) {
                	String bulkFile = ecmXMLFromXML.get(i);
                	listFiles.add(new File(bulkFile));
				}
                workPackageNotification.sendCreationNotification(listFiles, listIwpsCodes, extraemails);
                //TODO reportar resultado logger.info("WP File (spc): " + file.getAbsoluteFile());
                //logger.info("Total IWPs: " + iwps.size());
                
                
            } catch (JAXBException e) {
            	e.printStackTrace();
            	//TODO agregar el log
                //logger.error("Error when creating workpackage file.");
            }
        }        	
    }
    
   
    
    private String generateStructureLookupFile(List<IwpCast> generatedIwps){
        //STRUCTRURE LOOKUP FILE GENREATION
        Structure structureLookup = new Structure();
		StructureLookupInfo structureLookUpInfo = structureLookup.getData(generatedIwps);
		StructureLookupInfoUpdated structureLookUpInfoUpdated = structureLookup.getDataF(generatedIwps);
		String create_file = structureLookup.generateFile(structureLookUpInfo, structureLookUpInfoUpdated);
		return create_file;
    }
    

    private String generateWPCode(int wp_count) {
    	if(wp_count > 0) {
    		int iCombination = 0;
    		for(char i = 'A'; i < 'Z'; i++) {
    			for(char j = 'A'; j < 'Z'; j++) {
    				if(iCombination == wp_count){
    					if(i != 'A')
    						return i+""+j;  
    					else
    						return j+"";
    				} else
    					iCombination++;
        		}
    		}
    	}    		
    	return "";
    }
    

	

}
