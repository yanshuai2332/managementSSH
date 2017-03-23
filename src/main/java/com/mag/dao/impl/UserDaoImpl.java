/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.mag.dao.impl;
import java.util.List;

import javax.annotation.Resource;
import org.hibernate.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.mag.dao.UserDao;
import com.mag.entity.User;
import com.mag.util.HibernateUtils;
@Repository
public class UserDaoImpl implements UserDao{
	
	@Resource(name="sessionFactory")
	 private SessionFactory sessionFactory;
	public List<User> getUserListDao(){
		 
	    Criteria crit = this.getSession().createCriteria(User.class);  
	    crit.setFirstResult(0);  
	    crit.setMaxResults(10);  
	    List<User> list = crit.list();  
	   
		return list;
	}
	@Override
	public String deletePerson(String id) {
		// TODO Auto-generated method stub
		
		Transaction tx=null;
		 Session session = null;  
	        try {  
	            session = this.getSession(); 
	            tx=session.beginTransaction();
	            User u = (User) session.get(User.class, id);
	            session.delete(u);  
	            tx.commit();
	            System.out.println("success");
	            return "success";
	        }catch(Exception e) {  
	            e.printStackTrace();  
	            tx.rollback(); 
	            System.out.println("false");
	        }finally {  
	            if(tx!=null)
	            	tx=null;
	        }  
	        System.out.println("over");
	        return "false";
	}
	public Session getSession() {
		return sessionFactory.openSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
} 