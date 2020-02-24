package com.ericsson.bugs.sdt.dtra.iwp.data.dao;


import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ericsson.bugs.sdt.dtra.iwp.data.model.CastLoadingSession;




/**
 * 
 * @author ejuaolg
 *
 */
public interface CastSessionRepository extends JpaRepository<CastLoadingSession, Long> {
	
	@Query("select max(sess.loadingDate) from CastLoadingSession sess")
    Date findLastLoadingDate();
	
		    
}
