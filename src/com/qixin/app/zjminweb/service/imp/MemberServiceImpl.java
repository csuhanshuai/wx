package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.dao.impl.MemberDaoImpl;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.service.MemberService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

@Service
public class MemberServiceImpl implements MemberService
{
    @Resource
    private MemberDaoImpl memberdao;

    @Override
    public List<Member> getMember(String openid, String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("openid", openid);
        critMap.addEqual("bizid", bid);
        return (List<Member>) this.memberdao.findByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public String addMember(Member member) throws Exception
    {
        return (String) this.memberdao.save(member);
    }

    @Override
    public PageFinder<Member> getMember(Query query) throws Exception
    {
        CritMap critMap = new CritMap();
        // critMap.addEqual("bizid", bid);
        return (PageFinder<Member>) this.memberdao.pagedByCritMap(critMap,
                query.getPage(), query.getPageSize());
    }

    @Override
    public PageFinder<Member> getMemberByCondition(Query query, String type,
            String condition) throws Exception
    {
        CritMap critMap = new CritMap();
        // critMap.addEqual("bizid", bid);

        if ("0".equals(type))
        {
            critMap.addEqual("cardno", condition);
        }

        else if ("1".equals(type))
        {
            critMap.addEqual("telephone", condition);
        }

        return (PageFinder<Member>) this.memberdao.pagedByCritMap(critMap,
                query.getPage(), query.getPageSize());
    }

    @Override
    public Member getMemberByid(String id) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        return (Member) this.memberdao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public Member getMemberByOpenid(String openid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("openid", openid);
        return (Member) this.memberdao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public String updateMember(Member member) throws Exception
    {
        Member pt = (Member) this.memberdao.merge(member);
        return pt.getId();
    }

    @Override
    public Member getMemberByTelephone(String condition) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("telephone", condition);

        return (Member) this.memberdao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public Member getMemberByCardno(String condition) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("cardno", condition);

        return (Member) this.memberdao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public Member getMemberByid(String id, String bid) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("id", id);
        critMap.addEqual("bizid", bid);
        return (Member) this.memberdao.getObjectByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public List<Member> getMemberList(String cardno, String telephone)
            throws Exception
    {
        CritMap critMap = new CritMap();

        if (!CommonTool.isEmpty(cardno))
        {
            critMap.addEqual("cardno", cardno);
        }

        if (!CommonTool.isEmpty(telephone))
        {
            critMap.addEqual("telephone", telephone);
        }

        return (List<Member>) this.memberdao.findByCritMap(critMap,
                new boolean[] { true });
    }

    @Override
    public List<Member> getMemberBytelephone(String telephone) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("telephone", telephone);
        return (List<Member>) this.memberdao.findByCritMap(critMap,
                new boolean[] { true });
    }
}
