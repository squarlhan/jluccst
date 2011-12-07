package cn.edu.jlu.ccst.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.jlu.ccst.model.Backward;
import cn.edu.jlu.ccst.model.BackwardandLower;
import cn.edu.jlu.ccst.model.BackwardandReason;
import cn.edu.jlu.ccst.model.BackwardandResult;
import cn.edu.jlu.ccst.model.DcsDscrib;
import cn.edu.jlu.ccst.model.User;
import cn.edu.jlu.ccst.dao.BackwardLowerInter;

@Component("backwardReasonImpl")
@Transactional
public class BackwardReasonImpl implements BackwardReasonInter {
	private EntityManager em; 

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
    private EntityManager getEntityManager() {
		return em;
	}
	
    @SuppressWarnings("unchecked")
	public List<BackwardandReason> find(Backward bw){
    	Query query = getEntityManager().createQuery("select b FROM BackwardandReason b where b.bid = '"+bw.getBid()+"'");
    	List<BackwardandReason> results = query.getResultList();
		return results;
    }
	
    public void save(BackwardandReason backwardandReason) {
    	
    	
		if (backwardandReason.getId() <= 0) {
			// new
			em.persist(backwardandReason);
		} else {
			// update
			em.merge(backwardandReason);
		}
	}
   
    public BackwardandReason find(int id) {
		return em.find(BackwardandReason.class, id);
	}
	
	public void remove(int id) {
		BackwardandReason dd = find(id);
		if (dd != null) {
			em.remove(dd);
		
		}
		}
		
	}

	

	
