package cn.edu.jlu.ccst.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.jlu.ccst.model.Backward;
import cn.edu.jlu.ccst.model.BackwardandResult;


@Component("ruleServiceImpl")
@Transactional
public class RuleServiceImpl implements RuleServiceInter{
	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<Backward> findAll() {
		Query query = getEntityManager().createQuery("select b FROM Backward b");
		return query.getResultList();
	}
	


	public void save(Backward backward) {
		if (backward.getBid() <= 0) {
			// new
			em.persist(backward);
		} else {
			// update
			em.merge(backward);
		}
	}

	public void remove(int bid) {
		Backward backward = find(bid);
		if (backward != null) {
			em.remove(backward);
		}
	}

	private EntityManager getEntityManager() {
		return em;
	}

	public Backward find(int bid) {
		return em.find(Backward.class, bid);
	}

}