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
	
	
	private EntityManager getEntityManager() {
		return em;
	}
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	public List<String> findAllname() {
		Query query = getEntityManager().createQuery("select distinct name FROM DcsDscrib b");
		return query.getResultList();
	}

	public List<DcsDscrib> findbyname(String name) {
		Query query = getEntityManager().createQuery("select b FROM DcsDscrib b where b.name='"+name+"'");
		return query.getResultList();
	}

	public void save(DcsDscrib dcsDscrib){
		if (dcsDscrib.getDid() <= 0) {
			// new
			em.persist(dcsDscrib);
			
		} else {
			// update
			em.merge(dcsDscrib);
		}
	}
	public List<DcsDscrib> findbyitem(int item){
		Query query = getEntityManager().createQuery("select b FROM DcsDscrib b where b.item='ITEM"+item+"'");
		return query.getResultList();
	} 
	

	

	
}