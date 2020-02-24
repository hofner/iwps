package com.ericsson.bugs.sdt.dtra.iwp.webservice;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ericsson.bugs.sdt.dtra.iwp.cast.data.model.VDTRAIntegration;
import com.ericsson.bugs.sdt.dtra.iwp.data.mapper.IWPViewMapperService;
import com.ericsson.bugs.sdt.dtra.iwp.data.model.IwpCast;
import com.ericsson.bugs.sdt.dtra.iwp.service.CastSessionServices;
import com.ericsson.bugs.sdt.dtra.iwp.service.IwpCastServices;
import com.ericsson.bugs.sdt.dtra.iwp.service.IwpFilter;
import com.ericsson.bugs.sdt.dtra.iwp.service.SPCWPGeneratorService;
import com.ericsson.bugs.sdt.dtra.iwp.service.WorkPackageNotification;


/**
 * The Web Service for General Catalog requests.
 * @author ejelgoz
 */
@Controller
@EnableWebMvc
@RequestMapping(value = "/")
public class GeneralCatalogController extends WebMvcConfigurerAdapter {

    /** Logger for Security Application. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralCatalogController.class);

   
    private static final String CASTIWP_MODEL = "/castIwpModel";
    
    private static final String POPULATE = "/populateFromView";
    
    private static final String LASTSDATE_UPDATE = "/lastDate_Update";
    
    private static final String SPC_GENERATE = "/spcgenerate";
    private static final String SPC_GENERATEALL = "/spcgenerateall";
    
    /** The Constant COST_MODEL. */
    private static final String GET_IWP = "/getIwp";
    /** The Constant COST_MODEL. */
    private static final String UPDATE_IWP = "/updateIwp";

     
    @Autowired(required=true)
    IwpCastServices getIwpCastServices;
        
        
    @Autowired(required=true)
    CastSessionServices castSessionServices;
    
    @Autowired(required=true)
    IWPViewMapperService viewMapperService; 
    
    @Autowired(required=true)
    SPCWPGeneratorService spcWPGeneratorService;
    
    @Autowired(required=true)
    WorkPackageNotification  workPackageNotification;
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);        
       
        //registry.addResourceHandler("/css/**").addResourceLocations("file:///"+new File("C:\\Users\\egozjos\\Documents\\DTRA\\spom2\\spom\\dtra-iwp-catalog\\src\\main\\resources\\templates").getAbsolutePath()+"/css/");
        registry.addResourceHandler("/css/**").addResourceLocations("file:///"+(new File(".")).getAbsolutePath()+"/css/");        
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);        
        registry.addViewController("/home").setViewName("home");        
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
	
    
    @RequestMapping(value="/")
    public String homepage() {
        return "home";
    }
    /**
     * Gets the cost model list.
     *
     * @return the cost model list
     */
    @RequestMapping(value = CASTIWP_MODEL, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<VDTRAIntegration>> getCastIwpList() {
        LOGGER.info("Request received to load all cost models");
        List<VDTRAIntegration> result = getIwpCastServices.findAllNotNull();
        //sendMail.send();
        HttpStatus status = HttpStatus.OK;
        if (result == null) {
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<List<VDTRAIntegration>>(result, status);
    }
    
    
    
    /**
     * Gets the cost model list.
     *
     * @return the cost model list
     */
    @RequestMapping(value = POPULATE, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<VDTRAIntegration>> populateFromView() {
        LOGGER.info("Request received to load all cost models");
        List<VDTRAIntegration> result = getIwpCastServices.findAllNotNull();
        //sendMail.send();
        HttpStatus status = HttpStatus.OK;
        if (result == null) {
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<List<VDTRAIntegration>>(result, status);
    }
    
    /**
     * Gets the cost model d.
     * @return the cost model list
     */
    @RequestMapping(value = LASTSDATE_UPDATE, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Date> getLastUpdate() {
        LOGGER.info("Request received to load all cost models");
        Date result = castSessionServices.getCastLastSession();
        LOGGER.info("date   "+result);
       // Date result=new Date();
        HttpStatus status = HttpStatus.OK;
        if (result == null) {
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<Date>(result, status);
    }
    
      
    

       
    /**
     * Gets the cost model d.
     * @return the cost model list
     */
    @RequestMapping(value = SPC_GENERATE, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Date> spcGenerate(@RequestParam HashMap<String, String> iwpslistParams) {    	
        LOGGER.info("Request received to load all cost models");
        Date result = castSessionServices.getCastLastSession();
        //result=new Date();
        
        LOGGER.info("date   "+result);
        LOGGER.info("Request received to load all cost models");
        
        String iwpslist = "";
        String iwpsIDlist = "";
        String dbCube = "";
        String emails = "";
        if(iwpslistParams.containsKey("iwps"))
        	iwpslist = iwpslistParams.get("iwps");
        if(iwpslistParams.containsKey("iwpIDs"))
        	iwpsIDlist = iwpslistParams.get("iwpIDs");
        if(iwpslistParams.containsKey("db"))
        	dbCube = iwpslistParams.get("db");
        if(iwpslistParams.containsKey("emails"))
        	emails = iwpslistParams.get("emails");
                
        iwpslist = iwpslist.replaceAll("%2c", ",").replaceAll("%2C", ",").replaceAll("\n", ",").replaceAll("\r", "");
        iwpsIDlist = iwpsIDlist.replaceAll("%2c", ",").replaceAll("%2C", ",").replaceAll("\n", ",").replaceAll("\r", "");
        
        List<VDTRAIntegration> unnormalized = new ArrayList<VDTRAIntegration>();
        if(iwpslist.equals("") && iwpsIDlist.equals("")){
        	unnormalized = getIwpCastServices.findAll();
        } if(!iwpslist.equals("")) {
        	unnormalized = getIwpCastServices.findByUniqueIds(iwpslist);        
        } if(!iwpsIDlist.equals("")) {
        	unnormalized.addAll( getIwpCastServices.findByIds(iwpsIDlist) );        
        }
                
        emails = emails.replaceAll("%2c", ",").replaceAll("\n", ",").replaceAll("\r", "");
        emails = emails.replaceAll("%2C", ",").replaceAll("\n", ",").replaceAll("\r", "");
        //getIwpCastServices.getIwpRepositoryCast()        
        ArrayList<IwpCast> iwpCastList = viewMapperService.createIWPEntity(unnormalized);         
        	
        IwpFilter filtered = viewMapperService.validateIwpCast(iwpCastList, iwpslist);      
        workPackageNotification.sendCreationError( filtered.getErrorsList(), emails);        
        spcWPGeneratorService.generateSPCIWPList( filtered.getIwpsPreList(), emails );
        //spcWPGeneratorService.generateSPCIWPList(iwpCastList);
        
                
        HttpStatus status = HttpStatus.OK;
        if (result == null) {
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<Date>(result, status);
    }
    
    @RequestMapping(value = SPC_GENERATEALL, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Date> spcGenerate() {
        LOGGER.info("Request received to load all cost models");
        Date result = castSessionServices.getCastLastSession();
        //result=new Date();
        
        LOGGER.info("date   "+result);
        LOGGER.info("Request received to load all cost models");
        
        List<VDTRAIntegration> unnormalized = null;
        unnormalized = getIwpCastServices.findAll();
        //getIwpCastServices.getIwpRepositoryCast()
        ArrayList<IwpCast> iwpCastList = viewMapperService.createIWPEntity(unnormalized);
        IwpFilter filtered = viewMapperService.validateIwpCast(iwpCastList , null);
        workPackageNotification.sendCreationError(filtered.getErrorsList(), "");
        spcWPGeneratorService.generateSPCIWPList(filtered.getIwpsPreList() , "");
        //spcWPGeneratorService.generateSPCIWPList(iwpCastList);
        
        
        HttpStatus status = HttpStatus.OK;
        if (result == null) {
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<Date>(result, status);
    }
    
    /**
     * Gets the cost model list.
     *
     * @return the cost model list
     */
    @RequestMapping(value = UPDATE_IWP, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> updateIWP(@RequestParam("data") List<String> iwp) {
    	System.out.println("update iwp");
        LOGGER.info("Request received to load all cost models");
        String result=null;
        System.out.println(iwp.toString()+"---"+iwp.size());
        //List<String> result = getIwpCastServices.findIWP();
        //sendMail.send();
        HttpStatus status = HttpStatus.OK;
        if (result == null) {
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<String>(result, status);
    }

    
    /**
     * 
     *
     * @return the cost model list
     */
    @RequestMapping(value = GET_IWP, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<String>> getIWP() {
        LOGGER.info("Request received to load all cost models");
        List<String> result = getIwpCastServices.findIWP();
        //sendMail.send();
        HttpStatus status = HttpStatus.OK;
        if (result == null) {
            status = HttpStatus.NO_CONTENT;
        }        
        return new ResponseEntity<List<String>>(result, status);
    }
}
