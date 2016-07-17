package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Salespromotion;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface SalespromotionService
{
    public abstract PageFinder<Salespromotion> getSalespromotion(Query query,
            String bid) throws Exception;

    public abstract String addSalespromotion(Salespromotion salespromotion)
            throws Exception;

    public abstract Salespromotion getSalespromotionByid(String id)
            throws Exception;

    public abstract String updateSalespromotion(Salespromotion salespromotion)
            throws Exception;

    public abstract List<Salespromotion> getSalespromotion(String bid,
            String type, long usablerange) throws Exception;
}
