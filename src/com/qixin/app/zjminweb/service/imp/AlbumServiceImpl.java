package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.AlbumDao;
import com.qixin.app.zjminweb.model.Album;
import com.qixin.app.zjminweb.service.AlbumService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class AlbumServiceImpl implements AlbumService
{
    @Resource
    private AlbumDao albumdao;

    @Override
    public PageFinder<Album> getAlbumByBid(Query query, String bid)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (PageFinder<Album>) this.albumdao.pagedByCritMap(critMap,
                query.getPage(), query.getPageSize());
    }

    @Override
    public String addAlbum(Album album) throws Exception
    {
        return (String) this.albumdao.save(album);
    }

    @Override
    public boolean removeAlbum(String id) throws Exception
    {
        Album alm = this.albumdao.getById(id);
        if (alm != null)
        {
            this.albumdao.remove(alm);
            return true;
        }
        return false;
    }

    @Override
    public Album getAlbumByid(String id) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Album) this.albumdao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public List<Album> getAlbumByBid(String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (List<Album>) this.albumdao.findByCritMap(critMap,
                new boolean[] { true });
    }
}
