package com.wengs.web.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface CommonDao<T> {
	public void create(T entity);

	public void update(T entity);

	public void createOrUpdate(T entity);

	public void delete(T entity);

	public List<T> findAll();

	public T getById(Serializable id);

	public List<T> findByCriteria(DetachedCriteria detachedCriteria);

	public T findUniqeByCriteria(DetachedCriteria detachedCriteria);
}
