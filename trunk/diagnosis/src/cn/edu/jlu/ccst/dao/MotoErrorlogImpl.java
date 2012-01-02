package cn.edu.jlu.ccst.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import cn.edu.jlu.ccst.model.MotoErrorlog;



import cn.edu.jlu.ccst.dao.DcsdataServiceInter;

@Component("motoerrorlogImpl")
@Transactional
public class MotoErrorlogImpl implements MotoErrorlogInter  {
	private EntityManager em; 

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
    private EntityManager getEntityManager() {
		return em;
	}
    
    public List<MotoErrorlog> findAll(){
    	Query query = getEntityManager().createQuery("select el FROM MotoErrorlog el");
		return query.getResultList();
    }
    
    public List<MotoErrorlog> findbyequipment(String equip){
    	Query query = getEntityManager().createQuery("select el FROM MotoErrorlog el WHERE el.equipment like'"+equip+"%'");
		return query.getResultList();
    }
    
    
	public List<MotoErrorlog> findbypara(String para) {

		String hql = "select el FROM MotoErrorlog el WHERE el.item like ? ";
		String params="%" + para + "%";
		Query query = getEntityManager().createQuery(hql);
		query.setParameter(1, params);
		List result = query.getResultList();
		return result;
	}

    public List<MotoErrorlog> findbytime(String date1,String date2){
    	Query query = getEntityManager().createQuery("select el FROM MotoErrorlog el WHERE  el.time  between '"+date1+"'and'"+date2+"'");
    	return query.getResultList();  }
    public List<MotoErrorlog> findbyorder(String para,String date1,String date2){
    	Query query = getEntityManager().createQuery("select el FROM MotoErrorlog el WHERE el.item like'%"+para+"%'  and  el.time  between '"+date1+"'and'"+date2+"'");
    	return query.getResultList();  }
    
    
    
    
    public void save(MotoErrorlog motoErrorlog) {
		if (motoErrorlog.getId()<=0) {
			// new
			em.persist(motoErrorlog);
			
		} else {
			// update
			em.merge(motoErrorlog);
		}
	}
	}
	



	

