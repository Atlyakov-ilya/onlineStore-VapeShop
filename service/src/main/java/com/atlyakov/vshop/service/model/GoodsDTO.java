package com.atlyakov.vshop.service.model;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public class GoodsDTO {

    private Integer goodsId;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotEmpty(message = "Article cannot be empty")
    private String article;
    @NotEmpty(message = "Description cannot be empty")
    private String description;
    private BigDecimal price;
    private MultipartFile file;
    private String category;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }
}
