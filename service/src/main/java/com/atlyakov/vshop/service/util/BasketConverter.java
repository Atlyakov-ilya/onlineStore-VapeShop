package com.atlyakov.vshop.service.util;

import com.atlyakov.vshop.entity.Goods;
import com.atlyakov.vshop.service.model.BasketDTO;

public class BasketConverter {

    public static BasketDTO convert(Goods goods) {
        BasketDTO basketDTO = new BasketDTO();
        basketDTO.setGoodsId(goods.getGoodsId());
        basketDTO.setArticle(goods.getArticle());
        basketDTO.setName(goods.getName());
        basketDTO.setPrice(goods.getPrice());
        return basketDTO;
    }
}
