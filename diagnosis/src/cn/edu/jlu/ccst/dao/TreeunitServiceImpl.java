package cn.edu.jlu.ccst.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import cn.edu.jlu.ccst.model.Treeunit;



import cn.edu.jlu.ccst.dao.DcsdataServiceInter;

@Component("treeunitServiceImpl")
@Transactional
public class TreeunitServiceImpl implements TreeunitServiceInter  {
	private EntityManager em; 

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
    private EntityManager getEntityManager() {
		return em;
	}
    
   
    
    public List<String> findallchild(String father){
    	Query query = getEntityManager().createQuery("select child FROM Treeunit el WHERE el.father ='"+father+"'");
		return query.getResultList();
    }
    
    
	
	
	}
	



	

