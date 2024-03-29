package cn.edu.jlu.ccst.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import cn.edu.jlu.ccst.model.Dcsdata;
import cn.edu.jlu.ccst.model.User;


import cn.edu.jlu.ccst.dao.DcsdataServiceInter;
/**
 * DCS数据数据库操作实现类
 * @author Woden
 *
 */
@Component("dcsServiceImpl")
@Transactional
public class DcsdataServiceImpl implements DcsdataServiceInter {
	/**
	 * 关系映射管理对象
	 */
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
    public List<Dcsdata> findByitem(String equipment, String item) {
		Query query = getEntityManager().createQuery("select u FROM Dcsdata u WHERE u.equipment='"+equipment+"' and u.item = '"+item+"'");
		return query.getResultList();
	}
    public void delete(Dcsdata dcsdata) {
    	em.remove(dcsdata);
		
		
	}
    
    
   
    
    @SuppressWarnings("unchecked")
	public List<Dcsdata> findAll() {
		Query query = getEntityManager().createQuery("select u FROM Dcsdata u");
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
    
    public void save(Dcsdata dcsdata) {
		if (dcsdata.getId()<=0) {
			// new
			em.persist(dcsdata);
			
		} else {
			// update
			em.merge(dcsdata);
		}
	}
	}
	



	

