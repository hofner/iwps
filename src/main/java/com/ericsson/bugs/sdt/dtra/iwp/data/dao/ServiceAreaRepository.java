package com.ericsson.bugs.sdt.dtra.iwp.data.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ericsson.bugs.sdt.dtra.iwp.data.model.ServiceArea;




/**
 * 
 * @author ejuaolg
 *
 */
public interface ServiceAreaRepository extends JpaRepository<ServiceArea, Long> {
	
	@Query("select a.name from ServiceArea a")
	List<String> getAllNames();
		    
}
