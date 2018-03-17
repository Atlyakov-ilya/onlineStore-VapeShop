package com.atlyakov.vshop.dao.impl;

import com.atlyakov.vshop.dao.AbstractDao;
import com.atlyakov.vshop.dao.IBasketDao;
import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.Basket;
import com.atlyakov.vshop.entity.Goods;
import com.atlyakov.vshop.entity.Orders;
import com.atlyakov.vshop.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

import static com.atlyakov.vshop.dao.constant.ConstantNameDao.*;


@Repository
public class BasketDaoImpl extends AbstractDao<Basket> implements IBasketDao {
    private static final Logger LOGGER = Logger.getLogger(BasketDaoImpl.class);

    @Override
    public List<Goods> getAllGoodsInBasketByUserId(User user) throws DaoException {
        List<Goods> goodsInBasketList;
        try {
            Query query = getSession().createQuery(HQL_GET_GOODS_BY_USER_ID_IN_BASKET);
            query.setParameter(PARAMETER_USER_ID, user);
            goodsInBasketList = query.list();
            LOGGER.info("Successful receipt of all goods");
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method getGoodsByUserId");
            throw new DaoException(e);
        }
        return goodsInBasketList;
    }

    @Override
    public Goods getGoodsInBasketByArticle(String goodsArticle) throws DaoException {
        try {
            Query query = getSession().createQuery(HQL_GET_GOODS_BY_ARTICLE);
            query.setParameter(PARAMETER_GOODS_ARTICLE, goodsArticle);
            LOGGER.info("Goods successfully received by article");
            return (Goods) query.uniqueResult();
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method getGoodsInBasketByArticle");
            throw new DaoException(e);
        }
    }

    @Override
    public Basket deleteGoodsFromBasket(Goods goods) throws DaoException {
        try {
            Query query = getSession().createQuery(HQL_GET_GOODS_FROM_BASKET);
            query.setParameter(PARAMETER_GOODS, goods);
            LOGGER.info("Goods successfully deleted from basket");
            return (Basket) query.uniqueResult();
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method deleteGoodsFromBasket");
            throw new DaoException(e);
        }
    }

    @Override
    public void addOrderToTheBasket(Orders orders, User user) throws DaoException {
        try {
            Query query = getSession().createQuery(HQL_ADD_GOODS_IN_BASKET_TO_THE_ORDER);
            query.setParameter(PARAMETER_ORDER, orders);
            query.setParameter(PARAMETER_USER_ID, user);
            query.executeUpdate();
            LOGGER.info("Goods successfully added to order");
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method addOrderToTheBasket");
            throw new DaoException(e);
        }
    }

    @Override
    public BigDecimal getAllPrice(User user) throws DaoException {
        try {
            Query query = getSession().createQuery(HQL_GET_ALL_PRICE);
            query.setParameter(PARAMETER_USER_ID, user);
            return (BigDecimal) query.uniqueResult();
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method addOrderToTheBasket");
            throw new DaoException(e);
        }
    }
}

