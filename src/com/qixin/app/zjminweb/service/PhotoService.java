package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Photo;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface PhotoService
{
    public abstract List<Photo> getPhotoByBid(String bid) throws Exception;

    public abstract PageFinder<Photo> getPhotoByAlmid(Query query, String almid)
            throws Exception;

    public abstract String addPhoto(Photo photo) throws Exception;

    public abstract boolean removePhoto(String almid) throws Exception;

    public abstract List<Photo> getPhotoByAlmid(String almid) throws Exception;

    public abstract Photo getPhotoByAlmid(String almid, String iscovers)
            throws Exception;

    public abstract String updatePhoto(Photo photo) throws Exception;

    public abstract boolean removePhotoByid(String id) throws Exception;

}
