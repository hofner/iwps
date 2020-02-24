package com.ericsson.bugs.sdt.dtra.iwp.data.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ericsson.bugs.sdt.dtra.iwp.data.model.NoManPowerAct;




/**
 * 
 * @author ejuaolg
 *
 */
public interface NoManPowerActRepository extends JpaRepository<NoManPowerAct, Long> {
	@Query("select a.name from NoManPowerAct a")
	List<String> getAllNames();
		    
}
