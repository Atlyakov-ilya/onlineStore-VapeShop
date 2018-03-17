package com.atlyakov.vshop.service;

import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.GoodsDTO;

import java.util.List;

/**
 * This interface contains methods for data conversion and sending data to other layer.
 * Provides performance of the main application logic.
 * All methods are associated with model "GoodsDTO" and entity "Goods".
 */
public interface IGoodsService {

    /**
     * Adding Goods in DataBase
     *
     * @param goodsDTO is goods model
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    void addGoods(GoodsDTO goodsDTO) throws ServiceException;

    /**
     * Getting all goods
     *
     * @return list GoodsDTO is model for displaying information on the page
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    List<GoodsDTO> getAllGoods(Integer pageId) throws ServiceException;
    /**
     * Getting all goods by Category
     *
     * @return list GoodsDTO is model for displaying information on the page
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    List<GoodsDTO> getGoodsByCategoryWithPaginate(String category, Integer pageId) throws ServiceException;

    /**
     * Getting  goods by goodsId
     *
     * @return  GoodsDTO is model for displaying information on the page
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    GoodsDTO getGoodsById(Integer goodsId) throws ServiceException;

    /**
     * Removing goods by goodsId
     *
     * @param goodsId is goods identifier
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    void removeGoods(Integer goodsId) throws ServiceException;

    /**
     * Getting all goods by Category 'Accumulator'
     *
     * @return list GoodsDTO is model for displaying information on the page
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    List<GoodsDTO> getAllAccumulator() throws ServiceException;

    /**
     * Getting all goods by Category 'Liquid'
     *
     * @return list GoodsDTO is model for displaying information on the page
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    List<GoodsDTO> getAllLiquid() throws ServiceException;

    /**
     * Getting all goods by Category 'Atomizer'
     *
     * @return list GoodsDTO is model for displaying information on the page
     * @throws ServiceException if DaoException or HibernateException is thrown
     */

    List<GoodsDTO> getAllAtomizer() throws ServiceException;
    /**
     * Getting all goods by Category 'Components'
     *
     * @return list GoodsDTO is model for displaying information on the page
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    List<GoodsDTO> getAllComponents() throws ServiceException;


    List<GoodsDTO> getAllGoodsForAdmin() throws ServiceException;

    void editGoods(GoodsDTO goodsDTO) throws ServiceException;


}
