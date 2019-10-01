package com.zensar.daos;

/**
 * @author Sushma
 * @version 1.0
 * @creation_date 21st Sept 2019 5.23PM
 * @modification_date 21st Sept 2019 5.23PM
 * @copyright Zensar Technologies. All rights reserved.
 * @description It is data  access object Interface implentation. 
 * 				It is also used in Persistent Layer of Application. 
 *				
 */


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entity.User;

/**
 * @author Sushma Kumari
 * @copyright All rights reserved to Zensar.
 * @Creation_date 21 Sept 2019 5:23PM
 * @version 2.0
 * @modification_date 28 Sept 2019 11:15 AM
 * @Description It is an implementation of user implemented class. 
 *
 */
public class UserDaoImpl implements UserDao {
	
	private Session s;
	
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
		Configuration c=new Configuration().configure();
		SessionFactory f=c.buildSessionFactory();
		s=f.openSession();
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		Transaction t=s.beginTransaction();
		s.save(user);
		t.commit();
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Transaction t=s.beginTransaction();
		s.update(user);
		t.commit();
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		Transaction t=s.beginTransaction();
		s.delete(user);
		t.commit();
		
	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return s.get(User.class, username);
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		Query q=s.createQuery("from User");
		return q.getResultList();
	}

	

}
