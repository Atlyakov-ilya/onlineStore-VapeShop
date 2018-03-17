package com.atlyakov.vshop.service;

import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.FeedBackDTO;

import java.util.List;

/**
 * This interface contains methods for data conversion and sending data to other layer.
 * Provides performance of the main application logic.
 * All methods are associated with model "FeedBackDTO" and entity "FeedBack".
 */
public interface IFeedBackService {

    /**
     * Adding message(feed back) in database
     *
     * @param feedBackDTO entity model "FeedBack"
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    void addMessage(FeedBackDTO feedBackDTO) throws ServiceException;

    /**
     * Receiving all messages from the database
     *
     * @param pageId   this is the page number
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    List<FeedBackDTO> getAllMessage(Integer pageId)throws ServiceException;


    /**
     * Deleting FeedBack from database
     *
     * @param feedBackId - message id to delete
     * @throws ServiceException if DaoException or HibernateException is thrown
     */
    void removeFeedBack(Integer feedBackId)throws ServiceException;
}
