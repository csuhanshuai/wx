package com.qixin.app.zjminweb.service;

import java.util.Date;
import java.util.List;

import com.qixin.app.zjminweb.model.Signinrecord;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface SigninrecordService
{
    public abstract PageFinder<Signinrecord> getSigninrecord(Query query,
            String signinid, Date starttime, Date endtime) throws Exception;

    public abstract String addSigninrecord(Signinrecord signinrecord)
            throws Exception;

    public abstract Signinrecord getSigninrecordByid(String id)
            throws Exception;

    public abstract String updateSigninrecord(Signinrecord signinrecord)
            throws Exception;

    public abstract List<Signinrecord> getSigninrecordBysigninid(
            String signinid, Date startdate, Date enddate) throws Exception;
}
