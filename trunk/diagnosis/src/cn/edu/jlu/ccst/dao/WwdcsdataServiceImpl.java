package cn.edu.jlu.ccst.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.jlu.ccst.model.Wwdcsdata;
import cn.edu.jlu.ccst.dao.WwdcsdataServiceInter;

@Component("wwdcsServiceImpl")
@Transactional
public class WwdcsdataServiceImpl implements WwdcsdataServiceInter {
	private EntityManager em; 

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
    private EntityManager getEntityManager() {
		return em;
	}
	
	public void save(Wwdcsdata wwdcsdata) {
		if (wwdcsdata.getId()<= 0) {
			// new
			em.persist(wwdcsdata);
			
		} else {
			// update
			em.merge(wwdcsdata);
		}
	}
	



	

	
}