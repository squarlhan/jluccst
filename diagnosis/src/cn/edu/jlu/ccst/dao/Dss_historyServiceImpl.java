package cn.edu.jlu.ccst.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import cn.edu.jlu.ccst.model.Dcshistory;
import cn.edu.jlu.ccst.model.Dss_history;
import cn.edu.jlu.ccst.model.Errorlog;
import cn.edu.jlu.ccst.model.Pre_dss;
import cn.edu.jlu.ccst.model.User;


import cn.edu.jlu.ccst.dao.DcsdataServiceInter;

@Component("dss_historyServiceImpl")
@Transactional
public class Dss_historyServiceImpl implements Dss_historyServiceInter  {
	private EntityManager em; 

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
    private EntityManager getEntityManager() {
		return em;
	}
    
    
    public List<Dss_history> findAll(){
    	Query query = getEntityManager().createQuery("select d FROM Dss_history d");
		return query.getResultList();
    }
    
    
    public List<Dss_history> findbyName(String name){
    	Query query = getEntityManager().createQuery("select d FROM Dss_history d WHERE d.name.name like'"+name+"%'");
	
    	
    	return query.getResultList();
    }
   
    
    public void save(Dss_history dss_history) {
		if (dss_history.getId()<=0) {
			// new
			em.persist(dss_history);
			
		} else {
			// update
			em.merge(dss_history);
		}
	}
    
    
    public List<Dss_history> findsimu_time() {
		Query query = getEntityManager().createQuery("select max(u.simu_time) FROM Dss_history u ");
		return query.getResultList();
	}
	
	
    public List<Dss_history> findbypara(String para){
    	Query query = getEntityManager().createQuery("select el FROM Dss_history el WHERE el.name.name like '%"+para+"%' " );
    
   
		
		return query.getResultList();
  }
}

	

