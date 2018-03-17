<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>all goods</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="row centered">
        <h1>ALL GOODS</h1>
        <c:if test="${!empty goodsList}">
            <c:forEach var="goods" items="${goodsList}">
                <div class="col-md-3 products">
                    <div>
                        <div>
                            <a href="/admin/show_goods_details/${goods.goodsId}"><img
                                    src="${pageContext.request.contextPath}/admin/downloadGoodsFile/<c:out value="${goods.goodsId}"/>"
                                    alt="photo"></a>
                        </div>
                        <p>
                            <a href="/admin/show_goods_details/${goods.goodsId}"><c:out value="${goods.name}"/></a>
                        </p>
                        <p><c:out value="${goods.description}"/></p>
                        <p>Price: <c:out value="${goods.price}"/></p><br/>
                        <form action="/admin/show_all_goods/removeGoods/${goods.goodsId}" method="get">
                            <button class="btn btn-warning" type="submit">Delete</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <a href="${pageContext.request.contextPath}/admin/main_admin">Back</a>
    </div>
</div>
</body>
</html>
