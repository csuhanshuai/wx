package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Zhaopin;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface ZhaopinService
{
    public abstract String addZhaopin(Zhaopin paramSecret) throws Exception;

    public abstract PageFinder<Zhaopin> getZhaopinByBid(Query query, String bid)
            throws Exception;

    public abstract List<Zhaopin> getZhaopinByBid(String bid) throws Exception;

    public abstract Zhaopin getZhaopinByid(String id) throws Exception;

    public abstract boolean removeZhaopin(String id) throws Exception;

    public abstract String updateZhaopin(Zhaopin zhaopin) throws Exception;
}
