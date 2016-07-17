package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.MemberlevelDao;
import com.qixin.app.zjminweb.model.Memberlevel;
import com.qixin.app.zjminweb.service.MemberlevelService;
import com.qixin.platform.persistent.database.basedao.CritMap;

@Service
public class MemberlevelServiceImpl implements MemberlevelService
{
    @Resource
    private MemberlevelDao memberleveldao;

    @Override
    public List<Memberlevel> getMemberlevelByBid(String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (List<Memberlevel>) this.memberleveldao.findByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public String updateMemberlevel(Memberlevel memberlevel) throws Exception
    {
        Memberlevel pt = (Memberlevel) this.memberleveldao.merge(memberlevel);
        return pt.getId();
    }

    @Override
    public Memberlevel getMemberlevelByBid(String bid, String id)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        critMap.addEqual("id", id);
        return (Memberlevel) this.memberleveldao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public Memberlevel getMemberlevelByid(String id) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Memberlevel) this.memberleveldao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

}
