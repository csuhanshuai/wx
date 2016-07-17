package com.qixin.app.zjmall.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjmall.dao.MallUserDao;
import com.qixin.app.zjmall.model.MallUser;
import com.qixin.app.zjmall.service.MallUserService;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;
import com.qixin.platform.tools.CommonUtil;

/**  
 * 
 */
@Service
public class MallUserServiceImpl implements MallUserService
{

    @Resource
    private MallUserDao malluserdao;

    @Override
    public void delete(String id) throws Exception
    {

    	malluserdao.removeById(id);
	
    }

    @Override
    public MallUser findByid(String id) throws Exception
    {

	// TODO Auto-generated method stub
	return malluserdao.getById(id);
	}

   

    @Override
    public String save(MallUser malluser) throws Exception
    {

    	return (String)malluserdao.save(malluser);
	
    }

	@Override
	public PageFinder<MallUser> findUser(String uid, Query query)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MallUser UpdateUser(MallUser malluser) throws Exception {
		// TODO Auto-generated method stub
		return malluserdao.merge(malluser);
	}

	@Override
	public boolean UpdatePwd(String Uid, String pwd) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MallUser Login(String loginName, String passWord) throws Exception {
		  	CritMap critMap = new CritMap();
		  	if(null!=loginName&&loginName.indexOf("@")>0)
		  	{
		  		critMap.addEqual("mail", loginName);
		  	}
		  	else
		  	{
		  		 critMap.addEqual("uname", loginName);
		  	}
	        String truePassword = CommonUtil.md5(passWord);
	        critMap.addEqual("pwd", truePassword);
	        return malluserdao.getObjectByCritMap(critMap);
	}

	@Override
	public MallUser findByusername(String username) throws Exception {
		// TODO Auto-generated method stub
		CritMap critMap = new CritMap();
		critMap.addEqual("uname", username);
		return malluserdao.getObjectByCritMap(critMap);
	}

	@Override
	public MallUser findByuserMail(String mail) throws Exception {
		// TODO Auto-generated method stub
		CritMap critMap = new CritMap();
		critMap.addEqual("mail", mail);
		return malluserdao.getObjectByCritMap(critMap);
	}

  
    
}
