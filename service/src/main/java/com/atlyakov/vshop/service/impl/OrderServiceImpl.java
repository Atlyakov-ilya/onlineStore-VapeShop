package com.atlyakov.vshop.service.impl;

import com.atlyakov.vshop.dao.IAddressDao;
import com.atlyakov.vshop.dao.IBasketDao;
import com.atlyakov.vshop.dao.IOrderDao;
import com.atlyakov.vshop.dao.IUserDao;
import com.atlyakov.vshop.dao.exception.DaoException;
import com.atlyakov.vshop.entity.Address;
import com.atlyakov.vshop.entity.Goods;
import com.atlyakov.vshop.entity.Orders;
import com.atlyakov.vshop.entity.User;
import com.atlyakov.vshop.entity.enums.Status;
import com.atlyakov.vshop.service.IOrderService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.*;
import com.atlyakov.vshop.service.util.AddressConverter;
import com.atlyakov.vshop.service.util.GoodsConverter;
import com.atlyakov.vshop.service.util.OrderConverter;
import com.atlyakov.vshop.service.util.UserConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    private static final Logger LOGGER = Logger.getLogger(FeedBackServiceImpl.class);

    private IOrderDao orderDao;
    private IBasketDao basketDao;
    private IUserDao userDao;
    private IAddressDao addressDao;

    @Autowired
    public OrderServiceImpl(IOrderDao orderDao, IUserDao userDao,
                            IBasketDao basketDao, IAddressDao addressDao) {
        this.orderDao = orderDao;
        this.userDao = userDao;
        this.basketDao = basketDao;
        this.addressDao = addressDao;
    }


    @Override
    @Transactional
    public void addToOrder(BigDecimal totalPrice) throws ServiceException {
        Orders order = new Orders();
        order.setUser(getUser());
        order.setDate(new Date());
        order.setStatus(Status.NEW);
        order.setTotalPrice(totalPrice);
        try {
            orderDao.save(order);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method save");
            throw new ServiceException(e);
        }
        try {
            order = orderDao.findLastOrderByUserId(getUser());
            basketDao.addOrderToTheBasket(order, getUser());
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method findLastOrderByUserId");
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional
    public List<OrderDTO> showAllOrders() throws ServiceException {
        List<Orders> orders;
        try {
            orders = orderDao.getAll();
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method showAllOrders");
            throw new ServiceException(e);
        }
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Orders order : orders) {
            orderDTOList.add(OrderConverter.convert(order));
            for (OrderDTO orderDTO : orderDTOList) {
                try {
                    User user = userDao.getById(order.getUser().getUserId());
                    orderDTO.setUserName(user.getUsername());
                } catch (DaoException e) {
                    LOGGER.error("Exception during implementation of method getUserById");
                    throw new ServiceException(e);
                }
            }
        }
        return orderDTOList;
    }

    @Override
    @Transactional
    public OrderDTO getOrderById(Integer orderId) throws ServiceException {
        Orders order;
        try {
            order = orderDao.getById(orderId);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getOrderById");
            throw new ServiceException(e);
        }
        OrderDTO orderDTO = OrderConverter.convert(order);
        orderDTO.setUserName(order.getUser().getUsername());
        return orderDTO;
    }

    @Override
    @Transactional
    public List<GoodsDTO> getAllGoodsInOrder(Integer orderId) throws ServiceException {
        List<Goods> goods;
        try {
            goods = orderDao.getAllGoodsInOrder(orderId);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method  getAllGoodsInOrder");
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
    public BigDecimal getPriseForAll(List<GoodsDTO> goodsList) throws ServiceException {
        BigDecimal allPrice = new BigDecimal(0.00);
        for (GoodsDTO goodsDTO : goodsList) {
            allPrice = allPrice.add(goodsDTO.getPrice());
        }
        return allPrice;
    }

    @Override
    @Transactional
    public UserDTO getUserByOrderId(Integer orderId) throws ServiceException {
        Orders order;
        try {
            order = orderDao.getById(orderId);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getOrderById");
            throw new ServiceException(e);
        }
        return UserConverter.convert(order.getUser());
    }

    @Override
    @Transactional
    public AddressDTO getAddressByUser(UserDTO user) throws ServiceException {
        Address address;
        try {
            address = addressDao.getById(user.getUserId());
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getAddressByUser");
            throw new ServiceException(e);
        }

        return AddressConverter.convert(address);
    }

    @Override
    @Transactional
    public void changeStatus(OrderDTO orderDTO) throws ServiceException {
        Orders order = OrderConverter.convert(orderDTO);
        User user;
        try {
            user = userDao.getById(orderDTO.getUserId());
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method getById");
            throw new ServiceException(e);
        }
        order.setUser(user);
        try {
            orderDao.update(order);
        } catch (DaoException e) {
            LOGGER.error("Exception during implementation of method changeStatus");
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
