package com.ericsson.bugs.sdt.dtra.iwp.cast.data.dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ericsson.bugs.sdt.dtra.iwp.cast.data.model.VDTRAIntegration;




/**
 * 
 * @author ejelgoz
 *
 */
public interface IWPCastRepository extends CrudRepository<VDTRAIntegration, Long> {

	
	@Query("select u from VDTRAIntegration u where u.lastUpdatedDate>= :lastUpdatedDate")
	List<VDTRAIntegration> findByLastDate(@Param("lastUpdatedDate")Date lastUpdatedDate);
	
	//@Query("select u from VDTRAIntegration u where u.IWPUniqueID is not null")
	@Query("select u from VDTRAIntegration u where u.idCompound.IWPUniqueID is not null")
	List<VDTRAIntegration> findAllNotNull();
	
	@Query("select u.idCompound.IWPUniqueID from VDTRAIntegration u group by u.idCompound.IWPUniqueID")
	List<String> findIwp();

    
}
