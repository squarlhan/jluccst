package cn.edu.jlu.ccst.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.jlu.ccst.model.Init_Predict;
/**
 * 设备名和设备id关联表数据库操作实现类
 * @author Woden
 *
 */
@Component("init_predictServiceImpl")
@Transactional
public class Init_PredictServiceImpl implements Init_PredictServiceInter {
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

	public void delete(Init_Predict duizhao) {
		em.remove(duizhao);

	}

	@SuppressWarnings("unchecked")
	public List<Init_Predict> findAll() {
		Query query = getEntityManager().createQuery(
				"select u FROM Init_Predict u");
		return query.getResultList();
	}

	public void save(Init_Predict duizhao) {
		em.persist(duizhao);
	}

	@Override
	public List<String> findbyjiedian(String jiedian) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList();
		Query query = getEntityManager().createQuery(
				"select u.name FROM Init_Predict u WHERE u.name like '"+jiedian+"%'");
		result = query.getResultList();
		return result;
	}

	@Override
	public Init_Predict findbyid(String id) {
		// TODO Auto-generated method stub
		Query query = getEntityManager().createQuery(
				"select u FROM Init_Predict u WHERE u.id = '"+id+"'");
		if(query.getResultList().size()==0){
			return null;
		}else{
			return (Init_Predict)query.getSingleResult();
		}
	}
}
