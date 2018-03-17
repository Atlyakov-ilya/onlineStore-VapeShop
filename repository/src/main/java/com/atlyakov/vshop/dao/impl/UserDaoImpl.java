package com.atlyakov.vshop.dao.impl;

import com.atlyakov.vshop.dao.AbstractDao;
import com.atlyakov.vshop.dao.IUserDao;
import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import static com.atlyakov.vshop.dao.constant.ConstantNameDao.*;


@Repository
public class UserDaoImpl extends AbstractDao<User> implements IUserDao {
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    @Override
    public User getUserByUserName(String username) throws DaoException {
        User user;
        try {
            Query query = getSession().createQuery(HQL_GET_BY_USER_NAME);
            query.setParameter(PARAMETER_USER_NAME, username);
            user = (User) query.uniqueResult();
            LOGGER.info("User successfully found by username ");
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method getUserByUserName");
            throw new DaoException(e);
        }
        return user;
    }
}
