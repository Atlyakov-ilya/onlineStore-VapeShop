package com.atlyakov.vshop.controller;

import com.atlyakov.vshop.controller.exception.ExceptionController;
import com.atlyakov.vshop.service.IGoodsService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.GoodsDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserGoodsController {
    private static final Logger LOGGER = Logger.getLogger(UserGoodsController.class);

    private IGoodsService goodsService;

    @Autowired
    public UserGoodsController(IGoodsService goodsService) {
        this.goodsService = goodsService;
    }


    @RequestMapping(value = "/show_goods/{pageId}", method = RequestMethod.GET)
    public String getAllGoods(@PathVariable("pageId") Integer pageId, Model model) {
        List<GoodsDTO> goods;
        try {
            goods = goodsService.getAllGoods(pageId);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("goods", goods);
        return "user/show_goods";
    }

    @RequestMapping(value = "show_one_item/{goodsId}", method = RequestMethod.GET)
    public String showOneItem(@PathVariable("goodsId") Integer goodsId, Model model) {
        GoodsDTO goods;
        try {
            goods = goodsService.getGoodsById(goodsId);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("goods", goods);
        return "/user/show_one_item";
    }

    @RequestMapping(value = "/categoryChoice/{category}/{pageId}", method = RequestMethod.GET)
    public String getAllGoodsByCategory(@PathVariable("category") String category,
                                        @PathVariable("pageId") Integer pageId, Model model) {
        List<GoodsDTO> goodsList;
        try {
            goodsList = goodsService.getGoodsByCategoryWithPaginate(category, pageId);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("goods", goodsList);

        return "user/show_goods";
    }

    @RequestMapping(value = "/show_goods_accumulator", method = RequestMethod.GET)
    public String getAllAccumulator(Model model) {
        List<GoodsDTO> goodsList;

        try {
            goodsList = goodsService.getAllAccumulator();
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("goods", goodsList);
        return "user/show_goods_accumulator";
    }

    @RequestMapping(value = "/show_goods_liquid", method = RequestMethod.GET)
    public String getAllLiguid(Model model) {
        List<GoodsDTO> goodsList;

        try {
            goodsList = goodsService.getAllLiquid();
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("goods", goodsList);
        return "user/show_goods_liquid";
    }


    @RequestMapping(value = "/show_goods_atomizer", method = RequestMethod.GET)
    public String getAllAtomizer(Model model) {
        List<GoodsDTO> goodsList;

        try {
            goodsList = goodsService.getAllAtomizer();
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("goods", goodsList);
        return "user/show_goods_atomizer";
    }

    @RequestMapping(value = "/show_goods_components", method = RequestMethod.GET)
    public String getAllComponents(Model model) {
        List<GoodsDTO> goodsList;

        try {
            goodsList = goodsService.getAllComponents();
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("goods", goodsList);
        return "user/show_goods_components";
    }

}