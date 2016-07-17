package com.qixin.app.zjmall.service;

import com.qixin.app.zjmall.model.MallConf;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

/**  
 * 
 */
public interface MallConfService {

	public void save(MallConf mallconf ) throws Exception;
	
	public void update(MallConf mallconf ) throws Exception;

	public void delete(String id) throws Exception;

	public PageFinder<MallConf> getAll(Query query) throws Exception;

	public MallConf findByid(String bizid) throws Exception;

}
