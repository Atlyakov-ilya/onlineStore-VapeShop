<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${goods.name}</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row centered">
        <c:import url="/fragment/navbar"/>
<h3>${goods.name}</h3>

<img src="${pageContext.request.contextPath}/user/downloadGoodsFile/<c:out value="${goods.goodsId}"/>" alt="Goods"><br/>

Article: ${goods.article}
<br/>
Description: ${goods.description}
<br/>
Price: ${goods.price}
<br/>
<form action="/user/basket/${goods.goodsId}" method="get">
    <button class="btn btn-warning">В КОРЗИНУ</button>
</form>
<br/>
<a href="/user/show_goods">Back</a>
    </div>
</div>
<script><c:import url="/resources/js/bootstrap.js"/></script>
<script><c:import url="/resources/js/script.js"/></script>
<c:import url="/fragment/footer"/>
</body>
</html>
