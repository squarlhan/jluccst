package cn.edu.jlu.ccst.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import cn.edu.jlu.ccst.model.Pre_history;
import cn.edu.jlu.ccst.model.User;


import cn.edu.jlu.ccst.dao.Pre_historyServiceInter;
/**
 * 工艺对接数据错误日志数据库操作服务类
 * @author Woden
 *
 */
@Component("pre_historyServiceImpl")
@Transactional
public class Pre_historyServiceImpl implements Pre_historyServiceInter {
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
    public List<Pre_history> findByname(String name) {
		Query query = getEntityManager().createQuery("select u FROM Pre_history u WHERE u.name='"+name+"'");
		return query.getResultList();
	}
    
    public void delete(Pre_history Pre_history) {
    	em.remove(Pre_history);
		
		
	}
    
    
   
    
    @SuppressWarnings("unchecked")
	public List<Pre_history> findAll() {
		Query query = getEntityManager().createQuery("select u FROM Pre_history u");
		return query.getResultList();
	}
    
	public List<Pre_history> findBysimu_time() {
		String hql = "select u FROM Pre_history u WHERE " +
				"u.simu_time >=all(select u.simu_time from Pre_history u) " +
				"and u.name in (select c FROM Init_Predict c)" ;
		//getEntityManager().createQuery("delete FROM Pre_history b WHERE b.name not in (select c FROM Init_Predict c)" ).executeUpdate();
		Query query = getEntityManager().createQuery(hql);
		return query.getResultList();
	}
	
	public List<String> findsimu_time() {
		//getEntityManager().createQuery("delete FROM Pre_history b WHERE b.name not in (select c FROM Init_Predict c)" ).executeUpdate();
		String hql = "select u.simu_time FROM Pre_history u" ;
//		hql = hql +" WHERE u.name in (select c FROM Init_Predict c)" ;
		Query query = getEntityManager().createQuery(hql);
		return query.getResultList();
	}
   /* public void save(Dcsdata dcsdata) {
    	 List<Dcsdata>	dcs=new ArrayList();
         dcs=findByequipment(dcsdata.getEquipment());
  		if (findByequipment(dcsdata.getEquipment())==null) {
             // new
  			
  			em.persist(dcsdata);
  			
  		} else {
  			
  		  for(Dcsdata dc:dcs){
  	    	 delete(dc);
  	     }
  	     
  			em.merge(dcsdata);
  		}
  	}*/
    
    public void save(Pre_history Pre_history) {
		if (Pre_history.getId()<=0) {
			// new
			em.persist(Pre_history);
			
		} else {
			// update
			em.merge(Pre_history);
		}
	}
	}
	



	

