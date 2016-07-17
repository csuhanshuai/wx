package com.qixin.app.zjmall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zjtbl_mall_producttype")
public class ProductType
{
    
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 8)
    private String id;
    
    @Column(name = "typename", length = 32)
    private String typename;
    
    @Column(name = "addtime", length = 30)
    private String addtime;
    
    @Column(name = "bizid", length = 32)
    private String bizid;
    
    @Column(name = "istay", length = 8)
    private String istay;
    
//    private Set<PropItem> items = new HashSet<PropItem>();  
//    @OneToMany(fetch=FetchType.EAGER,mappedBy ="pt") //这里配置关系，并且确定关系维护端和被维护端。mappBy表示关系被维护端，只有关系端有权去更新外键。这里还有注意OneToMany默认的加载方式是赖加载。当看到设置关系中最后一个单词是Many，那么该加载默认为懒加载   
//    public Set<PropItem> getItems() {   
//        return items;    
//    }   
//  
//    public void setItems(Set<PropItem> items) {   
//        this.items = items;   
//    }
    
    public String getIstay() {
		return istay;
	}

	public void setIstay(String istay) {
		this.istay = istay;
	}

	public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getTypename()
    {
        return typename;
    }
    
    public void setTypename(String typename)
    {
        this.typename = typename;
    }
    
    public String getAddtime()
    {
        return addtime;
    }
    
    public void setAddtime(String addtime)
    {
        this.addtime = addtime;
    }
    
    public String getBizid()
    {
        return bizid;
    }
    
    public void setBizid(String bizid)
    {
        this.bizid = bizid;
    }
    
}
