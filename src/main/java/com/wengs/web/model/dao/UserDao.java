package com.wengs.web.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.wengs.web.model.dao.impl.SimpleCommonDao;
import com.wengs.web.model.entity.User;

public class UserDao extends SimpleCommonDao<User>{
	
	@Override
	public void update(User entity) {
		// TODO Auto-generated method stub
		super.update(entity);
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public User getById(Serializable id) {
		// TODO Auto-generated method stub
		return super.getById(id);
	}

	@Override
	public List<User> findByCriteria(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return super.findByCriteria(detachedCriteria);
	}

	@Override
	public Class<User> getGenericClass() {
		// TODO Auto-generated method stub
		return super.getGenericClass();
	}

	@Override
	public void create(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		super.create(user);
	}

	public User findByUsername(String username) {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		User user = (User) criteria.uniqueResult();
		session.close();
		return user;
	}


}
