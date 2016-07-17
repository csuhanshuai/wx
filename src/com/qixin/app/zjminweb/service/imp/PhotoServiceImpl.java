package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.PhotoDao;
import com.qixin.app.zjminweb.model.Photo;
import com.qixin.app.zjminweb.service.PhotoService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class PhotoServiceImpl implements PhotoService
{
    @Resource
    private PhotoDao photodao;

    @Override
    public List<Photo> getPhotoByBid(String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (List<Photo>) this.photodao.findByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public PageFinder<Photo> getPhotoByAlmid(Query query, String almid)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("almid", almid);
        return (PageFinder<Photo>) this.photodao.pagedByCritMap(critMap,
                query.getPage(), query.getPageSize());
    }

    @Override
    public String addPhoto(Photo photo) throws Exception
    {
        return (String) this.photodao.save(photo);
    }

    @Override
    public boolean removePhoto(String almid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("almid", almid);
        List<Photo> photolist = (List<Photo>) this.photodao.findByCritMap(
                critMap, new boolean[] { true });

        if (photolist != null && photolist.size() > 0)
        {
            for (Photo photo : photolist)
            {
                if (photo != null)
                {
                    this.photodao.remove(photo);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Photo> getPhotoByAlmid(String almid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("almid", almid);
        return (List<Photo>) this.photodao.findByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public Photo getPhotoByAlmid(String almid, String iscovers)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("almid", almid);
        critMap.addEqual("iscovers", iscovers);
        return (Photo) this.photodao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public String updatePhoto(Photo photo) throws Exception
    {
        Photo pt = (Photo) this.photodao.merge(photo);
        return pt.getId();
    }

    @Override
    public boolean removePhotoByid(String id) throws Exception
    {
        Photo zp = this.photodao.getById(id);
        if (zp != null)
        {
            this.photodao.remove(zp);
            return true;
        }
        return false;
    }

}
