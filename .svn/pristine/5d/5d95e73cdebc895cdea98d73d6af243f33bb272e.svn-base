package com.qixin.app.flexWechatMain.service;

import java.util.List;

import com.qixin.app.flexWechatMain.model.WeChatWall;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public interface WeChatWallService
{
    
    /**
     * 增加
     * @return
     */
    public String addWeChatWall(WeChatWall weChatWall)  throws Exception ;
    
    /**
     * 
     * @param id
     * @return
     */
    public WeChatWall getWeChatWall(String id);
    
    /**
     * 
     * @param id
     * @return
     */
    public PageFinder<WeChatWall> getAll(String gamenumber,Query query) throws Exception;
    
    public List<WeChatWall> getAll(String gamenumber) throws Exception;
    
    /**
     * 
     * @param id
     * @return
     */
    public Member getwiner(String gamenumber,Query query) throws Exception;
        
   
}
