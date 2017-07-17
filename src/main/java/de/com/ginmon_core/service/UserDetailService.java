package de.com.ginmon_core.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import de.com.ginmon_core.excepcion.UserNotFoundException;
import de.com.ginmon_core.model.User;

@Component("userDetailService")
public class UserDetailService {
	
	public User userDetail(final String username) {
		RestTemplate template = new RestTemplate();
		final String url = "https://api.github.com/users/"+username;
		ResponseEntity<User> response = 
				template.exchange(url, 
						HttpMethod.GET,null, new ParameterizedTypeReference<User>() {
					
		});
		if(response == null) {
			throw new UserNotFoundException(username);
		}
		return response.getBody();
	}

}
