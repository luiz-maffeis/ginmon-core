/**
 * 
 */
package de.com.ginmon_core.transaction;

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
@Component("userListTransaction")
public class UserListTransaction {
	
	public ArrayList<User> userList(final int id){
		RestTemplate template = new RestTemplate();
		ResponseEntity<ArrayList<User>> response = 
				template.exchange("https://api.github.com/users?since=" + id, 
						HttpMethod.GET,null, new ParameterizedTypeReference<ArrayList<User>>() {
					
		});
		return response.getBody();
	}
}
