package com.atlyakov.vshop.service;

import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.UserDTO;

import java.util.List;

/**
 * This interface contains methods for data conversion and sending data to other layer.
 * Provides performance of the main application logic.
 * All methods are associated with model "UserDTO" and entity "User".
 */
public interface IUserService {

    /**
     * Registration
     *
     * @param userDTO is user model
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    void registration(UserDTO userDTO) throws ServiceException;

    /**
     * Getting all users in database
     *
     * @return list userDTO
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    List<UserDTO> getAll() throws ServiceException;

    /**
     * Removing user from database by userId
     *
     * @param userId is user identifier
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    void removeUser(Integer userId) throws ServiceException;

    /**
     * Getting user by user id
     *
     * @param userId is user identifier
     * @return userDTO is user model
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    UserDTO getUserById(Integer userId) throws ServiceException;

    /**
     * Updating user by userDTO
     *
     * @param userDTO is user model
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    void update(UserDTO userDTO) throws ServiceException;

    UserDTO getCurrentUser() throws ServiceException;

}
