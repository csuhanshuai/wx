package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Integralexchange;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface IntegralexchangeService
{
    public abstract PageFinder<Integralexchange> getIntegralexchangeByBid(
            Query query, String bid) throws Exception;

    public abstract boolean removeIntegralexchange(String id) throws Exception;

    public abstract String addIntegralexchange(Integralexchange integralexchange)
            throws Exception;

    public abstract Integralexchange getIntegralexchangeByid(String id)
            throws Exception;

    public abstract List<Integralexchange> getIntegralexchangeByBid(String bid)
            throws Exception;

    public abstract String updateIntegralexchange(
            Integralexchange integralexchange) throws Exception;
}
