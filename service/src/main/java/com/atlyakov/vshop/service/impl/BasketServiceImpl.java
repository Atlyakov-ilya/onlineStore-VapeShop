package com.atlyakov.vshop.service.impl;

import com.atlyakov.vshop.dao.IBasketDao;
import com.atlyakov.vshop.dao.IGoodsDao;
import com.atlyakov.vshop.dao.IUserDao;
import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.Basket;
import com.atlyakov.vshop.entity.Goods;
import com.atlyakov.vshop.entity.User;
import com.atlyakov.vshop.service.IBasketService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.AppUserPrincipal;
import com.atlyakov.vshop.service.model.BasketDTO;
import com.atlyakov.vshop.service.util.BasketConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BasketServiceImpl implements IBasketService {
    private static final Logger LOGGER = Logger.getLogger(BasketServiceImpl.class);

    private final IGoodsDao goodsDao;
    private final IBasketDao basketDao;
    private final IUserDao userDao;


    @Autowired
    public BasketServiceImpl(IBasketDao basketDao, IGoodsDao goodsDao, IUserDao userDao) {
        this.basketDao = basketDao;
        this.goodsDao = goodsDao;
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addGoodsToBasket(Integer id) throws ServiceException {
        Basket basket = new Basket();
        try {
            Goods goods = goodsDao.getGoodsById(id);
            User user = getUser();
            basket.setGoods(goods);
            basket.setUser(user);
            basketDao.save(basket);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method addGoodsToBasket");
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional
    public Set<BasketDTO> getAllGoodsInBasket() throws ServiceException {
        List<Goods> basketList;
        try {
            basketList = basketDao.getAllGoodsInBasketByUserId(getUser());
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getAllGoodsInBasket");
            throw new ServiceException(e);
        }
        Set<BasketDTO> basketListDTO = new HashSet<>();
        for (Goods goods : basketList) {
            basketListDTO.add(BasketConverter.convert(goods));
        }
        return basketListDTO;
    }

    @Override
    @Transactional
    public void removeGoodsInBasket(String article) throws ServiceException {
        try {
            Goods goods = basketDao.getGoodsInBasketByArticle(article);
            Integer basketId = basketDao.deleteGoodsFromBasket(goods).getBasketId();
            basketDao.delete(basketId);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method removeGoodsInBasket");
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional
    public BigDecimal getAllPrice() throws ServiceException {
        try {
            return basketDao.getAllPrice(getUser());
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getAllPrice");
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
