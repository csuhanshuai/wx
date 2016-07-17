package com.qixin.app.card.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.card.dao.ConfigDao;
import com.qixin.app.card.dao.PrizerecordDao;
import com.qixin.app.card.dao.PrizeConfigDao;
import com.qixin.app.card.model.Config;
import com.qixin.app.card.model.Prizerecord;
import com.qixin.app.card.model.PrizeConfig;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class cardServices
{

    @Resource
    private PrizerecordDao employeeDao;

    @Resource
    private ConfigDao configDao;

    @Resource
    private PrizeConfigDao prizeConfigDao;

    public PageFinder<Prizerecord> queryEmployees(Prizerecord employee,
            Query query)
    {

        CritMap critMap = new CritMap();
        if (employee.getName() != null)
            critMap.addLike("name", employee.getName());
        if (employee.getMobilephone() != null)
            critMap.addLike("mobilephone", employee.getMobilephone());
        // if (employee.getIsPrizes())
        critMap.addEqual("isreg", 1);
        critMap.addEqual("activitiesid", employee.getActivitiesid());

        return employeeDao.pagedByCritMap(critMap, query.getPage(),
                query.getPageSize());
    }

    public Prizerecord queryEmployeesByOpenId(String openId)
    {

        CritMap critMap = new CritMap();
        critMap.addEqual("openid", openId);
        return employeeDao.getObjectByCritMap(critMap, true);
    }

    public Prizerecord queryEmployeesByOpenId(String openId, String activitiesid)
    {

        CritMap critMap = new CritMap();
        critMap.addEqual("openid", openId);
        critMap.addEqual("activitiesid", activitiesid);
        critMap.addEqual("isprizes", 1);
        return employeeDao.getObjectByCritMap(critMap, true);
    }

    public List<Prizerecord> queryEmployeeList()
    {

        return employeeDao.getAll();
    }

    public void addEmployee(Prizerecord employee)
    {

        try
        {
            employeeDao.save(employee);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Config> queryConfigList()
    {

        return configDao.getAll();
    }

    public Config queryConfig(String id)
    {

        return configDao.getById(id);
    }

    public Config queryConfigByName(String name)
    {

        CritMap critMap = new CritMap();
        critMap.addEqual("name", name);
        return configDao.getObjectByCritMap(critMap, true);
    }

    /**
     * 修改配置項
     * 
     * @param config
     */
    public void updateConfig(Config config)
    {

        try
        {
            configDao.save(config);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 查询球队
     */
    public List<PrizeConfig> queryPrizeConfig()
    {

        return prizeConfigDao.getAll();
    }

    /**
     * 查询球队
     */
    public PrizeConfig queryPrizeConfigById(String id)
    {

        return prizeConfigDao.getById(id);
    }

    /**
     * 增加球队
     * 
     * @param teamInfo
     */
    public String addPrizeConfig(PrizeConfig teamInfo)
    {

        try
        {
            prizeConfigDao.save(teamInfo);

        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return teamInfo.getId();
    }

    /**
     * 删除球队
     * 
     * @param teamInfo
     */
    public void delPrizeConfig(int id)
    {

        try
        {
            prizeConfigDao.removeById(id);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /*
     * public PageFinder<PrizeInfo> queryPrizeInfoList(PrizeInfo prizeInfo,
     * Query query) {
     * 
     * CritMap critMap = new CritMap(); if (prizeInfo.getMobilephone() != null)
     * critMap.addLike("mobilephone", prizeInfo.getMobilephone()); if
     * (prizeInfo.getName() != null) critMap.addLike("mobilephone",
     * prizeInfo.getName());
     * 
     * return deliveryInfoDao.pagedByCritMap(critMap, query.getPage(),
     * query.getPageSize()); }
     * 
     * public PrizeInfo queryPrizeInfoByOpenId(String openId) {
     * 
     * CritMap critMap = new CritMap();
     * 
     * critMap.addLike("openid", openId);
     * 
     * return deliveryInfoDao.getObjectByCritMap(critMap, true); }
     * 
     * public PrizeInfo queryPrizeInfoById(int id) {
     * 
     * return deliveryInfoDao.getById(id); }
     * 
     * public PrizeInfo addPrizeInfo(PrizeInfo deliveryInfo) {
     * 
     * try { return deliveryInfoDao.saveObject(deliveryInfo); } catch (Exception
     * e) { // TODO Auto-generated catch block e.printStackTrace(); } return
     * null; }
     */
}
