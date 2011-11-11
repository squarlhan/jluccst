package cn.edu.jlu.ccst.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.jlu.ccst.model.DcsDscrib;


@Component("dcsDscribServiceImpl")
@Transactional
public class DcsDscribServiceImpl implements DcsDscribServiceInter{
	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	
	
	public List<String> findAllname() {
		Query query = getEntityManager().createQuery("select distinct name FROM DcsDscrib b");
		return query.getResultList();
	}

	



	

	private EntityManager getEntityManager() {
		return em;
	}

	
}