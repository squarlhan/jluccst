package cn.edu.jlu.ccst.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.jlu.ccst.model.Init_Predict;

@Component("init_predictServiceImpl")
@Transactional
public class Init_PredictServiceImpl implements Init_PredictServiceInter {
	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	private EntityManager getEntityManager() {
		return em;
	}

	public void delete(Init_Predict duizhao) {
		em.remove(duizhao);

	}

	@SuppressWarnings("unchecked")
	public List<Init_Predict> findAll() {
		Query query = getEntityManager().createQuery(
				"select u FROM Init_Predict u");
		return query.getResultList();
	}

	public void save(Init_Predict duizhao) {
		em.persist(duizhao);
	}

	@Override
	public List<String> findbyjiedian(String jiedian) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList();
		Query query = getEntityManager().createQuery(
				"select u.name FROM Init_Predict u WHERE u.name like '"+jiedian+"%'");
		result = query.getResultList();
		return result;
	}
}
