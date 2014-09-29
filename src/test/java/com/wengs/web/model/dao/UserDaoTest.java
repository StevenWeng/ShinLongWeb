package com.wengs.web.model.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wengs.web.model.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:test-context.xml")
public class UserDaoTest {
	@Autowired
	UserDao userDao;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUsername("steven");
		user.setPassword("asdf1234");
		user.setRole("TEST");
		userDao.create(user);
		
//		User testUser = userDao.findByUsername("steven");
//		assertNotNull(testUser);
	}

}
