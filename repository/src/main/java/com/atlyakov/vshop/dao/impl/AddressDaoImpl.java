package com.atlyakov.vshop.dao.impl;

import com.atlyakov.vshop.dao.AbstractDao;
import com.atlyakov.vshop.dao.IAddressDao;
import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.Address;
import com.atlyakov.vshop.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import static com.atlyakov.vshop.dao.constant.ConstantNameDao.HQL_GET_ADDRESS_BY_USER_ID;
import static com.atlyakov.vshop.dao.constant.ConstantNameDao.PARAMETER_USER_ID;

@Repository
public class AddressDaoImpl extends AbstractDao<Address> implements IAddressDao {
    private static final Logger LOGGER = Logger.getLogger(AddressDaoImpl.class);

    @Override
    public Address getAddressByUser(User user) throws DaoException {
        Address address;
        try {
            Query query = getSession().createQuery(HQL_GET_ADDRESS_BY_USER_ID);
            query.setParameter(PARAMETER_USER_ID, user);
            address = (Address) query.uniqueResult();
            LOGGER.info("Address successfully found by userId ");
        } catch (HibernateException e) {
            LOGGER.error("Hibernate Exception during implementation of method getAddressByUser");
            throw new DaoException(e);
        }
        return address;
    }
}
