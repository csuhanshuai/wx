package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Gift;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public interface GiftService
{
    public abstract PageFinder<Gift> getGift(Query query, String bid)
            throws Exception;

    public abstract Gift getGiftByid(String id) throws Exception;

    public abstract String updateGift(Gift gift) throws Exception;

    /**
     * 根据bid获取number>0的礼品列表
     * 
     * @Title: getGiftListBybid
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param bid
     * @return
     * @throws Exception 设定文件 List<Gift> 返回类型
     */
    public abstract List<Gift> getGiftListBybid(String bid) throws Exception;

    public abstract String addGift(Gift gift) throws Exception;
}
