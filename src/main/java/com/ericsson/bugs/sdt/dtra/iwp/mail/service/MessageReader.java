package com.ericsson.bugs.sdt.dtra.iwp.mail.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;


/**
 * The Class MessageReader.
 * 
 * 
 */
public class MessageReader {

    /** The logger. */
    private static Logger logger = Logger.getLogger(MessageReader.class);
    
    /**
     * Gets the raw html template.
     *
     * @param template the template
     * @return the raw html template
     */
    public static String getRawHtmlTemplate(String template) {
    	StringBuffer rawHtmlMessage =new StringBuffer("");
        try {
        	ClassLoader classLoader = MessageReader.class.getClassLoader();
        	BufferedReader br=new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream("static/html/"+template)));
        	String line=null;
        	while((line=br.readLine())!=null){
            	rawHtmlMessage.append(line+"\n");
            }
        	br.close();
        } catch (IOException e) {
            logger.error("Error when reading file " + template);
            logger.error(e.getMessage());
        }
        return rawHtmlMessage.toString();
    }

}
