package com.hello.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;



/**
 * dao层基类，实现增，删，改，查等常用功能。
 * 
 * @author
 * @date
 * @version 0.0.1
 * @param <T>
 */

@Transactional
public class BaseDao<T> {

	private Class<T> entityClass;


	@Resource
	private SessionFactory sessionFactory;

	/**
	 * 通过反射获取子类确定的泛型类
	 */
	public BaseDao() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}

	/**
	 * 根据ID加载PO实例
	 * 
	 * @param id
	 * @return 返回相应的持久化PO实例
	 */
	public T load(Serializable id) {
		return (T) getSession().load(entityClass, id);
	}

	/**
	 * 根据ID获取PO实例
	 * 
	 * @param id
	 * @return 返回相应的持久化PO实例
	 */
	public T get(Serializable id) {
		return (T) getSession().get(entityClass, id);
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	public void remove(T entity) {
		getSession().delete(entity);
	}
	
	public void removeByID(Serializable id) {
		getSession().delete(get(id));
	}

	public void update(T entity) {
		getSession().update(entity);
	}
	
	public List<T> getAll() {
		Criteria criteria=getSession().createCriteria(entityClass);
		return criteria.list();
	}
	


	public Session getSession() {		
		return sessionFactory.getCurrentSession();
	}
}
