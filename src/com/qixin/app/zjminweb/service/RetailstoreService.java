package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Retailstore;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface RetailstoreService
{
    public abstract PageFinder<Retailstore> getRetailstoreByBid(Query query,
            String bid) throws Exception;

    public abstract Retailstore getRetailstoreByid(String id) throws Exception;

    public abstract String addRetailstore(Retailstore retailstore)
            throws Exception;

    public abstract boolean removeRetailstore(String id) throws Exception;

    public abstract String updateRetailstore(Retailstore retailstore)
            throws Exception;

    public abstract List<Retailstore> getRetailstoreByBid(String bid)
            throws Exception;
}
