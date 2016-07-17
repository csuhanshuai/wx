package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Album;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface AlbumService
{
    public abstract PageFinder<Album> getAlbumByBid(Query query, String bid)
            throws Exception;

    public abstract String addAlbum(Album album) throws Exception;

    public abstract boolean removeAlbum(String id) throws Exception;

    public abstract Album getAlbumByid(String id) throws Exception;

    public abstract List<Album> getAlbumByBid(String bid) throws Exception;
    
}
