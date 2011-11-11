package cn.edu.jlu.ccst.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.jlu.ccst.model.BackwardandUpper;
import cn.edu.jlu.ccst.dao.BackwardUpperInter;

@Component("backwardUpperImpl")
@Transactional
public class BackwardUpperImpl implements BackwardUpperInter {
	private EntityManager em; 

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
    private EntityManager getEntityManager() {
		return em;
	}
	
	public void save(BackwardandUpper backwardandUpper) {
		if (backwardandUpper.getId()<= 0) {
			// new
			em.persist(backwardandUpper);
			
		} else {
			// update
			em.merge(backwardandUpper);
		}
	}
	



	

	
}