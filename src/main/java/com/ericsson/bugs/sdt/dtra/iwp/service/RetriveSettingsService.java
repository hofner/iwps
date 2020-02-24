package com.ericsson.bugs.sdt.dtra.iwp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsson.bugs.sdt.dtra.iwp.data.dao.SettingsRepository;

@Service
@Transactional
/**
 * This Service retrives all values from the catalog: SETTING from such table
 * @author ejuaolg
 *
 */
public class RetriveSettingsService {
    /** The country repo. */
    @Autowired(required=true)
    private SettingsRepository settingsRepository;
    
    
    

    public String getSettingParameterValue(String myCode){
    	String value = null;
        try{
        value = settingsRepository.getSettingParameterValue(myCode);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return value;
    }




	public SettingsRepository getSettingsRepository() {
		return settingsRepository;
	}




	public void setSettingsRepository(SettingsRepository settingsRepository) {
		this.settingsRepository = settingsRepository;
	}    
}
