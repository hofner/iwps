package com.ericsson.bugs.sdt.dtra.iwp.data.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ericsson.bugs.sdt.dtra.iwp.data.model.Setting;




/**
 * 
 * @author ejuaolg
 *
 */
public interface SettingsRepository extends JpaRepository<Setting, Long> {
	
	@Query("select sett.value from Setting sett where sett.code = :myCode")
    String getSettingParameterValue(@Param("myCode")String myCode);
	
		    
}
