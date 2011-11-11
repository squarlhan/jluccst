package cn.edu.jlu.ccst.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.jlu.ccst.model.BackwardandLower;
import cn.edu.jlu.ccst.dao.BackwardLowerInter;

@Component("backwardLowerImpl")
@Transactional
public class BackwardLowerImpl implements BackwardLowerInter {
	private EntityManager em; 

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
    private EntityManager getEntityManager() {
		return em;
	}
	
	public void save(BackwardandLower backwardandLower) {
		if (backwardandLower.getId()<= 0) {
			// new
			em.persist(backwardandLower);
			
		} else {
			// update
			em.merge(backwardandLower);
		}
	}
	



	

	
}