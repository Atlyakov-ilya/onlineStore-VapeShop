package com.atlyakov.vshop.dao;

import com.atlyakov.vshop.dao.exception.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public abstract class AbstractDao<T extends Serializable> implements IDao<T> {
    private static final Logger LOGGER = Logger.getLogger(AbstractDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> persistenceClass;

    public AbstractDao() {
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private Class<T> getPersistenceClass() {
        return persistenceClass;
    }


    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(T entity) throws DaoException {
        try {
            getSession().save(entity);
            LOGGER.info("Object " + entity + " successful saved.");
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method save");
            throw new DaoException(e);
        }
    }

    @Override
    public Serializable update(T entity) throws DaoException {
        Serializable id;
        try {
            getSession().update(entity);
            id = getSession().getIdentifier(entity);
            LOGGER.info("Object " + entity + " successful updated and saved.");
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method saveOrUpdate");
            throw new DaoException(e);
        }
        return id;
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            T entity = (T) getSession().get(getPersistenceClass(), id);
            if (entity != null) {
                getSession().delete(entity);
            }
            LOGGER.info("Object " + entity + " successfully deleted.");
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method delete");
            throw new DaoException(e);
        }
    }

    @Override
    public T getById(Integer id) throws DaoException {
        T entity;
        try {
            entity = (T) getSession().get(getPersistenceClass(), id);
            LOGGER.info("Object " + entity + " successfully find by id.");
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method getById");
            throw new DaoException(e);
        }
        return entity;
    }

    @Override
    public List<T> getAll() throws DaoException {
        List<T> list;
        try {
            list = getSession().createQuery("from " + getPersistenceClass().getName()).list();
            LOGGER.info("List of objects the" + getPersistenceClass().getName() + "has successfully loaded");
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method getAll() ");
            throw new DaoException(e);
        }
        return list;
    }

}