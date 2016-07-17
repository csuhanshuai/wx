package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.PictureText;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface IWxPictureTextService
{
    public abstract String addPictureText(PictureText pictureText)
            throws Exception;

    public abstract PictureText getPictureTextById(String paramString);

    public abstract List<PictureText> getAllPictureText(String bizid,
            String ordername);

    public abstract PageFinder<PictureText> pageQueryPictureText(String bid,
            Query query);

    public abstract String updatePictureText(PictureText paramPictureText)
            throws Exception;

    public abstract String removePictureText(String paramString)
            throws Exception;

    public abstract void removeAllPictureText(String paramBid) throws Exception;

}