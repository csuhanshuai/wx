/**
 * 
 */
package com.qixin.app.zjmall.service;

import java.util.List;

import com.qixin.app.zjmall.model.Label;
import com.qixin.app.zjmall.model.ProductLabelRelation;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

/**
 * @author sky
 * 标签业务接口
 */
public interface ILabelService {
   public void save(Label label) throws Exception;
    
    public void delete(String id) throws Exception;
    
    public PageFinder<Label>  findLabel(Query query) throws Exception;
        
    public Label  queryLabelbyid(String id) throws Exception;
    
	public void update(Label label) throws Exception;
	
	public Label queryLabelByName(String name) throws Exception;
	
	/**
	 * 查询标签是否有被用
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean queryLabelIsUsed(String id) throws Exception;
	
	/**
	 * 查询所有标签
	 * @return
	 * @throws Exception
	 */
	public List<Label> queryAllLabel() throws Exception;
	
	/**
	 * 根据产品ID，查询产品的ID
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public List<Label> queryProductLabelByProductId(String productId) throws Exception;
	
	/**
	 * 保存产品的标签到关联表中
	 * @param plr
	 * @throws Exception
	 */
	public void saveProductLabel(ProductLabelRelation plr) throws Exception;
	
	public PageFinder<ProductLabelRelation> queryProductIdByLabelId(String[] labelIds,Query query);
}
