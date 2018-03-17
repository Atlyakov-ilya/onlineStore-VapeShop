package com.atlyakov.vshop.dao.impl;

import com.atlyakov.vshop.dao.AbstractDao;
import com.atlyakov.vshop.dao.IFeedBackDao;
import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.FeedBack;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.atlyakov.vshop.dao.constant.ConstantNameDao.HQL_GET_FEEDBACK;

@Repository
public class FeedBackDaoImpl extends AbstractDao<FeedBack> implements IFeedBackDao {
    private static final Logger LOGGER = Logger.getLogger(FeedBackDaoImpl.class);

    @Override
    public List<FeedBack> getAllUserMessage(int pageId, int countPage) throws DaoException {
        List<FeedBack> message;
        try {
            Query query = getSession().createQuery(HQL_GET_FEEDBACK);
            query.setFirstResult(pageId);
            query.setMaxResults(countPage);
            message = query.getResultList();
            LOGGER.info("List of objects the FeedBack has successfully loaded");
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method getAll() ");
            throw new DaoException(e);
        }
        return message;
    }
}
