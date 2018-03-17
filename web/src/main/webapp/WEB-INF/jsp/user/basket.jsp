<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Корзина</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<c:import url="/fragment/navbar"/>
<c:import url="/fragment/header"/>
<div class="container">
    <div class="left">
        <form action="/user/main">
            <button class="btn btn-warning buttom">на главную</button>
        </form>
    </div>
    <c:if test="${!empty basketList}">
    <c:forEach var="basket" items="${basketList}">
        <div class="col-md-12">
            <hr/>
            <div class="col-md-3">
                <a href="show_one_item/${basket.goodsId}"><img
                        src="${pageContext.request.contextPath}/user/downloadGoodsFile/<c:out value="${basket.goodsId}"/>"
                        alt="photo"></a></div>
            <div class="col-md-3">
                <p>Название: <c:out value="${basket.name}"/></p>
                <p>Номер товара: <c:out value="${basket.article}"/></p>
                <p>Цена: <c:out value="${basket.price}"/></p>
            </div>
            <div class="col-md-3">
                <p>Количество: </p>
                <div class="number">
                    <form action="#" method="post">
                        <div class="input-group">
    <span class="input-group-btn">
        <button type="button" class="btn btn-default btn-number" data-type="minus" data-field="num"><span
                class="glyphicon glyphicon-minus"></span></button>
    </span>
                            <input type="text" name="num" class="form-control input-number" value="1">
                            <span class="input-group-btn">
        <button type="button" class="btn btn-default btn-number" data-type="plus" data-field="num"><span
                class="glyphicon glyphicon-plus"></span></button>
    </span>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-md-3">
                <form action="basket/removeGoodsInBasket/${basket.article}">
                    <button class="btn btn-warning buttom">Удалить</button>
                </form>
            </div>
        </div>
        <hr/>
    </c:forEach>
    <div class="right">
        <p>ИТОГО: ${allPrice}</p>
        <form action="${pageContext.request.contextPath}/user/order" method="post">
            <button class="btn btn-warning buttom">Оформить заказ</button>
        </form>
        </c:if>
    </div>
</div>
<div class="centered">
    <c:if test="${empty basketList}">
        <h1>Ваша корзина пуста</h1>
    </c:if>
</div>
<c:import url="/fragment/footer"/>
<script><c:import url="/resources/js/bootstrap.js"/></script>
<script><c:import url="/resources/js/script.js"/></script>
</body>
</html>
