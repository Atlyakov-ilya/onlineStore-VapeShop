package com.atlyakov.vshop.service.impl;

import com.atlyakov.vshop.dao.IUserDao;
import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.User;
import com.atlyakov.vshop.service.IUserService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.AppUserPrincipal;
import com.atlyakov.vshop.service.model.UserDTO;
import com.atlyakov.vshop.service.util.UserConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    private final IUserDao userDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(IUserDao userDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public void registration(UserDTO userDTO) throws ServiceException {
        User user = UserConverter.convert(userDTO);
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        try {
            userDao.save(user);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method delete");
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional
    public List<UserDTO> getAll() throws ServiceException {
        List<User> users;
        try {
            users = userDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        List<UserDTO> userDTOList = new ArrayList<>();
        users.forEach(user -> userDTOList.add(UserConverter.convert(user)));
        return userDTOList;
    }

    @Override
    @Transactional
    public void removeUser(Integer userId) throws ServiceException {
        try {
            userDao.delete(userId);
            LOGGER.info("User deletion successful");
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method removeUser");
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional
    public UserDTO getUserById(Integer userId) throws ServiceException {
        User user;
        try {
            user = userDao.getById(userId);
            LOGGER.info("Getting the user on the ide was successful");
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getUserById");
            throw new ServiceException(e);
        }
        return UserConverter.convert(user);
    }

    @Override
    @Transactional
    public void update(UserDTO userDTO) throws ServiceException {
        User user = UserConverter.convert(userDTO);
        if (user.getPassword() != null && user.getPassword()
                .matches("(?=^.{6,20}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$")) {
            user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        }
        try {
            userDao.update(user);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method update");
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional
    public UserDTO getCurrentUser() throws ServiceException {
        return UserConverter.convert(getUser());
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
