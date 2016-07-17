package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Integral;
import com.qixin.app.zjminweb.model.Member;

public abstract interface IntegralService
{
    public abstract List<Integral> getIntegralByBid(String bid, String memberid)
            throws Exception;

    public abstract List<Integral> getIntegralByBid(String bid,
            String memberid, String type) throws Exception;

    public abstract List<Integral> getIntegralByNowDate(String memberid)
            throws Exception;

    public abstract String addIntegral(Integral integral) throws Exception;

    public abstract void addIntegral(Member member, String type, String score,
            String description);
}
