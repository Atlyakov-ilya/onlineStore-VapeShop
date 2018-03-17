package com.atlyakov.vshop.entity;

import com.atlyakov.vshop.entity.enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_order")
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_ORDER_ID")
    private Integer orderId;
    @Column(name = "F_BASKET_ID")
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY )
    private List<Basket> basketList;
    @Column(name = "F_STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "F_TOTAL_PRICE")
    private BigDecimal totalPrice;
    @ManyToOne
    @JoinColumn(name = "F_USER_ID", nullable = false)
    private User user;
    @Column(name = "F_DATE")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<Basket> getBasketList() {
        return basketList;
    }

    public void setBasketList(List<Basket> basketList) {
        this.basketList = basketList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (orderId != null ? !orderId.equals(orders.orderId) : orders.orderId != null) return false;
        if (status != orders.status) return false;
        if (totalPrice != null ? !totalPrice.equals(orders.totalPrice) : orders.totalPrice != null) return false;
        return date != null ? date.equals(orders.date) : orders.date == null;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
