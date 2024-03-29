package cn.edu.jlu.ccst.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.jlu.ccst.model.User;
/**
 * 用户数据库操作实现类
 * @author Woden
 *
 */

@Component("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserServiceInter {
	/**
	 * 关系映射管理对象
	 */
	private EntityManager em; 

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		Query query = getEntityManager().createQuery("select u FROM User u");
		return query.getResultList();
	}

	public void save(User user) {
		if (user.getId() <= 0) {
			// new
			em.persist(user);
		
		} else {
			// update
			em.merge(user);
		}
	}
	public void updateUser(User user) {

		em.merge(user);

	}
	
	//public void resetUser(User user){
		
	//}

	public void remove(int id) {
		User person = find(id);
	
		if (person != null) {
			em.remove(person);
		
		}
		
	}

	private EntityManager getEntityManager() {
		return em;
	}
  
	public User finduser(User user) {
		Query query = getEntityManager().createQuery("select u FROM User u where u.username =  '"+user.getUsername()+"'");
		@SuppressWarnings("unchecked")
		List<User> results= query.getResultList();
	
		if(results.size()<1)
			return null;
		else{
			
			
			
			return (User) results.get(0);//User re=em.find(User.class, user);
		}
		
		//return re;
		//return em.find(User.class, user);
		
	}
	
	public User find(User user) {
		Query query = getEntityManager().createQuery("select u FROM User u where u.username =  '"+user.getUsername()+"' and u.password='"+ user.getPassword()+"'and u.isuser=1");
		@SuppressWarnings("unchecked")
		List<User> results= query.getResultList();
	
		if(results.size()<1)
			return null;
		else{
			
			
			
			return (User) results.get(0);
		}
		
		
	}
	
	public User findadmin(User user) {
		Query query = getEntityManager().createQuery("select u FROM User u where u.username =  '"+user.getUsername()+"' and u.password='"+ user.getPassword()+"'and u.isadmin=1");
		@SuppressWarnings("unchecked")
		List<User> results= query.getResultList();
	
		if(results.size()<1)
			return null;
		else{
		
			
			
			return (User) results.get(0);
		}
		
		
	}
	
	public User findprof(User user) {
		Query query = getEntityManager().createQuery("select u FROM User u where u.username =  '"+user.getUsername()+"' and u.password='"+ user.getPassword()+"'and u.isprof=1");
		@SuppressWarnings("unchecked")
		List<User> results= query.getResultList();
		
		if(results.size()<1)
			return null;
		else{
		
			
			
			return (User) results.get(0);
		}
		
		
	}
	public User find(int id) {
		return em.find(User.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> searchUser(User user) {
		String querySentence;
		if (user == null
				|| ("".equals(user.getUsername())
						&& "".equals(user.getPhone())
						&& "".equals(user.getJid())
						&& "".equals(user.getName())
						&& "".equals(user.getEmail())
						&& "".equals(user.getDept()))) {
			querySentence = "FROM User";
		} else {
			querySentence = "FROM User where";
			if (user.getUsername() != null && !"".equals(user.getUsername()))
				querySentence = querySentence + " username like '%"
						+ user.getUsername() + "%' ";
			else {
				querySentence = querySentence + " username like '%' ";
			  if (user.getPhone() != null && !"".equals(user.getPhone()))
				querySentence = querySentence + " and phone like '%"
						+ user.getPhone() + "%' ";
			  if (user.getJid() != null && !"".equals(user.getJid()))
				querySentence = querySentence + " and jid like '%"
						+ user.getJid() + "%' ";
			  if (user.getName() != null
					&& !"".equals(user.getName()))
				querySentence = querySentence + " and name like '%"
						+ user.getName() + "%' ";
			  if (user.getEmail() != null && !"".equals(user.getEmail()))
				querySentence = querySentence + " and email like '%"
						+ user.getEmail() + "%' ";

			if (user.getDept() != null && !"".equals(user.getDept()))
				querySentence = querySentence + " and dept like '%"
						+ user.getDept() + "%' ";
			}}
		Query query = getEntityManager().createQuery(querySentence);
   System.out.println(querySentence);
		
		return  query.getResultList();
	}


}