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
	



	

	
}