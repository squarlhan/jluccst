package cn.edu.jlu.ccst.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.jlu.ccst.model.Admin;
import cn.edu.jlu.ccst.model.User;


@Component("adminServiceImpl")
@Transactional
public class AdminServiceImpl {
	private EntityManager em; 

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<Admin> findAll() {
		Query query = getEntityManager().createQuery("select u FROM Admin u");
		return query.getResultList();
	}

	public void save(Admin admin) {
		if (admin.getId() <= 0) {
			// new
			em.persist(admin);
			
		} else {
			// update
			em.merge(admin);
		}
	}
	

	public void remove(int id) {
		Admin person = find(id);
		if (person != null) {
			em.remove(person);
		}
	}
	

	private EntityManager getEntityManager() {
		return em;
	}

	public Admin find(Admin admin) {
		Query query = getEntityManager().createQuery("select u FROM Admin u where u.username =  '"+admin.getUsername()+"' and u.password='"+ admin.getPassword()+"'");
		@SuppressWarnings("unchecked")
		List<Admin> results= query.getResultList();
		
		if(results.size()<1)
			return null;
		else{
			
			return (Admin) results.get(0);//User re=em.find(User.class, user);
		}
		
		
	}
	public Admin find(int id) {
		return em.find(Admin.class, id);
	}

}