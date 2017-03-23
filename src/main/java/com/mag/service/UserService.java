/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.mag.service;

import java.util.List;

import com.mag.entity.User;

public interface UserService{
	public List<User> getUserList();
	public String deletePerson(String id);
}