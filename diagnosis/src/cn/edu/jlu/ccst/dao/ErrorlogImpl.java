package cn.edu.jlu.ccst.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import cn.edu.jlu.ccst.model.Errorlog;
import cn.edu.jlu.ccst.model.User;


import cn.edu.jlu.ccst.dao.DcsdataServiceInter;
/**
 *错误日志数据库操作实现类
 * @author Woden
 *
 */
@Component("errorlogImpl")
@Transactional
public class ErrorlogImpl implements ErrorlogInter  {
	/**
	 * 关系映射管理对象
	 */
	private EntityManager em; 

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
    private EntityManager getEntityManager() {
		return em;
	}
    
    public List<Errorlog> findAll(){
    	Query query = getEntityManager().createQuery("select el FROM Errorlog el");
		return query.getResultList();
    }
    
    public List<Errorlog> findbyequipment(String equip){
    	Query query = getEntityManager().createQuery("select el FROM Errorlog el WHERE el.equipment like'"+equip+"%'");
		return query.getResultList();
    }
    
    
	public List<Errorlog> findbypara(String para) {

		String hql = "select el FROM Errorlog el WHERE el.item like ? ";
		String params="%" + para + "%";
		Query query = getEntityManager().createQuery(hql);
		query.setParameter(1, params);
		List result = query.getResultList();
		return result;
	}

    public List<Errorlog> findbytime(String date1,String date2){
    	Query query = getEntityManager().createQuery("select el FROM Errorlog el WHERE  el.time  between '"+date1+"'and'"+date2+"'");
    	return query.getResultList();  }
    public List<Errorlog> findbyorder(String para,String date1,String date2){
    	Query query = getEntityManager().createQuery("select el FROM Errorlog el WHERE el.item like'%"+para+"%'  and  el.time  between '"+date1+"'and'"+date2+"'");
    	return query.getResultList();  }
    
    
    
    
    public void save(Errorlog errorlog) {
		if (errorlog.getId()<=0) {
			// new
			em.persist(errorlog);
			
		} else {
			// update
			em.merge(errorlog);
		}
	}
	}
	



	

