package net.fajarachmad.common.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

import net.fajarachmad.common.model.CommonEntity;

public interface CommonDAO<T extends CommonEntity, ID extends Serializable> {
	
	public ID insert(T entity);
	
	public void update(T entity);
	
	public T findById(ID id);
	
	public void delete(T entity);
	
	public List<T> findByCriteria(Criterion... criterions);
}
