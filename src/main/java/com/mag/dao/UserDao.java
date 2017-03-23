/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.mag.dao;

import java.util.List;

import com.mag.entity.User;

public interface UserDao{
	public List<User> getUserListDao();
	public String deletePerson(String id);
}