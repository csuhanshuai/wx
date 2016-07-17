package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.MembercardDao;
import com.qixin.app.zjminweb.model.Membercard;
import com.qixin.app.zjminweb.service.MembercardService;
import com.qixin.platform.persistent.database.basedao.CritMap;

@Service
public class MembercardServiceImpl implements MembercardService
{
    @Resource
    private MembercardDao membercarddao;

    @Override
    public List<Membercard> getMembercardByBid(String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (List<Membercard>) this.membercarddao.findByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public String updateMembercard(Membercard membercard) throws Exception
    {
        Membercard pt = (Membercard) this.membercarddao.merge(membercard);
        return pt.getId();
    }
}
