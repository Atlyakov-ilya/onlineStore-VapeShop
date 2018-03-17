package com.atlyakov.vshop.dao;

import com.atlyakov.vshop.dao.exception.DaoException;

import java.io.Serializable;
import java.util.List;

/**
 * This interface performs the function of working with common Hibernate methods
 * Methods are associated with all entities
 * standard CRUD operations and return list
 */
public interface IDao<T extends Serializable> {

    /**
     * Saving entity to/in database
     *
     * @param entity - abstract Entity
     * @throws DaoException if HibernateException is thrown
     */
    void save(T entity) throws DaoException;

    /**
     * Updating entity to/in database
     *
     * @param entity - abstract Entity
     * @throws DaoException if HibernateException is thrown
     */
    Serializable update(T entity) throws DaoException;

    /**
     * Deleting entity from database
     *
     * @param id - abstract Entity id to delete
     * @throws DaoException if HibernateException is thrown
     */
    void delete(Integer id) throws DaoException;

    /**
     * Getting entity by id
     *
     * @param id - abstract Entity id
     * @return entity - persistent entity from database
     * @throws DaoException if HibernateException is thrown
     */
    T getById(Integer id) throws DaoException;

    /**
     * Getting List of abstract Entity
     *
     * @return list - list of entities
     * @throws DaoException if HibernateException is thrown
     */
    List<T> getAll() throws DaoException;

}
