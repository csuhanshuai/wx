package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.dao.MembernoticeDao;
import com.qixin.app.zjminweb.model.Membernotice;
import com.qixin.app.zjminweb.service.MembernoticeService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class MembernoticeServiceImpl implements MembernoticeService
{
    @Resource
    private MembernoticeDao membernoticedao;

    @Override
    public PageFinder<Membernotice> getMembernoticeByBid(Query query, String bid)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (PageFinder<Membernotice>) this.membernoticedao.pagedByCritMap(
                critMap, query.getPage(), query.getPageSize());
    }

    @Override
    public boolean removeMembernotice(String id) throws Exception
    {
        Membernotice zp = this.membernoticedao.getById(id);
        if (zp != null)
        {
            this.membernoticedao.remove(zp);
            return true;
        }
        return false;
    }

    @Override
    public String addMembernotice(Membernotice membernotice) throws Exception
    {
        return (String) this.membernoticedao.save(membernotice);
    }

    @Override
    public Membernotice getMembernoticeByid(String id) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Membernotice) this.membernoticedao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public List<Membernotice> getMembernoticeByBid(String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        return (List<Membernotice>) this.membernoticedao.findByCritMapOrderBy(
                critMap, "intime", false, new boolean[] { true });
    }
}
