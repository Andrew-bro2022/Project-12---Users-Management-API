package com.andy;

import com.andy.model.User;
import com.andy.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class UsersManageApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@Test
	public void testCreateUser() throws Exception {
		User newUser = new User();
		newUser.setUsername("newuser");
		newUser.setFirstName("New");
		newUser.setLastName("User");
		newUser.setEmail("newuser@example.com");
		newUser.setPhoneNumber("1234567890");

		Mockito.when(userService.createUser(Mockito.any(User.class))).thenReturn(newUser);

		mockMvc.perform(post("/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"username\":\"newuser\",\"firstName\":\"New\",\"lastName\":\"User\",\"email\":\"newuser@example.com\",\"phoneNumber\":\"1234567890\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username").value("newuser"));
	}

	@Test
	public void testGetAllUsers() throws Exception {
		User user1 = new User();
		user1.setUsername("user1");
		User user2 = new User();
		user2.setUsername("user2");

		Mockito.when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

		mockMvc.perform(get("/users"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].username").value("user1"))
				.andExpect(jsonPath("$[1].username").value("user2"));
	}

	@Test
	public void testGetUserById() throws Exception {
		User user = new User();
		user.setId(1L);
		user.setUsername("existinguser");

		Mockito.when(userService.getUserById(1L)).thenReturn(Optional.of(user));

		mockMvc.perform(get("/users/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username").value("existinguser"));
	}

	@Test
	public void testUpdateUser() throws Exception {
		User updatedUser = new User();
		updatedUser.setUsername("updateduser");
		updatedUser.setFirstName("Updated");
		updatedUser.setLastName("User");

		Mockito.when(userService.updateUser(Mockito.eq(1L), Mockito.any(User.class))).thenReturn(updatedUser);

		mockMvc.perform(put("/users/1")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"username\":\"updateduser\",\"firstName\":\"Updated\",\"lastName\":\"User\",\"email\":\"updated@example.com\",\"phoneNumber\":\"9876543210\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username").value("updateduser"));
	}

	@Test
	public void testDeleteUser() throws Exception {
		Mockito.doNothing().when(userService).deleteUser(1L);

		mockMvc.perform(delete("/users/1"))
				.andExpect(status().isOk());
	}
}


