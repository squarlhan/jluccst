package cn.edu.jlu.ccst.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import cn.edu.jlu.ccst.model.Dss_advice;
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
    
    
   
    
    public void save(Dss_advice dss_advice) {
		if (dss_advice.getId()<=0) {
			// new
			em.persist(dss_advice);
			
		} else {
			// update
			em.merge(dss_advice);
		}
	}
    
    
    public List<Dss_advice> findseqno() {
		Query query = getEntityManager().createQuery("select max(u.seqno) FROM Dss_advice u ");
		return query.getResultList();
	}
	}
	



	

