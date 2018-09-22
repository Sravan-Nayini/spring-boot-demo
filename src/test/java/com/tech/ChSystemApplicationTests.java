package com.tech;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tech.entities.Task;
import com.tech.entities.User;
import com.tech.service.TaskService;
import com.tech.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChSystemApplicationTests {
	
	@Autowired
	UserService userService;

	@Autowired
	TaskService taskService;
	

	@Before
	public void initDb() {
		
		{
			User newUser=new User("testUser@mail.com","testuser","123456");
			userService.createUser(newUser);
		}
		{
			User newUser=new User("testAdmin@mail.com","testadmin","123456");
			userService.createUser(newUser);
		}
		
		Task userTask=new Task("03/01/2018","00:11","11:00","you nedd to work");
	     User user=userService.findOne("testUser@mail.com");
	     taskService.addTask(userTask, user);
	}
	@Test
	public void testUser()
	{
		User user=userService.findOne("testUser@mail.com");
		assertNotNull(user);
		
		User admin=userService.findOne("testAdmin@mail.com");
		assertEquals(admin.getEmail(),"testAdmin@mail.com");
		
	}
	@Test
	public void testTask()
	{
		User user =userService.findOne("testUser@mail.com");
		List<Task> tasks=taskService.findUserTask(user);
		assertNotNull(tasks);
		
	}

}