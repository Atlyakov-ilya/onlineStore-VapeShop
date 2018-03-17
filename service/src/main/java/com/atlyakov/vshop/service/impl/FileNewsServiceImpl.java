package com.atlyakov.vshop.service.impl;

import com.atlyakov.vshop.dao.INewsFileDao;
import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.NewsFileEntity;
import com.atlyakov.vshop.service.INewsFileService;
import com.atlyakov.vshop.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

@Service
public class FileNewsServiceImpl implements INewsFileService {
    private static final Logger LOGGER = Logger.getLogger(FileNewsServiceImpl.class);
    @Autowired
    private INewsFileDao fileDao;

    @Override
    @Transactional
    public File getNewsFileById(Integer id) throws ServiceException {
        NewsFileEntity fileEntity;
        try {
            fileEntity = fileDao.getById(Math.toIntExact(id));
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getNewsFileById");
            throw new ServiceException(e);
        }
        return new File(fileEntity.getLocation());
    }
}
