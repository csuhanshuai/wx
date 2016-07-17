package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Integralexchangerecord;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface IntegralexchangerecordService
{
    public abstract PageFinder<Integralexchangerecord> getIntegralexchangerecord(
            Query query, String bid, String integralexchangeid, String isuse,
            String memberid) throws Exception;

    public abstract List<Integralexchangerecord> getIntegralexchangerecord(
            String id, String memberid, String bid) throws Exception;

    public abstract String addIntegralexchangerecord(
            Integralexchangerecord integralexchangerecord) throws Exception;

    public abstract String updateIntegralexchangerecord(
            Integralexchangerecord integralexchangerecord) throws Exception;

    public abstract Integralexchangerecord getIntegralexchangerecordByid(
            String id) throws Exception;

    public abstract List<Integralexchangerecord> getIntegralexchangerecordBymemberid(
            String bid, String memberid, String isuse) throws Exception;

    public abstract Integralexchangerecord getIntegralexchangerecordBytype(
            String memberid, String activitiesid, String type) throws Exception;
}
