package com.dataeconomy.framework.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

/**
 * 
 * @author Guvala
 *
 */
public interface BaseDAO<T, ID extends Serializable> {

	T findOne(ID id);

	List<T> findAll();

	long count();

	<S extends T> S create(S entity);

	<S extends T> S update(S entity);

	T findSingle(CriteriaQuery<T> cQuery);

	void delete(T entity);

	void deleteAll(List<T> entities);

	void detach(T entity);

	void batchCreate(List<T> entities, int batchSize);
	
	void batchUpdate(List<T> entities, int batchSize);
}
