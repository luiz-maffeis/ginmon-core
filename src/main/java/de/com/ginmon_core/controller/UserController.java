/**
 * 
 */
package de.com.ginmon_core.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.com.ginmon_core.model.User;
import de.com.ginmon_core.transaction.UserDetailTransaction;
import de.com.ginmon_core.transaction.UserListTransaction;

/**
 * @author Luiz
 *
 */
@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name="userListTransaction")
	private UserListTransaction userListTransaction;
	
	@Resource(name="userDetailTransaction")
	private UserDetailTransaction userDetailTransaction;
	
	/**
	 * Return a list of users from https://api.github.com/users
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/userList", method = RequestMethod.GET, produces = "application/json")
	public ArrayList<User> userList(@RequestParam("id") final int id){
		ArrayList<User> userList = userListTransaction.userList(id);
		log.info(userList.toString());
		return userList;
	}
	
	@RequestMapping(value="/userDetail", method = RequestMethod.GET, produces = "application/json")
	public User userDetail(@RequestParam("id") final int id){
		User user = userDetailTransaction.userDetail(id);
		log.info(user.toString());
		return user;
	}

}