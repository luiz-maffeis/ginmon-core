package de.com.ginmon_core.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.com.ginmon_core.model.UserComment;
import de.com.ginmon_core.repository.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private UserRepository userRepository;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
    public void shouldReturnUserList() throws Exception {
		this.mockMvc.perform(get("/userList/0"))
		.andDo(print())
		.andExpect(status().isOk())
        //.andExpect(content().json(null))
        ;
    }
	
	@Test
    public void shouldReturnUserDetail() throws Exception {
		this.mockMvc.perform(get("/userDetail/mojombo"))
		.andDo(print())
		.andExpect(status().isOk());
    }
	
	
	@Test
    public void shouldSaveUserComment() throws Exception {
		UserComment user = new UserComment("test", 1, "Comments");
		when(userRepository.save(user)).thenReturn(user);
		
		this.mockMvc.perform(post("/saveUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }
	
	
	@Test
    public void shouldDetailUserCommentbyId() throws Exception {
		UserComment user = new UserComment("test", 1, "Comments");
		ArrayList<UserComment> userList = new ArrayList<UserComment>();
		userList.add(user);
		when(userRepository.findById(1)).thenReturn(userList);
		
		this.mockMvc.perform(get("/userCommentId/1"))
		.andDo(print())
		.andExpect(status().isOk());
    }
	
	@Test
    public void shouldDetailUserCommentbyLogin() throws Exception {
		UserComment user = new UserComment("test", 1, "Comments");
		ArrayList<UserComment> userList = new ArrayList<UserComment>();
		userList.add(user);
		when(userRepository.findByLogin("test")).thenReturn(userList);
		
		this.mockMvc.perform(get("/userCommentLogin/test"))
		.andDo(print())
		.andExpect(status().isOk());
    }
	
	
}
