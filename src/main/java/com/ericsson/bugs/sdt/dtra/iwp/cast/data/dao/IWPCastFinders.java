package com.ericsson.bugs.sdt.dtra.iwp.cast.data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ericsson.bugs.sdt.dtra.iwp.cast.data.model.VDTRAIntegration;

@Repository
public class IWPCastFinders implements IWPCastCustomRepository {
	@Autowired
	@PersistenceContext(unitName="sqlserver")
	@Qualifier("entityManagerFactory")
	private EntityManager entityManagerFactory;
	
	@SuppressWarnings("unchecked")
	public List<VDTRAIntegration> findByListIwps(String iwps) {
		String[] list = iwps.split(",");
		String query="select u from VDTRAIntegration u where IWPUniqueID in (";
		StringBuffer params=new StringBuffer();
		for (String single : list) {
			params.append("'"+single+"',");
		}
		params=new StringBuffer(params.substring(0,params.lastIndexOf(",")));
		query=query+params+") order by IWPUniqueID,ActivitySerialID";
		Query queryEmployees = entityManagerFactory.createQuery(query);
		
		return queryEmployees.getResultList();
    }
	
	
	@SuppressWarnings("unchecked")
	public List<VDTRAIntegration> findByListIwpIDs(String iwps) {
		String[] list = iwps.split(",");
		String query="select u from VDTRAIntegration u where IWPID in (";
		StringBuffer params=new StringBuffer();
		for (String single : list) {
			params.append("'"+single+"',");
		}
		params=new StringBuffer(params.substring(0,params.lastIndexOf(",")));
		query=query+params+") order by IWPUniqueID,ActivitySerialID";
		Query queryEmployees = entityManagerFactory.createQuery(query);
		
		return queryEmployees.getResultList();
    }


}
