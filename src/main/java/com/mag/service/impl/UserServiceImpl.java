/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.mag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mag.dao.UserDao;
import com.mag.entity.User;
import com.mag.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;
	public List<User> getUserList(){
		return userDao.getUserListDao();
	}
	public String deletePerson(String id){
		return userDao.deletePerson(id);
	}
}