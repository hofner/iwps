package com.ericsson.bugs.sdt.dtra.iwp.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsson.bugs.sdt.dtra.iwp.cast.data.dao.IWPCastFinders;
import com.ericsson.bugs.sdt.dtra.iwp.cast.data.dao.IWPCastRepository;
import com.ericsson.bugs.sdt.dtra.iwp.cast.data.model.VDTRAIntegration;

@Service
@Transactional
/**
 * 
 * @author ejelgoz
 *
 */
public class IwpCastServices {
    /** The country repo. */
    @Autowired(required=true)
    private IWPCastRepository iwpCastRepository;
    
    @Autowired(required=true)
    private IWPCastFinders iwpCastFinder;
    
    
    public List<VDTRAIntegration> findAllNotNull(){
        List<VDTRAIntegration> list=null;
        try{
        list=iwpCastRepository.findAllNotNull();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }    
    public List<VDTRAIntegration> findAll(){
        List<VDTRAIntegration> list=null;
        try{
        list=(List<VDTRAIntegration>) iwpCastRepository.findAll();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<VDTRAIntegration> findByUniqueIds(String ids){
        List<VDTRAIntegration> list=null;
        try{
        list=(List<VDTRAIntegration>) iwpCastFinder.findByListIwps(ids);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    
    public List<VDTRAIntegration> findByIds(String ids){
        List<VDTRAIntegration> list=null;
        try{
        list=(List<VDTRAIntegration>) iwpCastFinder.findByListIwpIDs(ids);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    public List<String> findIWP(){
        List<String> list=null;
        try{
        list=(List<String>) iwpCastRepository.findIwp();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
	public IWPCastRepository getIwpCastRepository() {
		return iwpCastRepository;
	}
	public void setIwpCastRepository(IWPCastRepository iwpCastRepository) {
		this.iwpCastRepository = iwpCastRepository;
	}
}
