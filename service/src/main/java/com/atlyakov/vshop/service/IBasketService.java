package com.atlyakov.vshop.service;

import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.BasketDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * This interface contains methods for data conversion and sending data to other layer.
 * Provides performance of the main application logic.
 * All methods are associated with model "BasketDTO" and different entity.
 */
public interface IBasketService {

    /**
     * Adding Goods in Basket
     *
     * @param id is goods identifier
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    void addGoodsToBasket(Integer id) throws ServiceException;

    /**
     * Getting all Goods in Basket
     *
     * @return list of products in the basket
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    Set<BasketDTO> getAllGoodsInBasket() throws ServiceException;

    /**
     * Removing Goods from the Basket
     *
     * @param basketId is goods identifier
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    void removeGoodsInBasket(String basketId) throws ServiceException;

    /**
     * Returns the total price of goods in the basket
     *
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    BigDecimal getAllPrice() throws ServiceException;

}
