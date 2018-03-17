package com.atlyakov.vshop.service.model;

import java.math.BigDecimal;

public class BasketDTO {

    private Integer basketId;
    private Integer quantity;
    private Integer goodsId;
    private String name;
    private String article;
    private BigDecimal price;
    private BigDecimal allPrice;

    public Integer getBasketId() {
        return basketId;
    }

    public void setBasketId(Integer basketId) {
        this.basketId = basketId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAllPrice() { return allPrice; }

    public void setAllPrice(BigDecimal allPrice) { this.allPrice = allPrice;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasketDTO basketDTO = (BasketDTO) o;

        if (basketId != null ? !basketId.equals(basketDTO.basketId) : basketDTO.basketId != null) return false;
        if (name != null ? !name.equals(basketDTO.name) : basketDTO.name != null) return false;
        if (article != null ? !article.equals(basketDTO.article) : basketDTO.article != null) return false;
        return price != null ? price.equals(basketDTO.price) : basketDTO.price == null;
    }

    @Override
    public int hashCode() {
        int result = basketId != null ? basketId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (article != null ? article.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
