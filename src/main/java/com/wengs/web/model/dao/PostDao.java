package com.wengs.web.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wengs.web.model.entity.Post;

public class PostDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(Post post){
		Session session = getSessionFactory().openSession();
		session.save(post);
		session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
