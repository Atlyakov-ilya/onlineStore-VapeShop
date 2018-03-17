package com.atlyakov.vshop.controller;

import com.atlyakov.vshop.service.IAddressService;
import com.atlyakov.vshop.service.IBasketService;
import com.atlyakov.vshop.service.IOrderService;
import com.atlyakov.vshop.service.IUserService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.AddressDTO;
import com.atlyakov.vshop.service.model.BasketDTO;
import com.atlyakov.vshop.service.model.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.Set;

@Controller
@RequestMapping(value = "/user")
public class UserOrderController {
    private static final Logger LOGGER = Logger.getLogger(UserOrderController.class);

    private IOrderService orderService;
    private IAddressService addressService;
    private IBasketService basketService;
    private IUserService userService;

    @Autowired
    public UserOrderController(IOrderService orderService, IBasketService basketService,
                               IAddressService addressService, IUserService userService) {
        this.orderService = orderService;
        this.basketService = basketService;
        this.addressService = addressService;
        this.userService = userService;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String order(Model model) {
        AddressDTO address;
        UserDTO user;
        Set<BasketDTO> basketList;
        BigDecimal allPrice;
        try {
            address = addressService.getAddressByUserId();
            user = userService.getCurrentUser();
            if (address == null) {
                model.addAttribute("user", user);
                return "user/profile";
            }
            basketList = basketService.getAllGoodsInBasket();
            if (basketList != null) {
                allPrice = basketService.getAllPrice();
                model.addAttribute("allPrice", allPrice);
            }
            model.addAttribute("basketList", basketList);
            model.addAttribute("address", address);
            model.addAttribute("user", user);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        return "/user/check_order";
    }

    @RequestMapping(value = "/addOrder/{price}", method = RequestMethod.GET)
    public String addOrder(@PathVariable("price") BigDecimal price) throws ServiceException {
        try {
            orderService.addToOrder(price);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        return "user/main";
    }
}
