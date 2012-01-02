package cn.edu.jlu.ccst.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import cn.edu.jlu.ccst.model.MotoDcsdata;



import cn.edu.jlu.ccst.dao.DcsdataServiceInter;

@Component("motodcsServiceImpl")
@Transactional
public class MotoDcsdataServiceImpl implements MotoDcsdataServiceInter {
	private EntityManager em; 

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
    private EntityManager getEntityManager() {
		return em;
	}
    public List<MotoDcsdata> findByequipment(String equipment) {
		Query query = getEntityManager().createQuery("select u FROM MotoDcsdata u WHERE u.equipment='"+equipment+"'");
		return query.getResultList();
	}
    
    public void delete(MotoDcsdata motoDcsdata) {
    	em.remove(motoDcsdata);
		
		
	}
    
    
   
    
    @SuppressWarnings("unchecked")
	public List<MotoDcsdata> findAll() {
		Query query = getEntityManager().createQuery("select u FROM MotoDcsdata u");
		return query.getResultList();
	}
    
   /* public void save(Dcsdata dcsdata) {
    	 List<Dcsdata>	dcs=new ArrayList();
         dcs=findByequipment(dcsdata.getEquipment());
  		if (findByequipment(dcsdata.getEquipment())==null) {
             // new
  			
  			em.persist(dcsdata);
  			
  		} else {
  		
  		  for(Dcsdata dc:dcs){
  	    	 delete(dc);
  	     }
  	     
  			em.merge(dcsdata);
  		}
  	}*/
    
    public void save(MotoDcsdata motoDcsdata) {
		if (motoDcsdata.getId()<=0) {
			// new
			em.persist(motoDcsdata);
			
		} else {
			// update
			em.merge(motoDcsdata);
		}
	}
	}
	



	

