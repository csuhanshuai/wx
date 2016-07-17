package com.qixin.app.zjminweb.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class CommonTool
{
    /**
     * 获取当前日期，按照指定的格式返回字符串格式 格式参考："yyyy-MM-dd" "yyyy-MM-dd hh:mm:ss"
     * 
     * @Title: getNowDate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return 设定文件 String 返回类型
     */
    public static String getNowDate(String reg)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(reg);
        return sdf.format(new Date());
    }
    
    /**
     * 获取当前日期，按照指定的格式返回字符串格式 格式参考："yyyy-MM-dd" "yyyy-MM-dd hh:mm:ss"
     * 
     * @Title: getNowDate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return 设定文件 String 返回类型
     */
    public static String getTodayDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date()) + " 00:00:00";
    }

    /**
     * 判断字符串是否为空
     * 
     * @Title: isEmpty
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param input
     * @return 设定文件 boolean 返回类型
     */
    public static boolean isEmpty(String input)
    {
        if (input == null || "".equals(input) || "".equals(input.trim())
                || input.length() < 1)
        {
            return true;
        }
        return false;
    }

    /**
     * 判断list集合是否为空
     * 
     * @Title: isEmpty
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param list
     * @return 设定文件 boolean 返回类型
     */
    public static boolean isEmpty(List<?> list)
    {
        if (list == null || list.isEmpty() || list.size() < 1)
        {
            return true;
        }
        return false;
    }

    /**
     * 判断数组对象是否为空
     * 
     * @Title: isEmpty
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param obecjts
     * @return 设定文件 boolean 返回类型
     */
    public static boolean isEmpty(Object[] obecjts)
    {
        if (obecjts == null || obecjts.length < 1)
        {
            return true;
        }
        return false;
    }

    /**
     * 数字加操作
     * 
     * @Title: numberAdd
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param addendStr 加数
     * @param augendStr 被加数
     * @return 设定文件 String 返回类型
     */
    public static String numberAdd(String addendStr, String augendStr)
    {
        int addend = Integer.valueOf(addendStr).intValue();
        int augend = Integer.valueOf(augendStr).intValue();

        return String.valueOf(addend + augend);
    }

    /**
     * 数字减操作
     * 
     * @Title: numberMinus
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param subtrahendStr 减数
     * @param minuendStr 被减数
     * @return 设定文件 String 返回类型
     */
    public static String numberMinus(String subtrahendStr, String minuendStr)
    {
        int subtrahend = Integer.valueOf(subtrahendStr);
        int minuend = Integer.valueOf(minuendStr).intValue();

        return String.valueOf(subtrahend - minuend);
    }

    public static String numberMinusFloat(String subtrahendStr,
            String minuendStr)
    {
        float subtrahend = Float.parseFloat(subtrahendStr);
        int minuend = Integer.valueOf(minuendStr).intValue();

        return String.valueOf((subtrahend - minuend) < 0 ? 0
                : (subtrahend - minuend));
    }

    /**
     * 浮点数字加操作
     * 
     * @Title: numberAdd
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param addendStr 加数
     * @param augendStr 被加数
     * @return 设定文件 String 返回类型
     */
    public static String flaotAdd(String addendStr, String augendStr)
    {
        float addend = Float.valueOf(addendStr).floatValue();
        float augend = Float.valueOf(augendStr).floatValue();

        return String.valueOf(addend + augend);
    }

    /**
     * 浮点减操作
     * 
     * @Title: numberMinus
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param subtrahendStr 减数
     * @param minuendStr 被减数
     * @return 设定文件 String 返回类型
     */
    public static String floatMinus(String subtrahendStr, String minuendStr)
    {
        float subtrahend = Float.valueOf(subtrahendStr).floatValue();
        float minuend = Float.valueOf(minuendStr).floatValue();

        return String.valueOf(subtrahend - minuend);
    }

    /**
     * 根据起始会员卡号生成下一个会员卡号
     * 
     * @Title: getMembercardno
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param cardnoinit
     * @return 设定文件 String 返回类型
     */
    public static String getMembercardno(String cardnoinit)
    {
        if (isEmpty(cardnoinit))
        {
            return null;
        }
        try
        {
            long cardno = Long.valueOf(cardnoinit).longValue();

            cardno = cardno + 1;
            return String.valueOf(cardno);
        }
        catch (NumberFormatException e)
        {
            return null;

        }
    }

    /**
     * 判断第二个数字字符串是否比第一个数字字符串大
     * 
     * @Title: compare
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param one
     * @param two
     * @return 设定文件 boolean 返回类型
     */
    public static boolean compareNum(String one, String two)
    {
        if (isEmpty(one) || isEmpty(two))
        {
            return false;
        }

        try
        {
            float o = Float.valueOf(one).floatValue();
            float t = Float.valueOf(two).floatValue();

            if (t > o)
            {
                return true;
            }
        }
        catch (NumberFormatException e)
        {
            return false;

        }
        return false;
    }

    /**
     * 判断第二个时间字符串是否比第一个时间字符串大
     * 
     * @Title: compareDate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param one
     * @param two
     * @param reg
     * @return 设定文件 boolean 返回类型
     */
    public static boolean compareDate(String one, String two, String reg)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        try
        {
            Date o = sdf.parse(one);
            Date t = sdf.parse(two);

            boolean flag = o.before(t);
            if (flag)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (ParseException e)
        {
            return false;
        }
    }

    /**
     * 判断指定的时间字符串是否比当前时间大
     * 
     * @Title: compareDate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param one
     * @param two
     * @param reg
     * @return 设定文件 boolean 返回类型
     */
    public static boolean compareDate(String one, String reg)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        try
        {
            Date now = new Date();
            Date o = sdf.parse(sdf.format(now));
            Date t = sdf.parse(one);

            if (o.before(t))
            {
                return true;
            }
            else if (o.equals(t))
            {
                return true;
            }
            {
                return false;
            }
        }
        catch (ParseException e)
        {
            return false;
        }
    }

    /**
     * 判断指定的时间是否比当前时间大
     * 
     * @Title: compareDate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param one
     * @param two
     * @param reg
     * @return 设定文件 boolean 返回类型
     */
    public static boolean compareDate(Date one, String reg)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        try
        {
            Date now = new Date();
            Date o = sdf.parse(sdf.format(now));
            Date t = one;

            if (o.before(t))
            {
                return true;
            }
            else if (o.equals(t))
            {
                return true;
            }
            {
                return false;
            }
        }
        catch (ParseException e)
        {
            return false;
        }
    }

    /**
     * 判断指定的时间是否比当前时间大
     * 
     * @Title: compareDate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param one
     * @param two
     * @param reg
     * @return 设定文件 boolean 返回类型
     */
    public static boolean compareDate(Date one)
    {
        Date o = new Date();
        Date t = one;

        if (o.before(t))
        {
            return true;
        }
        else if (o.equals(t))
        {
            return true;
        }
        {
            return false;
        }
    }

    /**
     * 将时间字符串转换为日期类型
     * 
     * @Title: zhuanhuan
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param date
     * @param reg
     * @return 设定文件 Date 返回类型
     */
    public static Date conversionDate(String date, String reg)
    {
        if (isEmpty(date) || isEmpty(reg))
        {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(reg, Locale.CHINA);
        try
        {
            return sdf.parse(date);
        }
        catch (ParseException e)
        {
            return null;
        }
    }

    /**
     * 将时间字符串转换为日期类型
     * 
     * @Title: zhuanhuan
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param date
     * @param reg
     * @return 设定文件 Date 返回类型
     */
    public static String conversionDate(Date date, String reg)
    {
        if (null == date || isEmpty(reg))
        {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(reg, Locale.CHINA);
        try
        {
            return sdf.format(date);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * 根据指定的时候获取指定时间的昨天字符串
     * 
     * @Title: getTomorrowDate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param date
     * @param reg
     * @return 设定文件 String 返回类型
     */
    public static Date getTomorrowDate(Date date, String reg)
    {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
        date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat(reg);
        try
        {
            return formatter.parse(formatter.format(date));
        }
        catch (ParseException e)
        {
            return null;
        }
    }

    /**
     * 获取当前日期的yyyy-MM-dd格式
     * 
     * @Title: conversionDate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return 设定文件 Date 返回类型
     */
    public static Date getNowDateBySDF(String reg)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(reg);
        try
        {
            return formatter.parse(formatter.format(new Date()));
        }
        catch (ParseException e)
        {
            return null;
        }
    }

    /**
     * 根据指定的时间字符串和格式化正则得到2个时间差（大前小后）
     * 
     * @Title: getTimeDifference
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param one 较大的时间字符串
     * @param two 较小的时间字符串
     * @param reg
     * @return 设定文件 String[] 返回类型
     */
    public static String[] getTimeDifference(String one, String two, String reg)
    {
        String[] timediff = new String[4];
        try
        {
            SimpleDateFormat df = new SimpleDateFormat(reg);
            java.util.Date now = df.parse(one);
            java.util.Date date = df.parse(two);
            long l = now.getTime() - date.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            timediff[0] = String.valueOf(day);
            timediff[1] = String.valueOf(hour);
            timediff[2] = String.valueOf(min);
            timediff[3] = String.valueOf(s);
        }
        catch (ParseException e)
        {
        }
        return timediff;
    }

    /**
     * 根据指定的时间字符串和格式化正则得到与当前时间的时间差（大前小后）
     * 
     * @Title: getTimeDifference
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param one 较大的时间字符串
     * @param two 较小的时间字符串
     * @param reg
     * @return 设定文件 String[] 返回类型
     */
    public static String[] getTimeDifference(String one, String reg)
    {
        String[] timediff = new String[4];
        try
        {
            SimpleDateFormat df = new SimpleDateFormat(reg);
            java.util.Date now = df.parse(one);
            java.util.Date date = new Date();
            long l = now.getTime() - date.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            timediff[0] = String.valueOf(day);
            timediff[1] = String.valueOf(hour);
            timediff[2] = String.valueOf(min);
            timediff[3] = String.valueOf(s);
        }
        catch (ParseException e)
        {
        }
        return timediff;
    }

    /**
     * 根据指定的时间字符串和格式化正则得到与当前时间的时间差（大前小后）
     * 
     * @Title: getTimeDifference
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param one 较大的时间字符串
     * @param two 较小的时间字符串
     * @param reg
     * @return 设定文件 String[] 返回类型
     */
    public static String[] getTimeDifference(Date one)
    {
        String[] timediff = new String[4];
        java.util.Date now = one;
        java.util.Date date = new Date();
        long l = now.getTime() - date.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        timediff[0] = String.valueOf(day);
        timediff[1] = String.valueOf(hour);
        timediff[2] = String.valueOf(min);
        timediff[3] = String.valueOf(s);
        return timediff;
    }

}
