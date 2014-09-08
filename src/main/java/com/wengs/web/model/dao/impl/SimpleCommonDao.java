package com.wengs.web.model.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wengs.web.model.dao.CommonDao;

public class SimpleCommonDao<T> implements CommonDao<T> {
	private Class<T> genericClass;

	@Autowired
	private SessionFactory sessionFactory;

	public SimpleCommonDao() {
		this.genericClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void create(T entity) {
		Session session = getSessionFactory().openSession();
		session.save(entity);
		session.close();
	}

	@Override
	public void update(T entity) {
		Session session = getSessionFactory().openSession();
		session.update(entity);
		session.close();
	}

	@Override
	public void createOrUpdate(T entity) {
		Session session = getSessionFactory().openSession();
		session.saveOrUpdate(entity);
		session.close();
	}

	@Override
	public void delete(T entity) {
		Session session = getSessionFactory().openSession();
		session.delete(entity);
		session.close();
	}

	@Override
	public List<T> findAll() {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(getGenericClass());
		List<T> results = criteria.list();
		session.close();
		return results;
	}

	@Override
	public T getById(Serializable id) {
		Session session = getSessionFactory().openSession();
		T result = (T) session.get(getGenericClass(), id);
		session.close();
		return result;
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria detachedCriteria) {
		Session session = getSessionFactory().openSession();

		List<T> results = detachedCriteria.getExecutableCriteria(session)
				.list();
		session.close();
		return results;
	}

	@Override
	public T findUniqeByCriteria(DetachedCriteria detachedCriteria) {
		Session session = getSessionFactory().openSession();
		T result = (T) detachedCriteria.getExecutableCriteria(session)
				.uniqueResult();
		session.close();
		return result;
	}

	public Class<T> getGenericClass() {
		return genericClass;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
