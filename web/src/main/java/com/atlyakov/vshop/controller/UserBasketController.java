package com.atlyakov.vshop.controller;

import com.atlyakov.vshop.controller.exception.ExceptionController;
import com.atlyakov.vshop.service.IBasketService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.BasketDTO;
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
public class UserBasketController {
    private static final Logger LOGGER = Logger.getLogger(UserBasketController.class);

    private IBasketService basketService;

    @Autowired
    public UserBasketController(IBasketService basketService) {
        this.basketService = basketService;
    }

    @RequestMapping(value = "/basket/{goodsId}", method = RequestMethod.GET)
    public String addGoodsToBasketAndShowAllGoodsInBasket(@PathVariable("goodsId") Integer goodsId) {
        try {
            basketService.addGoodsToBasket(goodsId);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        return "redirect:/user/basket";
    }

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String ShowAllGoodsInBasket(Model model) {
        Set<BasketDTO> basketList;
        BigDecimal allPrice;
        try {
            basketList = basketService.getAllGoodsInBasket();
            if(basketList != null){
                allPrice = basketService.getAllPrice();
                model.addAttribute("allPrice", allPrice);
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("basketList", basketList);
        return "user/basket";
    }

    @RequestMapping(value = "/basket/removeGoodsInBasket/{goodsArticle}")
    public String RemoveGoodsInBasket(@PathVariable("goodsArticle") String goodsArticle) {
        try {
            basketService.removeGoodsInBasket(goodsArticle);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        return "redirect:/user/basket";
    }
}