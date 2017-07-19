/**
 * 
 */
package de.com.ginmon_core.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.com.ginmon_core.model.User;
import de.com.ginmon_core.model.UserComment;
import de.com.ginmon_core.repository.UserRepository;
import de.com.ginmon_core.service.UserDetailService;
import de.com.ginmon_core.service.UserListService;

/**
 * @author Luiz
 *
 */
@RestController
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name="userListService")
	private UserListService userListService;
	
	@Resource(name="userDetailService")
	private UserDetailService userDetailService;
	
	@Resource
	private UserRepository userRepository;
	
	/**
	 * Return a list of users from https://api.github.com/users
	 * @param id
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value="/userList/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<User> userList(@PathParam("id") Integer id){
		ArrayList<User> userList = userListService.userList(id);
		log.info(userList.toString());
		return userList;
	}
	
	@CrossOrigin
	@RequestMapping(value="/userDetail/{login}", method = RequestMethod.GET, produces = "application/json")
	public User userDetail(@PathVariable("login") String login){

		User user = userDetailService.userDetail(login);
		log.info(user.toString());
		return user;
	}
	
	@CrossOrigin
	@RequestMapping(value="/saveUser", method = RequestMethod.POST, consumes="application/json")
	@ResponseStatus(value=HttpStatus.OK)
	@ResponseBody
	public UserComment saveUserComment(@RequestBody final UserComment userComment) {
		userRepository.save(userComment);
		log.info("User Comment saved: " + userComment.toString());
		return userComment;
	}
	
	@CrossOrigin
	@RequestMapping(value="/userCommentId/{id}", method = RequestMethod.GET, produces = "application/json")
	public List<UserComment> userCommentID(@PathVariable("id") Integer id){

		List<UserComment> usersComment = userRepository.findById(id);
		log.info(usersComment.toString());
		return usersComment;
	}
	
	@CrossOrigin
	@RequestMapping(value="/userCommentLogin/{login}", method = RequestMethod.GET, produces = "application/json")
	public List<UserComment> userCommentID(@PathVariable("login") String login){

		List<UserComment> usersComment = userRepository.findByLogin(login);
		log.info(usersComment.toString());
		return usersComment;
	}

}
