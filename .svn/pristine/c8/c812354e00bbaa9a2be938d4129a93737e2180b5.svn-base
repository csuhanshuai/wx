package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Baoming;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface BaomingService
{

    public abstract String addBaoming(Baoming baoming) throws Exception;

    public abstract PageFinder<Baoming> getBaomingList(Query query,
            Baoming baoming);

    public abstract List<Baoming> getBaomingList(Baoming baoming);

    public abstract Baoming getBaomingById(String id);

    public abstract String updateBaoming(Baoming bm);

    public abstract String deleteBaoming(String id) throws Exception;

    public abstract Baoming getBaomingByMobile(String bid, String mobile);
}
