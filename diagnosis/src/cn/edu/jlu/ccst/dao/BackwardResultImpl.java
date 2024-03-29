package cn.edu.jlu.ccst.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.jlu.ccst.model.BackwardandResult;
import cn.edu.jlu.ccst.model.User;
/**
 * 规则与结果关联表数据库操作实现类
 * @author Woden
 *
 */
@Component("backwardResultImpl")
@Transactional
public class BackwardResultImpl implements BackwardResultInter {
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
	
    public List<BackwardandResult> find(BackwardandResult br){
    	Query query = getEntityManager().createQuery("select b FROM BackwardandResult b where b.nouns = '"+br.getNouns()+"' and b.verb = '"+br.getVerb()+"'");
		return query.getResultList();
    }
	
	@SuppressWarnings("unchecked")
	public List<BackwardandResult> findAll() {
		Query query = getEntityManager().createQuery("select u FROM User u");
		return query.getResultList();
	}

	

	

	
}