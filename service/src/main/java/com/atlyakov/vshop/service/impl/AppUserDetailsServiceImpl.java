package com.atlyakov.vshop.service.impl;

import com.atlyakov.vshop.dao.IUserDao;
import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.User;
import com.atlyakov.vshop.service.model.AppUserPrincipal;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "appUserDetailsService")
public class AppUserDetailsServiceImpl implements UserDetailsService {
    private static final Logger LOGGER = Logger.getLogger(AppUserDetailsServiceImpl.class);
    private final IUserDao userDao;

    @Autowired
    public AppUserDetailsServiceImpl(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userDao.getUserByUserName(username);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method loadUserByUserName");
        }
        if (user == null) {
            LOGGER.error("User not exist");
            throw new UsernameNotFoundException(username);
        }
        return new AppUserPrincipal(user);
    }

}
