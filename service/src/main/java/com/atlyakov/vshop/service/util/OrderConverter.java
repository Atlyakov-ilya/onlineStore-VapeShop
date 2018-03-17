package com.atlyakov.vshop.service.util;

import com.atlyakov.vshop.entity.Orders;
import com.atlyakov.vshop.service.model.OrderDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderConverter {

  private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static Orders convert(OrderDTO orderDTO){
        Orders orders = new Orders();
        orders.setOrderId(orderDTO.getOrderId());
        orders.setStatus(orderDTO.getStatus());
        orders.setTotalPrice(orderDTO.getTotalPrice());
        try {
            orders.setDate(formatter.parse(orderDTO.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return orders;
    }


    public static OrderDTO convert(Orders order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setTotalPrice(order.getTotalPrice());
        orderDTO.setDate(order.getDate().toString());
        orderDTO.setUserId(order.getUser().getUserId());
        return orderDTO;
    }
}
