package com.atlyakov.vshop.dao.impl;

import com.atlyakov.vshop.dao.AbstractDao;
import com.atlyakov.vshop.dao.IOrderDao;
import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.Goods;
import com.atlyakov.vshop.entity.Orders;
import com.atlyakov.vshop.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.atlyakov.vshop.dao.constant.ConstantNameDao.*;


@Repository
public class OrderDaoImpl extends AbstractDao<Orders> implements IOrderDao {
    private static final Logger LOGGER = Logger.getLogger(OrderDaoImpl.class);

    @Override
    public Orders findLastOrderByUserId(User user) throws DaoException {
        Orders orders;
        try {
            Query query = getSession().createQuery(HQL_GET_LAST_ORDER);
            query.setParameter(PARAMETER_USER_ID, user);
            orders = (Orders) query.uniqueResult();
            LOGGER.info("Last order successfully found by userId ");
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method findLastOrderByUserId");
            throw new DaoException(e);
        }
        return orders;
    }

    @Override
    public List<Goods> getAllGoodsInOrder(Integer orderId) throws DaoException {
        List<Goods> goods;
        try {
            Query query = getSession().createQuery(HQL_GET_ALL_GOODS_IN_ORDER);
            query.setParameter(PARAMETER_ORDER_ID, orderId);
            goods = (List<Goods>) query.getResultList();
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method findLastOrderByUserId");
            throw new DaoException(e);
        }
        return goods;
    }


}
