package com.atlyakov.vshop.dao;

import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.Goods;
import com.atlyakov.vshop.entity.enums.Category;

import java.util.List;

/**
 * This interface contains methods for transferring data to database and for receiving data from it.
 * All methods are associated with entity "Goods"
 */
public interface IGoodsDao extends IDao<Goods> {

    /**
     * Getting goods by id
     *
     * @param id   this is goods id
     * @return entity goods
     * @throws DaoException if HibernateException is thrown
     */
    Goods getGoodsById(Integer id) throws DaoException;

    /**
     * Getting all goods with pagination
     *
     * @param pageId this is the page number
     * @param countPage this is the number of messages that will be reflected on the page
     * @return list goods
     * @throws DaoException if HibernateException is thrown
     */
    List<Goods> getAllGoods(int pageId, int countPage) throws DaoException;

    /**
     * Getting all goods by category
     *
     * @param category unique category id to search in database
     * @return list goods
     * @throws DaoException if HibernateException is thrown
     */
    List<Goods> getAllGoodsByCategory(Category category) throws DaoException;

    /**
     * Getting all goods by user id
     *
     * @param user unique user id to search in database
     * @return list goods
     * @throws DaoException if HibernateException is thrown
     */
    List<Goods> getGoodsByUserId(Integer user) throws DaoException;

}
