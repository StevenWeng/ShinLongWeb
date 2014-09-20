package com.wengs.web.model.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wengs.web.model.entity.Post;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:test-context.xml")
public class PostServiceTest {
	@Autowired
	PostService postService;
	
	@Before
	public void setUp() throws Exception {
		List<Post> list = postService.listAllPosts();
		for(Post each:list){
			postService.deletePostById(each.getId());
		}
		
		for (int i = 0; i < 20; i++) {
			Post post = new Post();
			post.setTitle("title"+i);
			post.setContext("context"+i);
			post.setPublishTs(new Date());
			postService.createOrUpdatePost(post);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListDescOrderPostsByPage() {
		List<Post> list = postService.listDescOrderPostsByPage(3, 9,false);
		assertEquals(2, list.size());
	}

	@Test
	public void testGetMaxPageNumber() {
		int max = postService.getMaxPageNumber(9);
		assertEquals(3, max);
	}

}
