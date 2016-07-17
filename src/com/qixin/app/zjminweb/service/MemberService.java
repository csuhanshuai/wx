package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Member;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface MemberService
{
    public abstract List<Member> getMember(String openid, String bid)
            throws Exception;

    public abstract String addMember(Member member) throws Exception;

    public abstract PageFinder<Member> getMember(Query query) throws Exception;

    public abstract PageFinder<Member> getMemberByCondition(Query query,
            String type, String condition) throws Exception;

    public abstract Member getMemberByid(String id) throws Exception;

    public abstract Member getMemberByOpenid(String openid) throws Exception;

    public abstract String updateMember(Member member) throws Exception;

    public abstract Member getMemberByTelephone(String condition)
            throws Exception;

    public abstract Member getMemberByCardno(String condition) throws Exception;

    public abstract Member getMemberByid(String id, String bid)
            throws Exception;

    public abstract List<Member> getMemberList(String cardno, String telephone)
            throws Exception;

    public abstract List<Member> getMemberBytelephone(String telephone)
            throws Exception;

}
