package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.IndexModel;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface IWxIndexModelService
{
    public abstract String addIndexModel(IndexModel indexModel)
            throws Exception;

    public abstract IndexModel getIndexModelById(String paramString);


    public abstract List<IndexModel> getAllIndexModel(String bizid);

    public abstract PageFinder<IndexModel> pageQueryIndexModel(String bid,
            Query query);

    public abstract String updateIndexModel(IndexModel paramIndexModel)
            throws Exception;

    public abstract String removeIndexModel(String paramString)
            throws Exception;
    
}