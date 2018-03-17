package com.atlyakov.vshop.dao;

import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.FeedBack;

import java.util.List;

/**
 * This interface contains methods for transferring data to database and for receiving data from it.
 * All methods are associated with entity "FeedBack"
 */
public interface IFeedBackDao extends IDao<FeedBack> {

    /**
     * Getting all user message(feed back) with pagination
     *
     * @param pageId    this is the page number
     * @param countPage this is the number of messages that will be reflected on the page
     * @return list FeedBack(user messages)
     * @throws DaoException if HibernateException is thrown
     */
    List<FeedBack> getAllUserMessage(int pageId, int countPage) throws DaoException;
}
