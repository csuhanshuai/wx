package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.BaseInfo;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface IWxBaseInfoService
{
    public abstract String addBaseInfo(BaseInfo baseInfo)
            throws Exception;

    public abstract BaseInfo getBaseInfoById(String paramString);


    public abstract List<BaseInfo> getAllBaseInfo(String bizid);

    public abstract PageFinder<BaseInfo> pageQueryBaseInfo(String bid,
            Query query);

    public abstract String updateBaseInfo(BaseInfo paramBaseInfo)
            throws Exception;

    public abstract String removeBaseInfo(String paramString)
            throws Exception;
    
}