/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.fullstack.persistence;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

/**
 *
 * @author Tj
 */
public class GenericJPARepository<T> {

    @PersistenceContext
    EntityManager manager;

    private final Class<T> persistClass;

    public GenericJPARepository(Class<T> persistClass) {
        this.persistClass = persistClass;
    }

    public void setEntityManager(EntityManager em) {
        manager = em;
    }

    @Transactional
    public T insert(T t) {
        manager.persist(t);
        return t;
    }

    @Transactional
    public T update(T t) {
        manager.merge(t);
        return t;
    }

    @Transactional
    public T delete(Long id) {
        T toRemove = manager.find(this.persistClass, id);
        if (toRemove != null) {
            manager.remove(toRemove);
        }
        return toRemove;
    }

    @Transactional
    public T delete(Object o) {
        T toRemove = manager.find(this.persistClass, o);
        if (toRemove != null) {
            manager.remove(toRemove);
        }
        return toRemove;
    }

    public T findById(Long id) {
        T result;
        result = manager.find(this.persistClass, id);
        return result;
    }

    public T findByObject(Object o) {
        T result;
        result = manager.find(this.persistClass, o);
        return result;
    }

    public List<T> list() {
        return list(0, Integer.MAX_VALUE);
    }

    public List<T> list(int page, int pagesize) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(this.persistClass);
        Root<T> from = query.from(this.persistClass);
        CriteriaQuery<T> select = query.select(from);
        TypedQuery<T> typedQuery = manager.createQuery(select);
        typedQuery.setFirstResult(page * pagesize);
        typedQuery.setMaxResults(pagesize);
        List<T> results = typedQuery.getResultList();
        return results;
    }

    public List<T> executeQuery(String queryName, HashMap<String, Object> parameters) {
        TypedQuery<T> query = this.manager.createNamedQuery(queryName, persistClass);       
        if (parameters != null) {
            for(Map.Entry<String, Object> pair : parameters.entrySet()) {
                query.setParameter(pair.getKey(), pair.getValue());
            }
        }
        return query.getResultList();
    }

}
