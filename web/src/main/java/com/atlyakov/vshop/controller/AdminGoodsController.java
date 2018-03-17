package com.atlyakov.vshop.controller;

import com.atlyakov.vshop.controller.exception.ExceptionController;
import com.atlyakov.vshop.service.IGoodsService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.GoodsDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminGoodsController {
    private static final Logger LOGGER = Logger.getLogger(AdminGoodsController.class);

    private IGoodsService goodsService;

    @Autowired
    public AdminGoodsController(IGoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping(value = "/add_goods", method = RequestMethod.GET)
    public String showAddGoodsPage(@ModelAttribute("goodsDTO") GoodsDTO goodsDTO) {
        return "admin/add_goods";
    }

    @RequestMapping(value = "/admin/add_goods", method = RequestMethod.POST)
    public String saveGoods(@Valid @ModelAttribute("goodsDTO") GoodsDTO goodsDTO,
                            BindingResult result, Model model) {
        if (!result.hasErrors()) {
            try {
                goodsService.addGoods(goodsDTO);
            } catch (ServiceException e) {
                LOGGER.error(e);
            }
            model.addAttribute("message", "Goods successfully added");
            return "admin/add_goods";
        } else {
            return "admin/add_goods";
        }
    }

    @RequestMapping(value = "/show_all_goods", method = RequestMethod.GET)
    public String showAllGoods(Model model) {
        List<GoodsDTO> goodsList;
        try {
            goodsList = goodsService.getAllGoodsForAdmin();
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("goodsList", goodsList);
        return "admin/show_all_goods";
    }

    @RequestMapping(value = "/show_all_goods/removeGoods/{goodsId}")
    public String removeGoods(@PathVariable("goodsId") Integer goodsId) {
        try {
            goodsService.removeGoods(goodsId);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        return "redirect:/admin/show_all_goods";
    }

    @RequestMapping(value = "show_goods_details/{goodsId}", method = RequestMethod.GET)
    public String showOneNews(@PathVariable("goodsId") Integer goodsId, Model model) {
        GoodsDTO goods;
        try {
            goods = goodsService.getGoodsById(goodsId);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("goods", goods);
        return "admin/goods_details";
    }

    @RequestMapping(value = "/editGoods/{goodsId}", method = RequestMethod.GET)
    public String editGoods(@PathVariable("goodsId") Integer goodsId, Model model) {
        GoodsDTO goods;
        try {
            goods = goodsService.getGoodsById(goodsId);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("goodsEdit", goods);
        model.addAttribute("goods", goods);
        return "admin/goods_details";
    }


    @RequestMapping(value = "/editGoods/add", method = RequestMethod.GET)
    public String addEditGoods(@Valid @ModelAttribute("goodsDTO") GoodsDTO goodsDTO, BindingResult result,
                               Model model) {
        List<GoodsDTO> goodsList;
        GoodsDTO goods;
        if (!result.hasErrors()) {
            try {
                goodsService.editGoods(goodsDTO);
                goodsList = goodsService.getAllGoodsForAdmin();
            } catch (ServiceException e) {
                LOGGER.error(e);
                throw new RuntimeException();
            }
            model.addAttribute("goodsList", goodsList);
            return "admin/show_all_goods";
        }
        try {
            goods = goodsService.getGoodsById(goodsDTO.getGoodsId());
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("goods", goods);
        return "admin/goods_details";
    }
}
