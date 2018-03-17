package com.atlyakov.vshop.service.impl;

import com.atlyakov.vshop.dao.IGoodsDao;
import com.atlyakov.vshop.dao.IUserDao;
import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.Goods;
import com.atlyakov.vshop.entity.GoodsFileEntity;
import com.atlyakov.vshop.entity.User;
import com.atlyakov.vshop.entity.enums.Category;
import com.atlyakov.vshop.service.IGoodsService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.AppUserPrincipal;
import com.atlyakov.vshop.service.model.GoodsDTO;
import com.atlyakov.vshop.service.util.GoodsConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class GoodsServiceImpl implements IGoodsService {
    private static final Logger LOGGER = Logger.getLogger(GoodsServiceImpl.class);

    private IGoodsDao goodsDao;
    private IUserDao userDao;
    private Properties properties;

    @Autowired
    public GoodsServiceImpl(IGoodsDao goodsDao, IUserDao userDao, Properties properties) {
        this.goodsDao = goodsDao;
        this.userDao = userDao;
        this.properties = properties;
    }

    @Override
    @Transactional
    public void addGoods(GoodsDTO goodsDTO) throws ServiceException {
        Goods goods = GoodsConverter.convert(goodsDTO);
        try {
            GoodsFileEntity goodsFileEntity = getFileEntity(goodsDTO);
            goods.setGoodsFileEntity(goodsFileEntity);
            User user = getUser();
            goods.setUser(user);
            goodsDao.save(goods);
        } catch (IOException | DaoException e) {
            LOGGER.error("Exception during implementation of method addGoods");
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional
    public List<GoodsDTO> getAllGoods(Integer pageId) throws ServiceException {
        List<Goods> goods;
        int countPage = 6;
        if (pageId == 1) {
            try {
                pageId = 0;
                goods = goodsDao.getAllGoods(pageId, countPage);
            } catch (DaoException e) {
                LOGGER.error("Service Exception during implementation of method getAllGoods");
                throw new ServiceException(e);
            }
        } else {
            try {
                pageId = (pageId - 1) * countPage;
                goods = goodsDao.getAllGoods(pageId, countPage);
            } catch (DaoException e) {
                LOGGER.error("Service Exception during implementation of method getAllGoods");
                throw new ServiceException(e);
            }
        }

        List<GoodsDTO> goodsDTOList = new ArrayList<>();
        for (Goods goods1 : goods) {
            goodsDTOList.add(GoodsConverter.convert(goods1));
        }
        return goodsDTOList;
    }


    @Override
    @Transactional
    public List<GoodsDTO> getGoodsByCategoryWithPaginate(String category, Integer pageId) throws ServiceException {
        List<Goods> goods;
        try {
            goods = goodsDao.getAllGoodsByCategory(Category.valueOf(category));
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method  getAllGoodsByCategory");
            throw new ServiceException(e);
        }
        List<GoodsDTO> goodsDTOList = new ArrayList<>();
        for (Goods goodsDTO : goods) {
            goodsDTOList.add(GoodsConverter.convert(goodsDTO));
        }
        return goodsDTOList;
    }

    @Override
    @Transactional
    public GoodsDTO getGoodsById(Integer goodsId) throws ServiceException {
        Goods goods;
        try {
            goods = goodsDao.getGoodsById(goodsId);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method  getGoodsById");
            throw new ServiceException(e);
        }
        return GoodsConverter.convert(goods);
    }

    @Override
    @Transactional
    public void removeGoods(Integer goodsId) throws ServiceException {
        try {
            goodsDao.delete(goodsId);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method removeGoods");
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional
    public List<GoodsDTO> getAllAccumulator() throws ServiceException {
        List<Goods> goods;
        try {
            goods = goodsDao.getAllGoodsByCategory(Category.ACCUMULATOR);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getAllAccumulator");
            throw new ServiceException(e);
        }
        List<GoodsDTO> goodsDTOList = new ArrayList<>();
        for (Goods goodsDTO : goods) {
            goodsDTOList.add(GoodsConverter.convert(goodsDTO));
        }
        return goodsDTOList;
    }

    @Override
    @Transactional
    public List<GoodsDTO> getAllLiquid() throws ServiceException {
        List<Goods> goods;
        try {
            goods = goodsDao.getAllGoodsByCategory(Category.LIQUID);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getAllAccumulator");
            throw new ServiceException(e);
        }
        List<GoodsDTO> goodsDTOList = new ArrayList<>();
        for (Goods goodsDTO : goods) {
            goodsDTOList.add(GoodsConverter.convert(goodsDTO));
        }
        return goodsDTOList;
    }

    @Override
    @Transactional
    public List<GoodsDTO> getAllAtomizer() throws ServiceException {
        List<Goods> goods;
        try {
            goods = goodsDao.getAllGoodsByCategory(Category.ATOMIZER);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getAllAccumulator");
            throw new ServiceException(e);
        }
        List<GoodsDTO> goodsDTOList = new ArrayList<>();
        for (Goods goodsDTO : goods) {
            goodsDTOList.add(GoodsConverter.convert(goodsDTO));
        }
        return goodsDTOList;
    }

    @Override
    @Transactional
    public List<GoodsDTO> getAllComponents() throws ServiceException {
        List<Goods> goods;
        try {
            goods = goodsDao.getAllGoodsByCategory(Category.COMPONENTS);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getAllAccumulator");
            throw new ServiceException(e);
        }
        List<GoodsDTO> goodsDTOList = new ArrayList<>();
        for (Goods goodsDTO : goods) {
            goodsDTOList.add(GoodsConverter.convert(goodsDTO));
        }
        return goodsDTOList;
    }

    @Override
    @Transactional
    public List<GoodsDTO> getAllGoodsForAdmin() throws ServiceException {
        List<Goods> goods;
        try {
            goods = goodsDao.getAll();
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getAllGoodsForAdmin");
            throw new ServiceException(e);
        }
        List<GoodsDTO> goodsDTOList = new ArrayList<>();
        for (Goods goodsDTO : goods) {
            goodsDTOList.add(GoodsConverter.convert(goodsDTO));
        }
        return goodsDTOList;
    }

    @Override
    @Transactional
    public void editGoods(GoodsDTO goodsDTO) throws ServiceException {
        Goods goods = GoodsConverter.convert(goodsDTO);
        goods.setUser(getUser());
        try {
            goodsDao.update(goods);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method editGoods");
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

    private GoodsFileEntity getFileEntity(GoodsDTO goodsDTO) throws IOException {
        String fileLocation = properties.getProperty("upload.goods.location") + System.currentTimeMillis() + ".jpg";
        FileCopyUtils.copy(goodsDTO.getFile().getBytes(), new File(fileLocation));
        GoodsFileEntity goodsFileEntity = new GoodsFileEntity();
        goodsFileEntity.setLocation(fileLocation);
        goodsFileEntity.setFileName(goodsDTO.getFile().getName());
        return goodsFileEntity;
    }
}
