/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.mag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mag.service.UserService;


@Controller  
@RequestMapping(value="/user")  
public class UserController{
	@Autowired     
	UserService userService;
	
    @RequestMapping(value="/list",method=RequestMethod.GET) 
    public String getUserList(Model model) {
    	model.addAttribute("user", userService.getUserList());
    	return "table";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deletePerson(Model model,String id) {
    	userService.deletePerson(id);
    	model.addAttribute("user", userService.getUserList());
		return "table";
	}
}