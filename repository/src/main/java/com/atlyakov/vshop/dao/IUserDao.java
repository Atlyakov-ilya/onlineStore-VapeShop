package com.atlyakov.vshop.dao;

import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.User;

import java.io.Serializable;

/**
 * This interface contains methods for transferring data to database and for receiving data from it.
 * All methods are associated with entity "User"
 */
public interface IUserDao extends IDao<User> {

    /**
     * Returns User from database
     *
     * @param username unique user name to search in database
     * @return User from database or null if user whit the specified id is not contained in database
     * @throws DaoException if HibernateException is thrown
     */
    User getUserByUserName(String username) throws DaoException;

}
