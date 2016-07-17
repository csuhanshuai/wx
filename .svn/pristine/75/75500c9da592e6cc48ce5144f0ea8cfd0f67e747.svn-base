package com.qixin.app.zjmall.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjmall.dao.MallConfDao;
import com.qixin.app.zjmall.model.MallConf;
import com.qixin.app.zjmall.service.MallConfService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

/**  
 * 
 */
@Service
public class MallConfServiceImpl implements MallConfService {

	@Resource
	private MallConfDao mallconfdao;

	/**
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void delete(String id) throws Exception {

		mallconfdao.removeById(id);
	}

	@Override
	public MallConf findByid(String bizid) throws Exception {
		return mallconfdao.getById(bizid);
	}

	@Override
	public void save(MallConf mallconf) throws Exception {
		mallconfdao.save(mallconf);
		
	}

	@Override
	public PageFinder<MallConf> getAll(Query query) throws Exception {
		CritMap mp = new CritMap();
		return mallconfdao.pagedByCritMap(mp, query.getPage(), query
				.getPageSize());
	}

    @Override
    public void update(MallConf mallconf) throws Exception
    {
        mallconfdao.merge(mallconf);
        
    }

}
