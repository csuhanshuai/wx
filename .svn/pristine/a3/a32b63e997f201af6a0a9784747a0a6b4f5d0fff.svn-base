package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.DiaoyanDao;
import com.qixin.app.zjminweb.dao.DiaoyanUserDao;
import com.qixin.app.zjminweb.dao.TitleDao;
import com.qixin.app.zjminweb.dao.TitleItemDao;
import com.qixin.app.zjminweb.model.Diaoyan;
import com.qixin.app.zjminweb.model.DiaoyanUser;
import com.qixin.app.zjminweb.model.TitleInfo;
import com.qixin.app.zjminweb.model.TitleItems;
import com.qixin.app.zjminweb.service.DiaoyanService;
import com.qixin.platform.persistent.database.basedao.CritMap;


@Service
public class DiaoyanServiceImpl implements DiaoyanService
{
	@Resource
	private DiaoyanDao diaoyanDao;
	
	@Resource
	private TitleDao titleDao;
	
	@Resource
	private TitleItemDao titleItemDao;
	
	@Resource
	private DiaoyanUserDao diaoyanUserDao;

	@Override
	public List<Diaoyan> getDiaoyanListByBid(String bid) 
	{
		CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (List<Diaoyan>) this.diaoyanDao.findByCritMap(critMap,
                new boolean[] { true });
	}

	@Override
	public String addDiaoyan(Diaoyan diaoyan) throws Exception 
	{
		return (String) this.diaoyanDao.save(diaoyan);
	}

	@Override
	public Diaoyan getDiaoyanById(String id) 
	{
		CritMap critMap = new CritMap();
	    critMap.addEqual("id", id);
	    return (Diaoyan) this.diaoyanDao.getObjectByCritMap(critMap, new boolean[] { true });
	}

	@Override
	public String updateDiaoyanById(Diaoyan dy) 
	{
		Diaoyan pt = (Diaoyan) this.diaoyanDao.merge(dy);
        return pt.getId();
	}

	@Override
	public void deleteDiaoyanById(String id) throws Exception 
	{
		this.diaoyanDao.removeById(id);
	}

	@Override
	public List<TitleInfo> getTitleListById(String id) 
	{
		CritMap critMap = new CritMap();
        critMap.addEqual("relationDiaoyanId", id);
        return (List<TitleInfo>) this.titleDao.findByCritMap(critMap,
                new boolean[] { true });
	}

	@Override
	public String addDiaoyanTitle(TitleInfo titleInfo) throws Exception 
	{
		return (String) this.titleDao.save(titleInfo);
	}

	@Override
	public void deleteTitleById(String id) throws Exception 
	{
		this.titleDao.removeById(id);
	}

	@Override
	public void updateTitleById(TitleInfo ti) 
	{
		this.titleDao.merge(ti);
		
	}

	@Override
	public TitleInfo getTitleById(String id) 
	{
		CritMap critMap = new CritMap();
	    critMap.addEqual("id", id);
	    return (TitleInfo) this.titleDao.getObjectByCritMap(critMap, new boolean[] { true });
	}
	
	public List<TitleInfo> getTitleByDiaoyanId(String id)
	{
		CritMap critMap = new CritMap();
	    critMap.addEqual("relation_diaoyan_id", id);
	    return (List<TitleInfo>) this.titleDao.findByCritMap(critMap, new boolean[] { true });
	}

	@Override
	public void addTitleSelect(List<TitleItems> listItems) throws Exception 
	{
		for(TitleItems it : listItems)
		{
			this.titleItemDao.save(it);
		}
		
	}

	@Override
	public List<TitleItems> getTitleItemsById(String titleId) 
	{
		CritMap critMap = new CritMap();
        critMap.addEqual("titleId", titleId);
        //critMap.addIN("titleId", titleId.split(","));
		return this.titleItemDao.findByCritMap(critMap,new boolean[]{true});
	}

	@Override
	public void upateTitleSelect(List<TitleItems> listItems) 
	{
		for(TitleItems it : listItems)
		{
			this.titleItemDao.merge(it);
		}
	}

	@Override
	public List<TitleItems> getTitleItemsByIds(String titleIds) 
	{
		CritMap critMap = new CritMap();
        critMap.addIN("titleId", titleIds.split(","));
		return this.titleItemDao.findByCritMap(critMap,new boolean[]{true});
	}

	@Override
	public void addUserData(DiaoyanUser diaoyanUser) throws Exception 
	{
		this.diaoyanUserDao.save(diaoyanUser);
	}

	@Override
	public List<TitleItems> getTitleItemsByItemIds(String ids) {
		CritMap critMap = new CritMap();
		critMap.addIN("id", ids.split(","));
		return this.titleItemDao.findByCritMap(critMap,new boolean[]{true});
	}

	@Override
	public void updateItemsTimes(TitleItems i) 
	{
		this.titleItemDao.merge(i);
	}
}
