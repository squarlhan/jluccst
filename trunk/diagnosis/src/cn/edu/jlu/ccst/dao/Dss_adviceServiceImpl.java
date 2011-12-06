package cn.edu.jlu.ccst.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import cn.edu.jlu.ccst.model.Dss_advice;
import cn.edu.jlu.ccst.model.Dss_history;
import cn.edu.jlu.ccst.model.Pre_dss;
import cn.edu.jlu.ccst.model.User;


import cn.edu.jlu.ccst.dao.DcsdataServiceInter;

@Component("dss_adviceServiceImpl")
@Transactional
public class Dss_adviceServiceImpl implements Dss_adviceServiceInter  {
	private EntityManager em; 

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
    private EntityManager getEntityManager() {
		return em;
	}
    
    
    public List<Dss_advice> findAll(){
    	Query query = getEntityManager().createQuery("select d FROM Dss_advice d");
		return query.getResultList();
    }
    public void deleteall(){
    	getEntityManager().createQuery("delete Dss_advice").executeUpdate();
//    	List<Dss_advice> all = findAll();
//    	Iterator it = all.iterator();
//    	while(it.hasNext()){
//    		Dss_advice da = (Dss_advice) it.next();   		
//    		all.remove(da);
//    		em.remove(da);
//    	}
    }
   
    
    public void save(Dss_advice dss_advice) {
		if (dss_advice.getId()<=0) {
			// new
			em.persist(dss_advice);
			
		} else {
			// update
			em.merge(dss_advice);
		}
	}
    
    
    public List<String> findsimu_time() {
		Query query = getEntityManager().createQuery("select max(u.simu_time) FROM Dss_advice u ");
		return query.getResultList();
	}
	}
	



	

