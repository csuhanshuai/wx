package com.qixin.app.lanterngame.dao.impl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.qixin.app.lanterngame.dao.IQuizTopicDao;
import com.qixin.app.lanterngame.model.QuizTopic;
import com.qixin.platform.persistent.database.basedao.HibernateEntityDao;
@Repository
public class QuizTopicDaoImpl extends HibernateEntityDao<QuizTopic> implements IQuizTopicDao {

	@Override
	public List<QuizTopic> queryTopicTop(String topicId) throws SQLException {
		final String hql = "select qu.id,qu.imgId,qu.title,qu.content,qu.rightTitle,qu.topicScore,qu.imgUrl,qu.maxSubmitTime from QuizTopic qu where qu.id"
		        + " not in (" + topicId
		 		+ ")  order by rand()";
		
		Assert.hasText(hql);
		List list = getHibernateTemplate().executeFind(  
	              new HibernateCallback() {  
	                  public Object doInHibernate(Session arg0)  
	                         throws HibernateException, SQLException {  
	                     Query query = arg0.createQuery(hql);  
	                     query.setFirstResult(0);  
	                     query.setMaxResults(1);  
	                     return query.list();  
	  
	                  }  
	              });  
		
		List<QuizTopic> topicList = new ArrayList<QuizTopic>();
		if (list != null && list.size() > 0) {
			QuizTopic topicScore=null;;
			for (int i = 0; i < list.size(); i++) {
				Object[] object = (Object[]) list.get(i);
				topicScore = new QuizTopic();
				topicScore.setId((String)object[0]);
				topicScore.setImgId((String)object[1]);
				topicScore.setTitle((String)object[2]);
				topicScore.setContent((String)object[3]);
				topicScore.setRightTitle((String)object[4]);
				topicScore.setTopicScore((Integer)object[5]);
				topicScore.setImgUrl((String)object[6]);
				topicScore.setMaxSubmitTime((Integer)object[7]);
				
				topicList.add(topicScore);
			}
		}
		return topicList;
	}

}
