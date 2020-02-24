package com.ericsson.bugs.sdt.dtra.iwp.data.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ericsson.bugs.sdt.dtra.iwp.data.model.NoManPowerJobRole;




/**
 * 
 * @author ejuaolg
 *
 */
public interface NoManPowerJobRoleRepository extends JpaRepository<NoManPowerJobRole, Long> {
	@Query("select a.name from NoManPowerJobRole a")
	List<String> getAllNames();
		    
}
