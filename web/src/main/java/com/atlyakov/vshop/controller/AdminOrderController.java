package com.atlyakov.vshop.controller;

import com.atlyakov.vshop.controller.exception.ExceptionController;
import com.atlyakov.vshop.service.IOrderService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.AddressDTO;
import com.atlyakov.vshop.service.model.GoodsDTO;
import com.atlyakov.vshop.service.model.OrderDTO;
import com.atlyakov.vshop.service.model.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminOrderController {
    private static final Logger LOGGER = Logger.getLogger(AdminOrderController.class);

    private IOrderService orderService;

    @Autowired
    public AdminOrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/show_all_orders", method = RequestMethod.GET)
    public String showAllOrders(Model model){
        List<OrderDTO> ordersList;
        try {
            ordersList = orderService.showAllOrders();
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("orders", ordersList);
        return "admin/show_all_orders";
    }

    @RequestMapping(value = "/order_details/{orderId}", method = RequestMethod.GET)
    public String orderDetails(@PathVariable("orderId") Integer orderId, ModelMap model){
         OrderDTO orderDTO;
         List<GoodsDTO> goodsList;
         BigDecimal allPrice;
         UserDTO user;
         AddressDTO address;
        try {
            orderDTO = orderService.getOrderById(orderId);
            goodsList= orderService.getAllGoodsInOrder(orderId);
            allPrice=orderService.getPriseForAll(goodsList);
            user=orderService.getUserByOrderId(orderId);
            address = orderService.getAddressByUser(user);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("order", orderDTO);
        model.addAttribute("goodsList", goodsList);
        model.addAttribute("allPrice",allPrice);
        model.addAttribute("user", user);
        model.addAttribute("address",address);
        return "admin/order_details";
    }

    @RequestMapping(value = "/order_details/changeStatus", method = RequestMethod.POST)
    public String changeStatus(@ModelAttribute("order") OrderDTO order, Model model){
        List<OrderDTO> ordersList;
        try {
            orderService.changeStatus(order);
            ordersList = orderService.showAllOrders();
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("orders", ordersList);
        return "admin/show_all_orders";
    }
}
