package com.ericsson.bugs.sdt.dtra.iwp.data.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ericsson.bugs.sdt.dtra.iwp.data.model.CompetenceDomain;




/**
 * 
 * @author ejuaolg
 *
 */
public interface CompetenceDomainRepository extends JpaRepository<CompetenceDomain, Long> {
	
	@Query("select a.name from CompetenceDomain a")
    List<String> getAllNames();
		    
}
