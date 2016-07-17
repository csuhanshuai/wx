package com.qixin.app.zjmall.service;

import com.qixin.app.zjmall.model.MallUser;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

/**  
 * 
 */
public interface MallUserService {

	public String save(MallUser malluser) throws Exception;

	public void delete(String id) throws Exception;

	public PageFinder<MallUser> findUser(String uid, Query query)
			throws Exception;

	public MallUser Login(String uid, String pwd) throws Exception;

	public MallUser UpdateUser(MallUser malluser) throws Exception;

	public boolean UpdatePwd(String Uid, String pwd) throws Exception;

	public MallUser findByid(String id) throws Exception;
	
	public MallUser findByusername(String username) throws Exception;
	
	public MallUser findByuserMail(String mail) throws Exception;

}
