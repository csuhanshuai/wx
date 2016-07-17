package com.qixin.app.zjmall.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qixin.app.zjmall.dao.ILabelDao;
import com.qixin.app.zjmall.dao.IProLabelRelationDao;
import com.qixin.app.zjmall.model.Label;
import com.qixin.app.zjmall.model.ProductLabelRelation;
import com.qixin.app.zjmall.service.ILabelService;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;
@Service
public class LabelServiceImpl implements ILabelService {

	@Resource
	private ILabelDao labelDao;
	
	@Resource
	private IProLabelRelationDao proLabelRelationDao;
	
	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		labelDao.removeById(id);
	}

	@Override
	public PageFinder<Label> findLabel(Query query) throws Exception {
		// TODO Auto-generated method stub
		CritMap mp = new CritMap();

		// mp.addDesc("addtime");

		return labelDao.pagedByCritMap(mp, query.getPage(), query.getPageSize());
	}

	@Override
	public Label queryLabelbyid(String id) throws Exception {
		// TODO Auto-generated method stub
		return labelDao.getById(id);
	}

	@Override
	public void save(Label label) throws Exception {
		// TODO Auto-generated method stub
		labelDao.save(label);
	}

	@Override
	public void update(Label label) throws Exception {
		// TODO Auto-generated method stub
		labelDao.merge(label);
	}

	@Override
	public Label queryLabelByName(String name) throws Exception {
		// TODO Auto-generated method stub
//		CritMap mp = new CritMap();
//		mp.addEqual("name", name);
		return labelDao.findUniqueBy("name", name);
	}

	@Override
	public boolean queryLabelIsUsed(String id) throws Exception {
		// TODO Auto-generated method stub
		List<ProductLabelRelation> plr = proLabelRelationDao.findBy("labelId", id);
		if (plr == null || plr.size() == 0){
			return false;
		}
		return true;
	}

	@Override
	public List<Label> queryAllLabel() throws Exception {
		
		return labelDao.getAll();
	}

	@Override
	public List<Label> queryProductLabelByProductId(String productId)
			throws Exception {
		List<ProductLabelRelation> plrs = proLabelRelationDao.findBy("productId", productId);
		
		if (plrs != null && 0 != plrs.size()){
			String labelId = null;
			String labelName = null;
			Label label = null;
			List<Label> labels = new ArrayList<Label>();
			for(ProductLabelRelation plr : plrs){
				labelId = plr.getLabelId();
				labelName = labelDao.getById(labelId).getName();
				label = new Label();
				label.setId(labelId);
				label.setName(labelName);
				labels.add(label);
			}
			return labels;
		}
		else{
			return null;			
		}
	}

	@Override
	public void saveProductLabel(ProductLabelRelation plr) throws Exception {
		// TODO Auto-generated method stub
		proLabelRelationDao.save(plr);
	}

	@Override
	public PageFinder<ProductLabelRelation> queryProductIdByLabelId(String[] labelIds,
			Query query) {
		CritMap mp = new CritMap();
        if (!CommonTool.isEmpty(labelIds))
        {
            mp.addIN("labelId", labelIds);
        }
        
        return proLabelRelationDao.pagedByCritMap(mp, query.getPage(),
                query.getPageSize());
	}
	
}
