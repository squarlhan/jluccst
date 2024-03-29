package cn.edu.jlu.ccst.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import cn.edu.jlu.ccst.model.Pre_dss;
import cn.edu.jlu.ccst.model.User;


import cn.edu.jlu.ccst.dao.Pre_dssServiceInter;
/**
 * 从工艺对接得到的数据数据库相关操作服务类
 * @author Woden
 *
 */
@Component("Pre_dssServiceImpl")
@Transactional
public class Pre_dssServiceImpl implements Pre_dssServiceInter {
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
    public List<Pre_dss> findByname(String name) {
		Query query = getEntityManager().createQuery("select u FROM Pre_dss u WHERE u.name='"+name+"'");
		return query.getResultList();
	}
    
    public void delete(Pre_dss pre_dss) {
    	em.remove(pre_dss);
		
		
	}
    
    
   
    
    @SuppressWarnings("unchecked")
	public List<Pre_dss> findAll() {
		Query query = getEntityManager().createQuery("select u FROM Pre_dss u");
		return query.getResultList();
	}
    
	public List<Pre_dss> findBysimu_time() {
		String hql = "select u FROM Pre_dss u WHERE " +
				"u.simu_time >=all(select u.simu_time from Pre_dss u) " +
				"and u.name in (select c FROM Init_Predict c)" ;
		//getEntityManager().createQuery("delete FROM Pre_dss b WHERE b.name not in (select c FROM Init_Predict c)" ).executeUpdate();
		Query query = getEntityManager().createQuery(hql);
		return query.getResultList();
	}
	
	public List<String> findsimu_time() {
		//getEntityManager().createQuery("delete FROM Pre_dss b WHERE b.name not in (select c FROM Init_Predict c)" ).executeUpdate();
		String hql = "select max(u.simu_time) FROM Pre_dss u" ;
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
    
    public void save(Pre_dss pre_dss) {
		if (pre_dss.getId()<=0) {
			// new
			em.persist(pre_dss);
			
		} else {
			// update
			em.merge(pre_dss);
		}
	}
	}
	



	

