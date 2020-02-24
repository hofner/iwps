package com.ericsson.bugs.sdt.dtra.iwp.cast.data.dao;

import java.util.List;

import com.ericsson.bugs.sdt.dtra.iwp.cast.data.model.VDTRAIntegration;

public interface IWPCastCustomRepository {
	List<VDTRAIntegration> findByListIwps(String iwps);

}
