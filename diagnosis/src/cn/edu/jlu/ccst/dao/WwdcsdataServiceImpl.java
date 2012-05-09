package cn.edu.jlu.ccst.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.jlu.ccst.model.User;
import cn.edu.jlu.ccst.model.Wwdcsdata;
import cn.edu.jlu.ccst.dao.WwdcsdataServiceInter;
/**
 * 古老的DCS数据数据库操作实现类
 * @author Woden
 *
 */
@Component("wwdcsServiceImpl")
@Transactional
public class WwdcsdataServiceImpl implements WwdcsdataServiceInter {
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
    
    public Wwdcsdata findbytime(Wwdcsdata wwdcsdata){
    	Query query = getEntityManager().createQuery("select w FROM Wwdcsdata w where w.ORGTIME =  '"+wwdcsdata.getORGTIME()+"'");
    	List<Wwdcsdata> mydata= query.getResultList();
		if(mydata.size()<1)
			return null;
		else{
			return (Wwdcsdata) mydata.get(0);//User re=em.find(User.class, user);
		}
    }
	
	public void save(Wwdcsdata wwdcsdata) {
		Wwdcsdata temp = findbytime(wwdcsdata);
		if(temp==null){
			// new
			em.persist(wwdcsdata);
		}else{	

			// update
			em.merge(wwdcsdata);
			}
	}
	



	

	
}