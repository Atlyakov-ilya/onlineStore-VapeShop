package com.atlyakov.vshop.dao;

import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.Address;
import com.atlyakov.vshop.entity.User;

/**
 * This interface contains methods for transferring data to database and for receiving data from it.
 * All methods are associated with entity "Address"
 */
public interface IAddressDao extends IDao<Address> {

    /**
     * Getting address of the user by user id
     *
     * @param user unique user id to search in database
     * @return the address of the user or null if the address is not created yet.
     * @throws DaoException if HibernateException is thrown
     */
    Address getAddressByUser(User user) throws DaoException;
}
