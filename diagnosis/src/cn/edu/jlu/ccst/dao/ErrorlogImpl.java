package cn.edu.jlu.ccst.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import cn.edu.jlu.ccst.model.Errorlog;
import cn.edu.jlu.ccst.model.User;


import cn.edu.jlu.ccst.dao.DcsdataServiceInter;

@Component("errorlogImpl")
@Transactional
public class ErrorlogImpl implements ErrorlogInter  {
	private EntityManager em; 

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
    private EntityManager getEntityManager() {
		return em;
	}
    
    
   
    
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
	



	

