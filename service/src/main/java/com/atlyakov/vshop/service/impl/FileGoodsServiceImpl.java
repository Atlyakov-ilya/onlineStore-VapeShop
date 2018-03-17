package com.atlyakov.vshop.service.impl;

import com.atlyakov.vshop.dao.IGoodsFileDao;
import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.GoodsFileEntity;
import com.atlyakov.vshop.service.IGoodsFileService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

@Service
public class FileGoodsServiceImpl implements IGoodsFileService {
    private static final Logger LOGGER = Logger.getLogger(FileGoodsServiceImpl.class);

    private IGoodsFileDao goodsFileDao;
    @Autowired
    public FileGoodsServiceImpl(IGoodsFileDao goodsFileDao) {
        this.goodsFileDao = goodsFileDao;
    }

    @Override
    @Transactional
    public File getGoodsFileById(Integer goodsId) {
        GoodsFileEntity fileEntity = null;
        try {
            fileEntity = goodsFileDao.getById(Math.toIntExact(goodsId));
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getGoodsFileById");
        }
        return new File(fileEntity.getLocation());
    }
}
