package com.qixin.app.wobble.service;

import java.util.List;

import com.qixin.app.wobble.model.Wobbleprizerecord;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public interface WobbleprizerecordService
{
    public abstract Wobbleprizerecord getPrizerecordByOpenId(String openid,
            String bid, String activitiesid) throws Exception;

    public abstract Wobbleprizerecord getPrizerecordByWin(String openid,
            String bid, String activitiesid) throws Exception;

    public abstract String addPrizerecord(Wobbleprizerecord prizerecord)
            throws Exception;

    public abstract List<Wobbleprizerecord> getPrizerecordBybid(String bid,
            String activitiesid) throws Exception;

    public abstract PageFinder<Wobbleprizerecord> getPrizerecordBybid(
            Query query, String bid, String activitiesid, String name,
            String mobilephone, String isreg) throws Exception;

    public abstract Wobbleprizerecord getPrizerecordByid(String id)
            throws Exception;

    public abstract String updatePrizerecord(Wobbleprizerecord prizerecord)
            throws Exception;
}
