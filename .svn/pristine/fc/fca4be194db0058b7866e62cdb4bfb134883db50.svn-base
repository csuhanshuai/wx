package com.qixin.app.zjmall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qixin.app.zjmall.common.ShortUUID;
import com.qixin.app.zjmall.dao.IProLabelRelationDao;
import com.qixin.app.zjmall.dao.IProductDao;
import com.qixin.app.zjmall.model.Product;
import com.qixin.app.zjmall.model.ProductLabelRelation;
import com.qixin.app.zjmall.service.IProductService;
import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.platform.persistent.database.basedao.CritMap;
import com.qixin.platform.persistent.database.basedao.PageFinder;
import com.qixin.platform.persistent.database.basedao.Query;

/**  
 * 
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService
{

    @Resource
    private IProductDao productDao;
    
    @Resource
	private IProLabelRelationDao proLabelRelationDao;

    /**
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(String id) throws Exception
    {

        productDao.removeById(id);
        
      //删除产品时，还得要删除该产品关联的标签信息
        CritMap mp = new CritMap();
        mp.addEqual("productId", id);
        List<ProductLabelRelation> plrs = proLabelRelationDao.findByCritMap(mp);
        for(ProductLabelRelation plr : plrs){
        	proLabelRelationDao.remove(plr);
        }
    }

    /**
     * @param memberid
     * @return
     * @throws Exception
     */
    @Override
    public Product findByid(String id) throws Exception
    {

        return productDao.queryProductById(id);
    }

    /**
     * @param query
     * @return
     * @throws Exception
     */
    @Override
    public PageFinder<Product> getAll(Query query) throws Exception
    {

        CritMap mp = new CritMap();
        return productDao.pagedByCritMap(mp, query.getPage(),
                query.getPageSize());

    }

    @Override
    public PageFinder<Product> findByProducttype(String ptype, Query query)
            throws Exception
    {

        CritMap mp = new CritMap();
        if (null == ptype || "".equals(ptype) || "0".equals(ptype)
                || "1".equals(ptype))
        {
            mp.addDesc("lastupdate");
            return productDao.pagedByCritMap(mp, query.getPage(),
                    query.getPageSize());
        }
        mp.addLike("ptype", ptype);
        return productDao.pagedByCritMap(mp, query.getPage(),
                query.getPageSize());
    }

    @Override
    public PageFinder<Product> findProductTitle(String title, Query query)
            throws Exception
    {

        CritMap mp = new CritMap();
        mp.addLike("ptitle", title);
        return productDao.pagedByCritMap(mp, query.getPage(),
                query.getPageSize());

    }

    @Override
    public String save(Product Product) throws Exception
    {

        Product.setId(ShortUUID.generateShortUuid());
        productDao.save(Product);
        return Product.getId();

    }
    public PageFinder<Product> getAllforbid(String uid, Query query)
            throws Exception
            {
                CritMap mp = new CritMap();
                mp.addEqual("uid", uid);
                mp.addDesc("lastupdate");
                
                return productDao.pagedByCritMap(mp, query.getPage(),
                        query.getPageSize());
            }

    @Override
    public PageFinder<Product> getAllbyuid(String uid, Query query,String isshow)
            throws Exception
    {
        CritMap mp = new CritMap();
        mp.addEqual("uid", uid);
        if(!CommonTool.isEmpty(isshow))
        {
            mp.addEqual("isshow", isshow);
        }
        return productDao.pagedByCritMap(mp, query.getPage(),
                query.getPageSize());
    }

    @Override
    public PageFinder<Product> UserfindByProductBytype(String uid,
            String ptype, Query query) throws Exception
    {
        CritMap mp = new CritMap();
        mp.addEqual("uid", uid);
        mp.addDesc("lastupdate");
        if (null == ptype || "".equals(ptype) || "0".equals(ptype)
                || "1".equals(ptype))
        {
            
            return productDao.pagedByCritMap(mp, query.getPage(),
                    query.getPageSize());
        }
        mp.addEqual("ptype", ptype);
        return productDao.pagedByCritMap(mp, query.getPage(),
                query.getPageSize());
    }

    @Override
    public PageFinder<Product> UserfindProductByTitle(String uid, String title,
            Query query) throws Exception
    {
        CritMap mp = new CritMap();
        mp.addEqual("uid", uid);
        mp.addLike("ptitle", title);
        return productDao.pagedByCritMap(mp, query.getPage(),
                query.getPageSize());
    }

    @Override
    public String getname(String id) throws Exception
    {
        // TODO Auto-generated method stub
        return findByid(id).getPtitle();
    }

    @Override
    public String updateProduct(Product product) throws Exception
    {
        Product pt = (Product) this.productDao.merge(product);
        return pt.getId();
    }

}
