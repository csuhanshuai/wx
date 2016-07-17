package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Consumption;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface ConsumptionService
{
    public abstract PageFinder<Consumption> getConsumptionByMemberid(
            Query query, String memberid) throws Exception;

    public abstract String addConsumption(Consumption consumption)
            throws Exception;

    public abstract Consumption getConsumptionByid(String id) throws Exception;

    public abstract String updateConsumption(Consumption consumption)
            throws Exception;

    public abstract List<Consumption> getConsumptionByMemberid(String memberid)
            throws Exception;

    public abstract List<Consumption> getConsumptionByMemberid(String bid,
            String memberid, String type) throws Exception;
}
