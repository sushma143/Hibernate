package com.zensar.daos;
/**
 * @author Sushma
 * @version 2.0
 * @creation_date 21st Sept 2019 5.23PM
 * @modification_date 21st Sept 2019 11:21 AM
 * @copyright Zensar Technologies. All rights reserved.
 * @description Java Bean class used to represent database entity. 
 * 				It is also used as value object. 
 *				
 */

import java.util.List;

import com.zensar.entity.User;

public interface UserDao {
	 void insert(User user);
	 void update(User user);
	 void delete(User user);
	User getByUsername(String username);
	 List<User>getAll();

}
