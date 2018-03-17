<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Жидкости</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<c:import url="/fragment/navbar"/>
<h1 class="centered">Жидкости</h1>
<div class="container content">
    <div class="row">
        <div class="col-md-3 goods-category">
            <div class="list-group">
                <a href="/user/show_goods/1"><h3>Каталог</h3></a>
                <a href="/user/show_goods_atomizer" class="list-group-item">ЭЛЕКТРОННЫЕ СИГАРЕТЫ</a>
                <a href="/user/show_goods_liquid" class="list-group-item">ЖИДКОСТИ</a>
                <a href="/user/show_goods_components" class="list-group-item">КОМПЛЕКТУЮЩИЕ</a>
                <a href="/user/show_goods_accumulator" class="list-group-item">АККУМУЛЯТОРЫ</a>
            </div>
        </div>
        <c:if test="${!empty goods}">
            <c:forEach var="goods" items="${goods}">
                <div class="col-md-3 products">
                    <div class="product">
                        <div class="product-img">
                            <a href="/user/show_one_item/${goods.goodsId}"><img src="${pageContext.request.contextPath}/user/downloadGoodsFile/<c:out value="${goods.goodsId}"/>"
                                                                          alt="photo"></a>
                        </div>
                        <p class="product-title">
                            <a href="/user/show_one_item/${goods.goodsId}"><c:out value="${goods.name}"/></a>
                        </p>
                        <p class="product-desc"><c:out value="${goods.description}"/></p>
                        <p class="product-price">Price: <c:out value="${goods.price}"/></p><br/>
                        <form action="/user/basket/${goods.goodsId}" method="get">
                            <button class = "btn btn-warning" type="submit">В КОРЗИНУ</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
</div>
<div class="centered">
    <a href="/user/show_goods/1">Back</a>
</div>
<c:import url="/fragment/footer"/>
<script><c:import url="/resources/js/bootstrap.js"/></script>
<script><c:import url="/resources/js/script.js"/></script>
</body>
</html>
