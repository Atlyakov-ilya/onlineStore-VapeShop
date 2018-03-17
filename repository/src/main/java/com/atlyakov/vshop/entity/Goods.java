package com.atlyakov.vshop.entity;

import com.atlyakov.vshop.entity.enums.Category;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "t_goods")
public class Goods implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_GOODS_ID")
    private Integer goodsId;
    @Column(name = "F_NAME")
    private String name;
    @Column(name = "F_ARTICLE")
    private String article;
    @Column(name = "F_DESCRIPTION")
    @Type(type = "text")
    private String description;
    @Column(name = "F_PRICE")
    private BigDecimal price;
    @Column(name = "F_CATEGORY")
    @Enumerated(EnumType.STRING)
    private Category category;
    @OneToOne(mappedBy = "goods", cascade = CascadeType.ALL)
    private GoodsFileEntity goodsFileEntity;
    @ManyToOne
    @JoinColumn(name = "F_USER_ID", nullable = false)
    private User user;
    @OneToMany(mappedBy = "goods", fetch = FetchType.LAZY)
    private List<Basket> basketList;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public GoodsFileEntity getGoodsFileEntity() {
        return goodsFileEntity;
    }

    public void setGoodsFileEntity(GoodsFileEntity goodsFileEntity) {
        this.goodsFileEntity = goodsFileEntity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Basket> getBasketList() {
        return basketList;
    }

    public void setBasketList(List<Basket> basketList) {
        this.basketList = basketList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (goodsId != null ? !goodsId.equals(goods.goodsId) : goods.goodsId != null) return false;
        if (name != null ? !name.equals(goods.name) : goods.name != null) return false;
        if (article != null ? !article.equals(goods.article) : goods.article != null) return false;
        if (description != null ? !description.equals(goods.description) : goods.description != null) return false;
        return price != null ? price.equals(goods.price) : goods.price == null;
    }

    @Override
    public int hashCode() {
        int result = goodsId != null ? goodsId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (article != null ? article.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
