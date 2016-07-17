package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Membernotice;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface MembernoticeService
{
    public abstract PageFinder<Membernotice> getMembernoticeByBid(Query query,
            String bid) throws Exception;

    public abstract boolean removeMembernotice(String id) throws Exception;

    public abstract String addMembernotice(Membernotice membernotice)
            throws Exception;

    public abstract Membernotice getMembernoticeByid(String id)
            throws Exception;

    public abstract List<Membernotice> getMembernoticeByBid(String bid)
            throws Exception;

}
