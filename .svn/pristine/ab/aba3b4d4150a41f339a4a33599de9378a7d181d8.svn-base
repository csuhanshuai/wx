package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Signin;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

public abstract interface SigninService
{
    public abstract PageFinder<Signin> getSignin(Query query, String bid)
            throws Exception;

    public abstract String addSignin(Signin signin) throws Exception;

    public abstract Signin getSigninByid(String id) throws Exception;

    public abstract String updateSignin(Signin signin) throws Exception;

    public abstract List<Signin> getSignin(String bid, String status)
            throws Exception;
}
