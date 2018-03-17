package com.atlyakov.vshop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_basket")
public class Basket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_BASKET_ID")
    private Integer basketId;
    @ManyToOne
    @JoinColumn(name = "F_GOODS_ID")
    private Goods goods;
    @ManyToOne
    @JoinColumn(name = "F_ORDER_ID")
    private Orders order;
    @Column(name = "F_QUANTITY")
    private Integer quantity = 1;
    @ManyToOne
    @JoinColumn(name = "F_USER_ID", nullable = false)
    private User user;


    public Integer getBasketId() {
        return basketId;
    }

    public void setBasketId(Integer basketId) {
        this.basketId = basketId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Basket basket = (Basket) o;

        if (basketId != null ? !basketId.equals(basket.basketId) : basket.basketId != null) return false;
        if (goods != null ? !goods.equals(basket.goods) : basket.goods != null) return false;
        if (order != null ? !order.equals(basket.order) : basket.order != null) return false;
        return quantity != null ? quantity.equals(basket.quantity) : basket.quantity == null;
    }

    @Override
    public int hashCode() {
        int result = basketId != null ? basketId.hashCode() : 0;
        result = 31 * result + (goods != null ? goods.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
