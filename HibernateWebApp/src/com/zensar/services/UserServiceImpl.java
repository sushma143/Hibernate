package com.zensar.services;

import java.sql.SQLException;
import java.util.List;

import com.zensar.daos.UserDao;
import com.zensar.entity.User;
import com.zensar.exceptions.ServiceException;
/**
 * @author Sushma
 * @version 2.0
 * @creation_date 21st Sept 2019 5.23PM
 * @modification_date 21st Sept 2019 11:48 AM
 * @copyright Zensar Technologies. All rights reserved.
 * @description Java Bean class used to represent database entity. 
 * 				It is also used as value object. 
 *				
 */

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) throws ServiceException {
		userDao.insert(user);
		
	}

	@Override
	public void updateUser(User user) throws ServiceException {
		userDao.update(user);
		
	}

	@Override
	public void removeUser(User user) throws ServiceException {
		userDao.delete(user);
		
	}

	@Override
	public User findUserByUsername(String username) throws ServiceException {
		User user=userDao.getByUsername(username);
		return user;
		
		
		
	}

	@Override
	public List<User> findAllUsers() throws ServiceException {
		// TODO Auto-generated method stub
		
		
		return userDao.getAll();
	
	}

	@Override
	public boolean validateUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		User dbUser = findUserByUsername(user.getUsername());
		if(dbUser!=null && dbUser.getPassword().equals(user.getPassword()))
			return true;
		else
			return false;
	}
	

}
