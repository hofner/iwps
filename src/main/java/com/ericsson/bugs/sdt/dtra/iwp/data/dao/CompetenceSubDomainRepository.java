package com.ericsson.bugs.sdt.dtra.iwp.data.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ericsson.bugs.sdt.dtra.iwp.data.model.CompetenceSubDomain;




/**
 * 
 * @author ejuaolg
 *
 */
public interface CompetenceSubDomainRepository extends JpaRepository<CompetenceSubDomain, Long> {
	
	@Query("select a.name from CompetenceSubDomain a")
	List<String> getAllNames();
		    
}
