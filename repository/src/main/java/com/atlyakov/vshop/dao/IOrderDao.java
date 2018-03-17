package com.atlyakov.vshop.dao;

import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.Goods;
import com.atlyakov.vshop.entity.Orders;
import com.atlyakov.vshop.entity.User;

import java.util.List;

/**
 * This interface contains methods for transferring data to database and for receiving data from it.
 * All methods are associated with entity "Orders"
 */
public interface IOrderDao extends IDao<Orders> {

    /**
     * Finds the last order
     *
     * @param user unique user id to search in database
     * @return the last Order created by User
     * @throws DaoException if HibernateException is thrown
     */
    Orders findLastOrderByUserId(User user) throws DaoException;

    /**
     * Getting  list goods id in order
     *
     * @param orderId unique order id to search in database
     * @return list goods by order
     * @throws DaoException if HibernateException is thrown
     */
    List<Goods> getAllGoodsInOrder(Integer orderId) throws DaoException;


}
