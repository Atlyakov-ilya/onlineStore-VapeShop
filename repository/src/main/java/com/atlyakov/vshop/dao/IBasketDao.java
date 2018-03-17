package com.atlyakov.vshop.dao;

import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.Basket;
import com.atlyakov.vshop.entity.Goods;
import com.atlyakov.vshop.entity.Orders;
import com.atlyakov.vshop.entity.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * This interface contains methods for transferring data to database and for receiving data from it.
 * Methods are associated with different entities
 */
public interface IBasketDao extends IDao<Basket> {

    /**
     * Receiving all goods in the basket
     *
     * @param user unique user id to search in database
     * @return list goods
     * @throws DaoException if HibernateException is thrown
     */
    List<Goods> getAllGoodsInBasketByUserId(User user) throws DaoException;

    /**
     * Receiving all goods in the basket by article
     *
     * @param goodsArticle unique goods id to search
     * @return list goods
     * @throws DaoException if HibernateException is thrown
     */
    Goods getGoodsInBasketByArticle(String goodsArticle) throws DaoException;

    /**
     * Remove goods from the basket
     *
     * @param goods unique goods id to search in database
     * @return basket id
     * @throws DaoException if HibernateException is thrown
     */
    Basket deleteGoodsFromBasket(Goods goods) throws DaoException;

    /**
     * Adding goods in order
     *
     * @param orders unique order id to search in database
     * @param user   unique user id to search in database
     * @throws DaoException if HibernateException is thrown
     */
    void addOrderToTheBasket(Orders orders, User user) throws DaoException;

    /**
     * Returns the total price of goods in the basket
     *
     * @param user unique user id to search in database
     * @throws DaoException if HibernateException is thrown
     */
    BigDecimal getAllPrice(User user) throws DaoException;

}
