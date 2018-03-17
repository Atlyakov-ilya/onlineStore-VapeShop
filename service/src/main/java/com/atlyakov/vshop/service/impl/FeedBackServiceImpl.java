package com.atlyakov.vshop.service.impl;

import com.atlyakov.vshop.dao.IFeedBackDao;
import com.atlyakov.vshop.dao.IUserDao;
import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.FeedBack;
import com.atlyakov.vshop.entity.User;
import com.atlyakov.vshop.service.IFeedBackService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.AppUserPrincipal;
import com.atlyakov.vshop.service.model.FeedBackDTO;
import com.atlyakov.vshop.service.util.FeedBackConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedBackServiceImpl implements IFeedBackService {
    private static final Logger LOGGER = Logger.getLogger(FeedBackServiceImpl.class);

    private IFeedBackDao feedBackDao;
    private IUserDao userDao;

    @Autowired
    public FeedBackServiceImpl(IFeedBackDao feedBackDao, IUserDao userDao) {
        this.feedBackDao = feedBackDao;
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addMessage(FeedBackDTO feedBackDTO) throws ServiceException {
        FeedBack feedBack = FeedBackConverter.convert(feedBackDTO);
        User user = getUser();
        feedBack.setUser(user);
        feedBack.setUserName(user.getUsername());
        try {
            feedBackDao.save(feedBack);
        } catch (DaoException e) {
            LOGGER.error("Service Exception during implementation of method save");
            throw new ServiceException(e);
        }

    }

    @Override
    @Transactional
    public List<FeedBackDTO> getAllMessage(Integer pageId) throws ServiceException {
        List<FeedBack> messages;
        int countPage = 4;
        if (pageId == 1) {
            try {
                pageId = 0;
                messages = feedBackDao.getAllUserMessage(pageId, countPage);
            } catch (DaoException e) {
                LOGGER.error("Service Exception during implementation of method getAllUserMessage");
                throw new ServiceException(e);
            }
        } else {
            try {
                pageId = (pageId - 1) * countPage;
                messages = feedBackDao.getAllUserMessage(pageId, countPage);
            } catch (DaoException e) {
                LOGGER.error("Service Exception during implementation of method getAllUserMessage");
                throw new ServiceException(e);
            }
        }
        List<FeedBackDTO> messagesDTO = new ArrayList<>();
        for (FeedBack messagesConvert : messages) {
            messagesDTO.add(FeedBackConverter.convert(messagesConvert));
        }
        return messagesDTO;
    }

    @Override
    @Transactional
    public void removeFeedBack(Integer feedBackId) throws ServiceException {
        try {
            feedBackDao.delete(feedBackId);
        } catch (DaoException e) {
            LOGGER.error("Service Exception during implementation of method removeFeedBack");
            throw new ServiceException(e);
        }
    }

    private User getUser() {
        AppUserPrincipal principal = (AppUserPrincipal) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User user = null;
        try {
            user = userDao.getById(principal.getUserId());
        } catch (DaoException e) {
            LOGGER.error("Service Exception during implementation of method getById");
        }
        return user;
    }


}
