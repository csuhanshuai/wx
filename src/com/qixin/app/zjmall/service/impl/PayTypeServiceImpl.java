package com.qixin.app.zjmall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjmall.dao.IPayTypeDao;
import com.qixin.app.zjmall.model.PayType;
import com.qixin.app.zjmall.service.IPayTypeService;
import com.qixin.platform.persistent.database.basedao.CritMap;

@Service
public class PayTypeServiceImpl implements IPayTypeService {

	@Resource
	private IPayTypeDao payTypeDao;
	@Override
	public List<PayType> queryValidPayType() {
		// TODO Auto-generated method stub
		CritMap mp = new CritMap();
		mp.addEqual("isSupport", "1");
		return payTypeDao.findByCritMap(mp, true);
	}

}
