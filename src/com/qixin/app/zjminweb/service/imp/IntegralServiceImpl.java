package com.qixin.app.zjminweb.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.dao.IntegralDao;
import com.qixin.app.zjminweb.model.Integral;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.service.IntegralService;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.persistent.database.basedao.CritMap;

@Service
public class IntegralServiceImpl implements IntegralService
{
    @Resource
    private IntegralDao integraldao;

    @Override
    public List<Integral> getIntegralByBid(String bid, String memberid)
            throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        critMap.addEqual("memberid", memberid);
        return (List<Integral>) this.integraldao.findByCritMapOrderBy(critMap,
                "intime", false, new boolean[] { true });
    }

    @Override
    public List<Integral> getIntegralByBid(String bid, String memberid,
            String type) throws Exception
    {
        CritMap critMap = new CritMap();
        critMap.addEqual("bizid", bid);
        critMap.addEqual("memberid", memberid);

        if (!CommonTool.isEmpty(type))
        {
            critMap.addEqual("type", type);
        }
        return (List<Integral>) this.integraldao.findByCritMapOrderBy(critMap,
                "intime", false, new boolean[] { true });
    }

    @Override
    public String addIntegral(Integral integral) throws Exception
    {
        return (String) this.integraldao.save(integral);
    }

    /**
     * 用户积分记录增加操作
     * 
     * @Title: addMemberIntegral
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param memberservice
     * @param type
     * @param score
     * @param description 设定文件 void 返回类型
     */
    public void addIntegral(Member member, String type, String score,
            String description)
    {
        try
        {
            if (member != null)
            {

                // String integral = member.getIntegral();

                Integral integralObj = new Integral();
                integralObj.setScore(score);
                integralObj.setMemberid(member.getId());
                integralObj.setIntime(CommonTool
                        .getNowDateBySDF("yyyy-MM-dd HH:mm:ss"));
                integralObj.setBizid(member.getBizid());
                integralObj.setType(type);

                integralObj.setDescription(description);
                this.addIntegral(integralObj);

                if (!CommonTool.isEmpty(type) && "0".equals(type))
                {

                    // integral = CommonTool.numberAdd(integral, score);
                    CommonLogger.info("会员：" + member.getName() + "("
                            + member.getId() + ")积分增加：" + score);
                }
                else if (!CommonTool.isEmpty(type) && "1".equals(type))
                {
                    // integral = CommonTool.numberMinus(integral, score);
                    CommonLogger.info("会员：" + member.getName() + "("
                            + member.getId() + ")积分减少：" + score);
                }

                CommonLogger.info("积分记录增加/减少成功！");
            }
            else
            {
                CommonLogger.info("会员对象为空！");
            }
        }
        catch (Exception e)
        {
            CommonLogger.error("integral operate出错 :", e);
        }
    }

    @Override
    public List<Integral> getIntegralByNowDate(String memberid)
            throws Exception
    {
        CritMap critMap = new CritMap();
        // critMap.addEqual("bizid", bid);
        critMap.addEqual("memberid", memberid);
        // 此处务必轻易修改，获取当前时间的类型为：yyyy-MM-dd 00:00:00
        critMap.addGreatAndEq("intime", CommonTool.conversionDate(
                CommonTool.getTodayDate(), "yyyy-MM-dd HH:mm:ss"));
        critMap.addEqual("description", "签到领取");
        return (List<Integral>) this.integraldao.findByCritMap(critMap,
                new boolean[] { true });
    }
}
