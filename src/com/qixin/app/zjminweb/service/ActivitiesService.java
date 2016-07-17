package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Activities;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface ActivitiesService
{
    public abstract PageFinder<Activities> getActivitiesByBid(Query query,
            String bid, String type) throws Exception;

    public abstract Activities getActivitiesByid(String id) throws Exception;

    public abstract String addActivities(Activities activities)
            throws Exception;

    public abstract boolean removeActivities(String id) throws Exception;

    public abstract String updateActivities(Activities activities)
            throws Exception;

    public abstract List<Activities> getActivities(String bid) throws Exception;

    public abstract List<Activities> getActivitiesBytype(String bid, String type)
            throws Exception;
    
    public abstract List<Activities> getActivitiesBytype(String type)
    throws Exception;
    
}
