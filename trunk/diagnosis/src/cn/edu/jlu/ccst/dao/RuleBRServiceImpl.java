package cn.edu.jlu.ccst.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.jlu.ccst.model.BackwardandResult;


@Component("rulebrServiceImpl")
@Transactional
public class RuleBRServiceImpl implements RuleBRServiceInter{
	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<BackwardandResult> findAll() {
		Query query = getEntityManager().createQuery("select b FROM BackwardandResult b");
		return query.getResultList();
	}
	
	
	


	public void save(BackwardandResult backwardandresult) {
		if (backwardandresult.getId() <= 0) {
			// new
			em.persist(backwardandresult);
		} else {
			// update
			em.merge(backwardandresult);
		}
	}

	

	private EntityManager getEntityManager() {
		return em;
	}

	public BackwardandResult find(int id) {
		return em.find(BackwardandResult.class,id);
	}

}