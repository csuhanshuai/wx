package com.qixin.app.zjminweb.service.imp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.dao.ActivitiesDao;
import com.qixin.app.zjminweb.model.Activities;
import com.qixin.app.zjminweb.service.ActivitiesService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class ActivitiesServiceImpl implements ActivitiesService
{
    @Resource
    private ActivitiesDao activitiesdao;

    @Override
    public PageFinder<Activities> getActivitiesByBid(Query query, String bid,
            String type) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        if (!CommonTool.isEmpty(type))
        {
            critMap.addEqual("type", type);
        }
        return (PageFinder<Activities>) this.activitiesdao.pagedByCritMap(
                critMap, query.getPage(), query.getPageSize());
    }

    @Override
    public Activities getActivitiesByid(String id) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Activities) this.activitiesdao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public String addActivities(Activities activities) throws Exception
    {
        return (String) this.activitiesdao.save(activities);
    }

    @Override
    public boolean removeActivities(String id) throws Exception
    {
        Activities zp = this.activitiesdao.getById(id);
        if (zp != null)
        {
            this.activitiesdao.remove(zp);
            return true;
        }
        return false;
    }

    @Override
    public String updateActivities(Activities activities) throws Exception
    {
        Activities pt = (Activities) this.activitiesdao.merge(activities);
        return pt.getId();
    }

    @Override
    public List<Activities> getActivities(String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        critMap.addLessAndEq("starttime", new Date());
        critMap.addGreatAndEq("endtime", new Date());
        return (List<Activities>) this.activitiesdao.findByCritMap(critMap);
    }

    @Override
    public List<Activities> getActivitiesBytype(String bid, String type)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        if (!CommonTool.isEmpty(type))
        {
            critMap.addEqual("type", type);
        }
        return (List<Activities>) this.activitiesdao.findByCritMap(critMap);
    }

	@Override
	public List<Activities> getActivitiesBytype(String type) throws Exception {
		CritMap critMap = new CritMap();
		if (!CommonTool.isEmpty(type)) {
			critMap.addEqual("type", type);
		}
		return (List<Activities>) this.activitiesdao.findByCritMap(critMap);
	}
}
