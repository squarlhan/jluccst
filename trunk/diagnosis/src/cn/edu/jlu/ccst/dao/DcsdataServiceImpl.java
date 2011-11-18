package cn.edu.jlu.ccst.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import cn.edu.jlu.ccst.model.Dcsdata;
import cn.edu.jlu.ccst.model.User;


import cn.edu.jlu.ccst.dao.DcsdataServiceInter;

@Component("dcsServiceImpl")
@Transactional
public class DcsdataServiceImpl implements DcsdataServiceInter {
	private EntityManager em; 

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
    private EntityManager getEntityManager() {
		return em;
	}
    public List<Dcsdata> findByequipment(String equipment) {
		Query query = getEntityManager().createQuery("select u FROM Dcsdata u WHERE u.equipment='"+equipment+"'");
		return query.getResultList();
	}
    
    @SuppressWarnings("unchecked")
	public List<Dcsdata> findAll() {
		Query query = getEntityManager().createQuery("select u FROM Dcsdata u");
		return query.getResultList();
	}
    
    public void save(Dcsdata dcsdata) {
		if (dcsdata.getId() <= 0) {
			// new
			em.persist(dcsdata);
			
		} else {
			// update
			em.merge(dcsdata);
		}
	}
	}
	



	

