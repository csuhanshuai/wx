package com.qixin.app.zjmall.service;

import java.util.List;

import com.qixin.app.zjmall.model.Skin;

/**  
 * 
 */
public interface SkinService {

	public void save(Skin skin ) throws Exception;
	
	public void update(Skin skin) throws Exception;

	public void delete(int skinid) throws Exception;

	public List<Skin> getSkin(int skinid) throws Exception;

}
