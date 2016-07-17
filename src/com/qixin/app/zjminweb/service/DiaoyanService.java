package com.qixin.app.zjminweb.service;

import java.util.List;

import com.qixin.app.zjminweb.model.Diaoyan;
import com.qixin.app.zjminweb.model.DiaoyanUser;
import com.qixin.app.zjminweb.model.TitleInfo;
import com.qixin.app.zjminweb.model.TitleItems;

public abstract interface DiaoyanService {
	
	public abstract List<Diaoyan> getDiaoyanListByBid(String bid);
	
	public abstract String addDiaoyan(Diaoyan diaoyan) throws Exception;

	public abstract Diaoyan getDiaoyanById(String id);

	public abstract String updateDiaoyanById(Diaoyan dy);

	public abstract void deleteDiaoyanById(String id) throws Exception;

	public abstract List<TitleInfo> getTitleListById(String id);
	
	public abstract String addDiaoyanTitle(TitleInfo titleInfo) throws Exception;

	public abstract void deleteTitleById(String id) throws Exception;

	public abstract void updateTitleById(TitleInfo ti);

	public abstract TitleInfo getTitleById(String id);

	public abstract void addTitleSelect(List<TitleItems> listItems) throws Exception;

	public abstract List<TitleItems> getTitleItemsById(String titleId);

	public abstract void upateTitleSelect(List<TitleItems> listItems);

	public abstract List<TitleItems> getTitleItemsByIds(String titleIds);

	public abstract void addUserData(DiaoyanUser diaoyanUser) throws Exception;

	public abstract List<TitleInfo> getTitleByDiaoyanId(String id);
	
	public abstract List<TitleItems> getTitleItemsByItemIds(String ids);

	public abstract void updateItemsTimes(TitleItems i); 


}
