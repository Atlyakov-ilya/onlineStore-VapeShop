package com.atlyakov.vshop.dao.impl;

import com.atlyakov.vshop.dao.AbstractDao;
import com.atlyakov.vshop.dao.IGoodsDao;
import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.Goods;
import com.atlyakov.vshop.entity.enums.Category;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.atlyakov.vshop.dao.constant.ConstantNameDao.*;

@Repository
public class GoodsDaoImpl extends AbstractDao<Goods> implements IGoodsDao {
    private static final Logger LOGGER = Logger.getLogger(GoodsDaoImpl.class);

    @Override
    public Goods getGoodsById(Integer id) throws DaoException {
        return getSession().load(Goods.class, id);
    }

    @Override
    public List<Goods> getAllGoods(int pageId, int countPage) throws DaoException {
        List<Goods> message;
        try {
            Query query = getSession().createQuery(HQL_GET_GOODS);
            query.setFirstResult(pageId);
            query.setMaxResults(countPage);
            message = query.getResultList();
            LOGGER.info("List of objects the Goods has successfully loaded");
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method getAllGoods() ");
            throw new DaoException(e);
        }
        return message;
    }

    @Override
    public List<Goods> getAllGoodsByCategory(Category category) throws DaoException {
        List<Goods> goods;
        try {
            Query query = getSession().createQuery(HQL_GET_GOODS_BY_CATEGORY);
            query.setParameter(PARAMETER_GOODS_CATEGORY, category);
            goods = query.getResultList();
            LOGGER.info("Goods successfully found by category ");
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method getAllGoodsByCategory");
            throw new DaoException(e);
        }
        return goods;
    }

    @Override
    public List<Goods> getGoodsByUserId(Integer user) throws DaoException {
        List<Goods> goods;
        try {
            Query query = getSession().createQuery(HQL_GET_GOODS_BY_USER_ID);
            query.setParameter(PARAMETER_USER_ID, user);
            goods = query.list();
            LOGGER.info("Goods successfully found by user id ");
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method getGoodsByUserId");
            throw new DaoException(e);
        }
        return goods;
    }
}
