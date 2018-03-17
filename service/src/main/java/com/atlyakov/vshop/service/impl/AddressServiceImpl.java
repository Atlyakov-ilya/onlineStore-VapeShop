package com.atlyakov.vshop.service.impl;

import com.atlyakov.vshop.dao.IAddressDao;
import com.atlyakov.vshop.dao.IUserDao;
import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.Address;
import com.atlyakov.vshop.entity.User;
import com.atlyakov.vshop.service.IAddressService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.AddressDTO;
import com.atlyakov.vshop.service.model.AppUserPrincipal;
import com.atlyakov.vshop.service.util.AddressConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressServiceImpl implements IAddressService {
    private static final Logger LOGGER = Logger.getLogger(AddressServiceImpl.class);

    private IAddressDao addressDao;
    private IUserDao userDao;

    @Autowired
    public AddressServiceImpl(IAddressDao addressDao, IUserDao userDao) {
        this.addressDao = addressDao;
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addAddress(AddressDTO addressDTO) throws ServiceException {
        Address address = AddressConverter.convert(addressDTO);
        address.setUser(getUser());
        try {
            addressDao.save(address);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method addAddress");
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional
    public AddressDTO getAddressByUserId() throws ServiceException {
        Address address;
        try {
            address = addressDao.getAddressByUser(getUser());
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getAddressByUserId");
            throw new ServiceException(e);
        }
        if (address != null) {
            return AddressConverter.convert(address);
        }
        return null;
    }


    private User getUser() {
        AppUserPrincipal principal = (AppUserPrincipal) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User user = null;
        try {
            user = userDao.getById(principal.getUserId());
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getUser");
        }
        return user;
    }
}
