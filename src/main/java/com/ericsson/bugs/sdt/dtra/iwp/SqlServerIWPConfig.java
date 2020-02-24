package com.ericsson.bugs.sdt.dtra.iwp;


import javax.persistence.EntityManagerFactory;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( 
         entityManagerFactoryRef = "iwpEntityManagerFactory",  
         transactionManagerRef = "iwpTransactionManager", 
        basePackages = { "com.ericsson.bugs.sdt.dtra.iwp.cast.data.dao" }) 


//@EntityScan ( "com.ericsson.bugs.sdt.dtra.iwp.cast.data.model")
/**
 * 
 * @author ejelgoz
 *
 */
public class SqlServerIWPConfig {

    	 @Bean(name = "iwpDataSource") 
         @ConfigurationProperties(prefix="datasource.iwp") 
         public DataSource iwpDataSource() { 
             return (DataSource) DataSourceBuilder.create().build(); 
        } 
    	 
    	
     
     
         @Bean(name = "iwpEntityManagerFactory") 
         public LocalContainerEntityManagerFactoryBean iwpEntityManagerFactory( 
                 EntityManagerFactoryBuilder builder, 
                 @Qualifier("iwpDataSource") DataSource iwpDataSource) { 
             return builder 
                     .dataSource(iwpDataSource) 
                     .packages("com.ericsson.bugs.sdt.dtra.iwp.cast.data.model") 
                    .persistenceUnit("sqlserver") 
                     .build(); 
        } 
     
     
         @Bean(name = "iwpTransactionManager") 
         public PlatformTransactionManager iwpTransactionManager( 
                 @Qualifier("iwpEntityManagerFactory") EntityManagerFactory iwpEntityManagerFactory) { 
             return new JpaTransactionManager(iwpEntityManagerFactory); 
         } 

}
