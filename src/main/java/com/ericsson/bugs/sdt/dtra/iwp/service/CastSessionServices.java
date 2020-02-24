package com.ericsson.bugs.sdt.dtra.iwp.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsson.bugs.sdt.dtra.iwp.data.dao.CastSessionRepository;
import com.ericsson.bugs.sdt.dtra.iwp.data.model.CastLoadingSession;

@Service
@Transactional
/**
 * 
 * @author ejuaolg
 *
 */

public class CastSessionServices {
    /** The country repo. */
    @Autowired(required=true)
    private CastSessionRepository castSession;
 
    
    
    

    public Date getCastLastSession(){
    	Date myLastUploading = null;
    	try{
    		myLastUploading = castSession.findLastLoadingDate();
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
        return myLastUploading;
    }
    
    public void saveCastSessionLoading(CastLoadingSession castLoadingSession){
    	castSession.save(castLoadingSession);
    }
    
	public CastSessionRepository getCastSession() {
		return castSession;
	}




	public void setCastSession(CastSessionRepository castSession) {
		this.castSession = castSession;
	}    
}
