package com.qixin.app.zjminweb.common;

import java.util.ArrayList;
import java.util.List;

import com.qixin.app.wobble.model.Wobbleprize;
import com.qixin.app.zjmall.model.Labelselect;
import com.qixin.app.zjminweb.model.Integralrule;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.model.Memberlevel;
import com.qixin.app.zjminweb.model.Salespromotion;

public class ServiceTool
{
    /**
     * 通过指定的消费金额根据积分规则返回得到积分数
     * 
     * @Title: getIntegralOnRuleByMoney
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param bid bid用以查询积分规则
     * @param money 指定的消费金额
     * @return 设定文件 String 返回类型
     */
    public static String getIntegralOnRuleByMoney(Integralrule integralrule,
            String money)
    {

        try
        {

            if (integralrule != null
                    && !CommonTool
                            .isEmpty(integralrule.getIntegralproportion())
                    && !CommonTool.isEmpty(integralrule.getMoneyproportion()))
            {
                int moneyproportion = Integer.parseInt(integralrule
                        .getMoneyproportion());
                int integralproportion = Integer.parseInt(integralrule
                        .getIntegralproportion());

                return String
                        .valueOf((Integer.parseInt(money) / moneyproportion)
                                * integralproportion);

            }
            return "";
        }
        catch (Exception e)
        {
            return "";
        }

    }

    /**
     * 根据指定的会员级别集合和会员对象 ，得到返回对应的会员级别对象
     * 
     * @Title: getMemberlevel
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param Memberlevellist 会员级别集合
     * @param member 指定的会员对象
     * @return 设定文件 Memberlevel 返回类型
     */
    public static Memberlevel getMemberlevel(List<Memberlevel> memberlevellist,
            Member member)
    {
        if (!CommonTool.isEmpty(memberlevellist) && null != member)
        {
            try
            {
                String integral = member.getIntegral();
                int scor = Integer.parseInt(integral);
                for (Memberlevel memberlevel : memberlevellist)
                {
                    int start = Integer
                            .parseInt(memberlevel.getIntegralstart());

                    if ("<".equals(memberlevel.getIntegralend()))
                    {
                        return memberlevel;
                    }
                    else
                    {
                        int end = Integer
                                .parseInt(memberlevel.getIntegralend());

                        if (start <= scor && scor <= end)
                        {
                            return memberlevel;
                        }
                    }

                }
            }
            catch (NumberFormatException e)
            {
                return null;
            }
        }

        return null;
    }

    /**
     * 判断指定的会员是否在给出的会员级别范围内
     * 
     * @Title: isInMemberlevel
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param member
     * @param ml
     * @return 设定文件 boolean 返回类型 true:在 false:不在
     */
    public static boolean isInMemberlevel(Member member, Memberlevel ml)
    {
        if (null == member)
        {
            return false;
        }

        if (null == ml)
        {
            return true;
        }

        try
        {
            String integral = member.getIntegral();
            int scor = Integer.parseInt(integral);

            int start = Integer.parseInt(ml.getIntegralstart());

            if ("<".equals(ml.getIntegralend()))
            {
                if (start <= scor)
                {
                    return true;
                }

                return false;
            }
            else
            {
                int end = Integer.parseInt(ml.getIntegralend());

                if ((start <= scor && scor <= end) || scor > start)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }

        }
        catch (NumberFormatException e)
        {
            return false;
        }

    }

    /**
     * 根据指定的充值金额获取适用哪种充值优惠活动
     * 
     * @Title: getSalespromotion
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param list
     * @param money
     * @return 设定文件 Salespromotion 返回类型
     */
    public static Salespromotion getSalespromotion(List<Salespromotion> list)
    {
        if (!CommonTool.isEmpty(list))
        {

            Salespromotion temp = null;
            for (Salespromotion salespromotion : list)
            {
                if (temp == null)
                {
                    temp = salespromotion;
                }
                else
                {
                    long rangeTemp = temp.getUsablerange();
                    long range = salespromotion.getUsablerange();
                    if (rangeTemp < range)
                    {
                        temp = salespromotion;
                    }

                }

            }
            return temp;

        }
        return null;
    }

    /**
     * 根据指定的奖品list奖品名称为的奖品去除
     * 
     * @Title: getWobbleprize
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param list
     * @return 设定文件 List<Wobbleprize> 返回类型
     */
    public static List<Wobbleprize> getWobbleprize(List<Wobbleprize> list)
    {
        List<Wobbleprize> wobbleprizelist = new ArrayList<Wobbleprize>();
        if (!CommonTool.isEmpty(list))
        {
            for (Wobbleprize wobbleprize : list)
            {
                if (!CommonTool.isEmpty(wobbleprize.getName()))
                {
                    wobbleprizelist.add(wobbleprize);

                }
            }
        }
        return wobbleprizelist;
    }

    /**
     * 根据指定的Label组合字符串得到Labelselect对象集合
     * 
     * @Title: getLabellist
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param labelid Label组合字符串，格式："labelid_isselect,labelid_isselect,..."
     * @return 设定文件 List<Labelselect> 返回类型
     */
    public static List<Labelselect> getLabellist(String labelid)
    {
        List<Labelselect> labelidlist = null;
        if (!CommonTool.isEmpty(labelid))
        {
            String label[] = labelid.split("\\,");
            Labelselect labelselect = null;
            for (String string : label)
            {

                if (label != null)
                {
                    String labels[] = string.split("\\_");
                    if (labels != null && labels.length > 0)
                    {
                        labelselect = new Labelselect();
                        labelselect.setId(labels[0]);
                        if (labels.length > 1)
                        {
                            labelselect.setIsselect(labels[1]);

                        }
                        else
                        {
                            labelselect.setIsselect("1");
                        }
                        labelidlist = ServiceTool.setLabelToList(labelidlist,
                                labelselect);
                    }
                }
            }
        }
        return labelidlist;
    }

    /**
     * 根据指定的Labelselect对象列表获取已经选择的Labelid数组
     * 
     * @Title: getLabelselect
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param labelselectlist
     * @return 设定文件 String[] 返回类型
     */
    public static String[] getLabelselect(List<Labelselect> labelselectlist)
    {
        if (!CommonTool.isEmpty(labelselectlist))
        {
            List<String> list = new ArrayList<String>();
            for (Labelselect labelselect : labelselectlist)
            {
                if (labelselect != null
                        && !CommonTool.isEmpty(labelselect.getIsselect())
                        && "1".equals(labelselect.getIsselect()))
                {
                    list.add(labelselect.getId());
                }
            }
            return list.toArray(new String[] {});
        }
        return null;
    }

    /**
     * 判断指定的Labelselect对象是否存在Labelselect集合中 如果存在，则删除原有对象，存新对象 如果不存在，直接返回即可
     * 
     * @Title: setLabelToList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param labelselectlist
     * @param labelselect
     * @return 设定文件 List<Labelselect> 返回类型
     */
    public static List<Labelselect> setLabelToList(
            List<Labelselect> labelselectlist, Labelselect labelselect)
    {

        if (labelselect != null)
        {
            if (CommonTool.isEmpty(labelselectlist))
            {
                labelselectlist = new ArrayList<Labelselect>();
            }
            else
            {
                if (labelselectlist.contains(labelselect))
                {
                    // labelselectlist.remove(labelselect);
                    return labelselectlist;
                }
            }
            labelselectlist.add(labelselect);
        }
        return labelselectlist;
    }

}
