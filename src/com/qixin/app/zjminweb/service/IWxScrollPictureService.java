package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.ScrollPicture;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface IWxScrollPictureService
{
    public abstract String addScrollPicture(ScrollPicture scrollPicture)
            throws Exception;

    public abstract ScrollPicture getScrollPictureById(String paramString);

    public abstract List<ScrollPicture> getAllScrollPicture(String bizid,
            String ordername);

    public abstract PageFinder<ScrollPicture> pageQueryScrollPicture(
            String bid, Query query);

    public abstract String updateScrollPicture(ScrollPicture paramScrollPicture)
            throws Exception;

    public abstract String removeScrollPicture(String paramString)
            throws Exception;

    public abstract void removeByBizid(String bizid) throws Exception;

}