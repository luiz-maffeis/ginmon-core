/**
 * 
 */
package de.com.ginmon_core.service;

import java.util.ArrayList;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import de.com.ginmon_core.model.User;

/**
 * @author Luiz
 *
 */
@Component("userListService")
public class UserListService {
	
	public ArrayList<User> userList(final Integer id){
		RestTemplate template = new RestTemplate();
		String url = "https://api.github.com/users?since=" + id;
		ResponseEntity<ArrayList<User>> response = 
				template.exchange(url, 
						HttpMethod.GET,null, new ParameterizedTypeReference<ArrayList<User>>() {
					
		});
		return response.getBody();
	}
}
