package com.atlyakov.vshop.service;

import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.AddressDTO;
import com.atlyakov.vshop.service.model.GoodsDTO;
import com.atlyakov.vshop.service.model.OrderDTO;
import com.atlyakov.vshop.service.model.UserDTO;

import java.math.BigDecimal;
import java.util.List;

/**
 * This interface contains methods for data conversion and sending data to other layer.
 * Provides performance of the main application logic.
 * All methods are associated with different entity.
 */
public interface IOrderService {

   void addToOrder(BigDecimal allPrice) throws ServiceException;

   List<OrderDTO> showAllOrders() throws ServiceException;

   OrderDTO getOrderById(Integer orderId) throws ServiceException;

   List<GoodsDTO> getAllGoodsInOrder(Integer orderId) throws ServiceException;

   BigDecimal getPriseForAll(List<GoodsDTO> goodsList) throws ServiceException;

   UserDTO getUserByOrderId(Integer orderId) throws ServiceException;

   AddressDTO getAddressByUser(UserDTO user) throws ServiceException;

   void changeStatus(OrderDTO order) throws ServiceException;

}
