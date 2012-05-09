package cn.edu.jlu.ccst.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import cn.edu.jlu.ccst.model.Dcshistory;
import cn.edu.jlu.ccst.model.User;


import cn.edu.jlu.ccst.dao.DcsdataServiceInter;
/**
 *DCS历史数据数据库操作实现类
 * @author Woden
 *
 */
@Component("dcshistoryImpl")
@Transactional
public class DcshistoryImpl implements DcshistoryInter {
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
    
    
    
    public void save(Dcshistory dcshistory) {
		if (dcshistory.getId()<=0) {
			// new
			em.persist(dcshistory);
			
		} else {
			// update
			em.merge(dcshistory);
		}
	}
	}
	



	

