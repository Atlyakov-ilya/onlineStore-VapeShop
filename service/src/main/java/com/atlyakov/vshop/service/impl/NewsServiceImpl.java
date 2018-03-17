package com.atlyakov.vshop.service.impl;

import com.atlyakov.vshop.dao.INewsDao;
import com.atlyakov.vshop.dao.IUserDao;
import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.News;
import com.atlyakov.vshop.entity.NewsFileEntity;
import com.atlyakov.vshop.entity.User;
import com.atlyakov.vshop.service.INewsService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.AppUserPrincipal;
import com.atlyakov.vshop.service.model.NewsDTO;
import com.atlyakov.vshop.service.util.NewsConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

@Service
public class NewsServiceImpl implements INewsService {
    private static final Logger LOGGER = Logger.getLogger(NewsServiceImpl.class);
    private INewsDao newsDao;

    private IUserDao userDao;

    private Properties properties;

    @Autowired
    public NewsServiceImpl(INewsDao newsDao, IUserDao userDao, Properties properties) {
        this.newsDao = newsDao;
        this.userDao = userDao;
        this.properties = properties;
    }

    @Override
    @Transactional
    public void saveNews(NewsDTO newsDTO) throws ServiceException {
        News news = NewsConverter.converter(newsDTO);
        try {
            NewsFileEntity newsFileEntity = getFileEntity(newsDTO);
            news.setNewsFileEntity(newsFileEntity);
            User user = getUser();
            news.setUser(user);
            try {
                newsDao.save(news);
            } catch (DaoException e) {
                LOGGER.error("Exception during implementation of method saveNews");
                throw new ServiceException(e);
            }
        } catch (IOException e) {
            LOGGER.error("Exception during implementation of method saveNews");
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional
    public List<NewsDTO> getAll() throws ServiceException {
        List<News> news;
        try {
            news = newsDao.getAll();
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getAll");
            throw new ServiceException(e);
        }
        List<NewsDTO> newsDTOList = new ArrayList<>();
        for (News news1 : news) {
            newsDTOList.add(NewsConverter.converter(news1));
        }
        Collections.sort(newsDTOList);
        return newsDTOList;

    }

    @Override
    @Transactional
    public NewsDTO getNewsById(Integer newsId) throws ServiceException {
        News news;
        try {
            news = newsDao.getById(newsId);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getNewsById");
            throw new ServiceException(e);
        }
        return NewsConverter.converter(news);
    }

    @Override
    @Transactional
    public void removeNews(Integer newsId) throws ServiceException {
        try {
            newsDao.delete(newsId);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method removeNews");
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional
    public void editNews(NewsDTO newsDTO) throws ServiceException {
        News news = NewsConverter.converter(newsDTO);
        news.setUser(getUser());
        try {
            newsDao.update(news);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method editNews");
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

    private NewsFileEntity getFileEntity(NewsDTO newsDTO) throws IOException {
        String fileLocation = properties.getProperty("upload.news.location") + System.currentTimeMillis() + ".jpg";
        FileCopyUtils.copy(newsDTO.getFile().getBytes(), new File(fileLocation));
        NewsFileEntity newsFileEntity = new NewsFileEntity();
        newsFileEntity.setLocation(fileLocation);
        newsFileEntity.setFileName(newsDTO.getFile().getName());
        return newsFileEntity;
    }

}
