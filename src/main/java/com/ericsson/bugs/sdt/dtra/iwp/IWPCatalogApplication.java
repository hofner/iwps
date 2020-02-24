package com.ericsson.bugs.sdt.dtra.iwp;

import javax.naming.NamingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Entry point for IWP Catalog application.
 * 
 * @author ejelgoz
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan("com.ericsson.bugs.sdt.dtra.iwp")
public class IWPCatalogApplication {

	
	
    /**
     * Entry point for the application
     * 
     * @param args
     *            arguments of application
     * @throws NamingException
     */
    public static void main(String[] args) throws NamingException {
        SpringApplication.run(IWPCatalogApplication.class, args);
    
    }
    
    
       		

}
