package com.atlyakov.vshop.service.util;

import com.atlyakov.vshop.entity.Goods;
import com.atlyakov.vshop.entity.enums.Category;
import com.atlyakov.vshop.service.model.GoodsDTO;

public class GoodsConverter {

    public static Goods convert(GoodsDTO goodsDTO) {
        Goods goods = new Goods();
        goods.setGoodsId(goodsDTO.getGoodsId());
        goods.setName(goodsDTO.getName());
        goods.setArticle(goodsDTO.getArticle());
        goods.setPrice(goodsDTO.getPrice());
        goods.setDescription(goodsDTO.getDescription());
        goods.setCategory(Category.valueOf(goodsDTO.getCategory()));
        return goods;
    }

    public static GoodsDTO convert(Goods goods) {
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setGoodsId(goods.getGoodsId());
        goodsDTO.setName(goods.getName());
        goodsDTO.setArticle(goods.getArticle());
        goodsDTO.setDescription(goods.getDescription());
        goodsDTO.setPrice(goods.getPrice());
        goodsDTO.setCategory(goods.getCategory().name());
        return goodsDTO;
    }
}
