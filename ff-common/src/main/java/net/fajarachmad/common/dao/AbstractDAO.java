package net.fajarachmad.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import net.fajarachmad.common.model.CommonEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO<T extends CommonEntity, ID extends Serializable> implements CommonDAO<T, ID> {
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	protected Class<T> genericType;
	
	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.genericType = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	public ID insert(T entity) {
		return (ID) getCurrentSession().save(entity);
	}
	
	public void update(T entity) {
		getCurrentSession().merge(entity);
		
	}
	
	public void delete(T entity) {
		getCurrentSession().update(entity);
		
	}
	
	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		return (T) getCurrentSession().get(genericType, id);
	}
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
