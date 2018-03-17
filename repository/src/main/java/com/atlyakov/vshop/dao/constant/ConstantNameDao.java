package com.atlyakov.vshop.dao.constant;

/**
 * Created by Ilya on 18.08.2017.
 */
public class ConstantNameDao {

    private ConstantNameDao() {
    }

    public static final String PARAMETER_USER_ID = "user";
    public static final String PARAMETER_USER_NAME = "username";
    public static final String PARAMETER_GOODS = "goods";
    public static final String PARAMETER_ORDER = "orders";
    public static final String PARAMETER_GOODS_CATEGORY = "category";
    public static final String PARAMETER_GOODS_ARTICLE = "article";
    public static final String PARAMETER_ORDER_ID = "orderId";



    public static final String HQL_GET_BY_USER_NAME = "FROM User AS u where u.username=:username";
    public static final String HQL_GET_GOODS_BY_CATEGORY = "FROM Goods AS g where g.category=:category";
    public static final String HQL_GET_GOODS_BY_USER_ID = "FROM Goods AS g where g.user=:user";
    public static final String HQL_GET_GOODS_BY_ARTICLE = "FROM Goods AS g where g.article=:article";
    public static final String HQL_GET_GOODS_BY_USER_ID_IN_BASKET = "select g from Basket b inner join Goods g on g.goodsId = b.goods and b.user =:user and b.order is null";
    public static final String HQL_GET_FEEDBACK = "FROM FeedBack";
    public static final String HQL_GET_GOODS = "FROM Goods";
    public static final String HQL_GET_GOODS_FROM_BASKET = " FROM Basket b WHERE b.goods=:goods";
    public static final String HQL_ADD_GOODS_IN_BASKET_TO_THE_ORDER = "UPDATE Basket b SET b.order =:orders WHERE b.user =:user";
    public static final String HQL_GET_ADDRESS_BY_USER_ID = "FROM Address a WHERE a.user = :user";
    public static final String HQL_GET_LAST_ORDER = "select max(o) from Orders as o where o.user =:user";
    public static final String HQL_GET_ALL_PRICE = "select sum(g.price) from Basket b inner join Goods g on g.goodsId = b.goods and b.user =:user and b.order is null";
    public static final String HQL_GET_ALL_GOODS_IN_ORDER = "select b.goods FROM Basket AS b inner join Orders o on o.orderId = b.order WHERE o.orderId = :orderId";
}
