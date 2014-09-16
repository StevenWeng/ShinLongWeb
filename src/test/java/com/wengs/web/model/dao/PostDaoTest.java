package com.wengs.web.model.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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
public class PostDaoTest {
	@Autowired
	PostDao postDao;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateAndGet() {
		Post post = new Post();
		post.setTitle("testTitle");
		post.setContext("testContext");
		post.setModifyTs(new Date());
		post.setPublishTs(new Date());
		postDao.create(post);
		DetachedCriteria dc = DetachedCriteria.forClass(Post.class);
		dc.add(Restrictions.eq("title", "testTitle"));
		Post testPost = postDao.findUniqeByCriteria(dc);
		assertEquals("testContext", testPost.getContext());
	}

	@Test
	public void testUpdate() {
		Post post = new Post();
		post.setTitle("testUpdateTitle");
		post.setContext("testUpdateContext");
		post.setModifyTs(new Date());
		post.setPublishTs(new Date());
		postDao.create(post);
		DetachedCriteria dc = DetachedCriteria.forClass(Post.class);
		dc.add(Restrictions.eq("title", "testUpdateTitle"));
		Post updatePost = postDao.findUniqeByCriteria(dc);
		updatePost.setContext("afterUpdateContext");
		postDao.update(updatePost);
		Post testPost = postDao.findUniqeByCriteria(dc);
		assertEquals("afterUpdateContext", testPost.getContext());
	}

	@Test
	public void testDelete() {
		Post post = new Post();
		post.setTitle("testDelTitle");
		post.setContext("testDelContext");
		post.setModifyTs(new Date());
		post.setPublishTs(new Date());
		postDao.create(post);
		Post delPost = new Post();
		delPost.setId(post.getId());//if id match,that will be delete
		delPost.setTitle("");// because member is non null
		delPost.setPublishTs(new Date());// because member is non null
		postDao.delete(delPost);
		DetachedCriteria dc = DetachedCriteria.forClass(Post.class);
		dc.add(Restrictions.eq("title", "testDelTitle"));
		Post testPost = postDao.findUniqeByCriteria(dc);
		assertNull(testPost);
	}


}
