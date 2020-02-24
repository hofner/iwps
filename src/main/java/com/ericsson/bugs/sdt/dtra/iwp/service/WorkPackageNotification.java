package com.ericsson.bugs.sdt.dtra.iwp.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ericsson.bugs.sdt.dtra.iwp.SendMail;
import com.ericsson.bugs.sdt.dtra.iwp.data.dao.SettingsRepository;
import com.ericsson.bugs.sdt.dtra.iwp.data.model.ReadinessRecordError;
import com.ericsson.bugs.sdt.dtra.iwp.mail.service.MessageReader;

/**
 * The Class WorkPackageCreationNotification.
 * 
 * 
 */
@Component
public class WorkPackageNotification {

    //private static final String NOT_APPLICABLE = "Not Applicable";

    /** The Constant SPLITTER. */
    private static final String SPLITTER = ",";

    /** The Constant OPEN_LIST_ELEMENT_TAG. */
    private static final String OPEN_LIST_ELEMENT_TAG = "<li>";

    /** The Constant WILDCARD_REPLACEMENT. */
    private static final String WILDCARD_REPLACEMENT = "#IWPs";
    
    /** The Constant WILDCARD_REPLACEMENT. */
    private static final String WILDCARD_COUNTING_IWP = "#iwpsnums";

    /** The creation html. */
    private static final String CREATION_HTML = "WorkPackageCreationNotification.html";

    /** The Constant CREATION_SUBJECT. */
    private static final String CREATION_SUBJECT = "IWP Loading Notification";

    /** The Constant GENERATION_HTML. */
    private static final String GENERATION_HTML = "WorkPackageGenerationNotification.html";

    /** The Constant GENERATION_SUBJECT. */
    private static final String GENERATION_SUBJECT = "IWP File Generation";

    /** The Constant NO_LOADING_HTML. */
    private static final String NO_LOADING_HTML = "WorkPackageNoLoadingNotification.html";

    /** The Constant NO_LOADING_SUBJECT. */
    private static final String NO_LOADING_SUBJECT = "No New IWP For Loading";

    /** The Constant WFM_WILDCARD_REPLACEMENT. */
    //private static final CharSequence WFM_WILDCARD_REPLACEMENT = "#WFM";

    /** The Constant OTHER_WILDCARD_REPLACEMENT. */
    private static final CharSequence OTHER_WILDCARD_REPLACEMENT = "#Other";

    /** The Constant GANTT_WILDCARD_REPLACEMENT. */
    //private static final CharSequence GANTT_WILDCARD_REPLACEMENT = "#Gantt";

    /** The Constant CREATION_ERROR_SUBJECT. */
    private static final String CREATION_ERROR_SUBJECT = "IWP Error Loading Notification";

    /** The Constant CREATION_ERROR_HTML. */
    private static final String CREATION_ERROR_HTML = "WorkPackageCreationErrorNotification.html";
    
    @Autowired(required=true)
    SendMail mailSender;
    
    @Autowired(required=true)
    SettingsRepository settingsDAO; 

    private WorkPackageNotification() {

    }

    /**
     * Send creation notification.
     *
     * @param spcFileList the spc file
     * @param iwps the iwps
     */
    public void sendCreationNotification(ArrayList<File> spcFileList, List<String> iwps, String extratos) {
        String htmlMessage = MessageReader.getRawHtmlTemplate(CREATION_HTML);
        StringBuilder iwpMessage = new StringBuilder();
        iwpMessage.append("<table>");
        for (String iwp : iwps) {
            iwpMessage.append("<tr>");
            iwpMessage.append("<td>");
            iwpMessage.append(iwp);
            iwpMessage.append("</td>");
            iwpMessage.append("</tr>");
        }
        iwpMessage.append("</table>");
        ArrayList<String> tos = new ArrayList<>(Arrays.asList(settingsDAO.getSettingParameterValue("MAIL_RECEIVER_IWP_LOADING").split(SPLITTER)));
        tos.addAll(Arrays.asList(extratos.split(SPLITTER)));        
        htmlMessage = htmlMessage.replace(WILDCARD_REPLACEMENT, iwpMessage.toString());
        htmlMessage = htmlMessage.replace(WILDCARD_COUNTING_IWP, ""+iwps.size());
        mailSender.sendHTMLMessage(spcFileList, CREATION_SUBJECT, htmlMessage, tos.toArray(new String[ tos.size() ]));
    }

    /**
     * Send generation notification.
     *
     * @param spcAndFiles the spc file
     * @param iwps the iwps
     */
    public void sendGenerationNotification(ArrayList<File> spcAndFiles, List<String> iwps, String extratos) {
        
        String htmlMessage = MessageReader.getRawHtmlTemplate(GENERATION_HTML);
        StringBuilder iwpMessage = new StringBuilder();
        for (String iwp : iwps) {
            iwpMessage.append(OPEN_LIST_ELEMENT_TAG);
            iwpMessage.append(iwp);
        }
        ArrayList<String> tos = new ArrayList<>(Arrays.asList(settingsDAO.getSettingParameterValue("MAIL_RECEIVER_IWP_LOADING").split(SPLITTER)));
        tos.addAll(Arrays.asList(extratos.split(SPLITTER)));  
        htmlMessage = htmlMessage.replace(WILDCARD_REPLACEMENT, iwpMessage.toString());
        htmlMessage = htmlMessage.replace(WILDCARD_COUNTING_IWP, ""+iwps.size());
        mailSender.sendHTMLMessage(spcAndFiles, GENERATION_SUBJECT, htmlMessage, tos.toArray(new String[tos.size()]));
    }

    /**
     * Send no loading notification.
     */
    public void sendNoLoadingNotification(String extratos) {
        
        String htmlMessage = MessageReader.getRawHtmlTemplate(NO_LOADING_HTML);
        ArrayList<String> tos = new ArrayList<>(Arrays.asList(settingsDAO.getSettingParameterValue("MAIL_RECEIVER_IWP_LOADING").split(SPLITTER)));
        tos.addAll(Arrays.asList(extratos.split(SPLITTER)));  
        mailSender.sendHTMLMessage(NO_LOADING_SUBJECT, htmlMessage, tos.toArray(new String[tos.size()]));
    }

    
    public void sendCreationError(List<ReadinessRecordError> errorsList, String extratos){
    	
        String htmlMessage = MessageReader.getRawHtmlTemplate(CREATION_ERROR_HTML);
        // Other Reasons
        StringBuilder otherMessage = new StringBuilder();
        
        otherMessage.append("<table style=\"border:1px solid;\">");
        otherMessage.append("<tr>");
        otherMessage.append("<th>IWP</th>");
        otherMessage.append("<th>Error</th>");
        otherMessage.append("<th>Service Area</th>");
        otherMessage.append("<th>Competence Domain</th>");
        otherMessage.append("<th>Competence Subdomain</th>");
        otherMessage.append("</tr>");
        
        for (ReadinessRecordError rec : errorsList) {
        	otherMessage.append("<tr>");
            otherMessage.append("<td style=\"border:1px solid; \">");
            otherMessage.append(rec.getIwpId());
            otherMessage.append("</td>");
            otherMessage.append("<td style=\"border:1px solid;\">");
            otherMessage.append(rec.getDescription());
            otherMessage.append("</td>");
            otherMessage.append("<td style=\"border:1px solid;\">");
            otherMessage.append(rec.getServiceArea());
            otherMessage.append("</td>");
            otherMessage.append("<td style=\"border:1px solid;\">");
            otherMessage.append(rec.getCompetenceDomain());
            otherMessage.append("</td>");
            otherMessage.append("<td style=\"border:1px solid;\">");
            otherMessage.append(rec.getCompetenceSubDomain());
            otherMessage.append("</td>");
            otherMessage.append("</tr>");
		}
        otherMessage.append("</table>");
        
        htmlMessage = htmlMessage.replace(OTHER_WILDCARD_REPLACEMENT, otherMessage.toString());
        // Send message
        ArrayList<String> tos = new ArrayList<>(Arrays.asList(settingsDAO.getSettingParameterValue("MAIL_RECEIVER_IWP_LOADING").split(SPLITTER)));
        tos.addAll(Arrays.asList(extratos.split(SPLITTER)));  
        mailSender.sendHTMLMessage(CREATION_ERROR_SUBJECT, htmlMessage, tos.toArray(new String[tos.size()]));
    	
    }
    
    
    
    

}
