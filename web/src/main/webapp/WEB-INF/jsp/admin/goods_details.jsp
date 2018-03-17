<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="row centered">
        <h1>Goods</h1>
        <hr>

        <h3>Name: ${goods.name}</h3>

        <img src="${pageContext.request.contextPath}/admin/downloadGoodsFile/<c:out value="${goods.goodsId}"/>"
             alt="Goods">

        <h3>ARTICLE: ${goods.article}</h3>

        <h3>DESCRIPTION: ${goods.description}</h3>

        <h3>PRICE: ${goods.price}</h3>

        <form action="/admin/editGoods/${goods.goodsId}" method="get">
            <button>Edit this Goods</button>
        </form>

        <c:if test="${!empty goodsEdit}">
            <form:form action="/admin/editGoods/add" commandName="goods" method="get">
                <form:hidden path="goodsId"/>

                <form:label path="name">
                    <spring:message text="Name: "/>
                </form:label>
                <form:errors path="name"/>
                <form:input path="name" size="35"/><br/>

                <form:label path="article">
                    <spring:message text="Article: "/>
                </form:label>
                <form:errors path="article"/>
                <form:input path="article" size="35"/><br/>

                <form:label path="description">
                    <spring:message text="Description: "/>
                </form:label>
                <form:errors path="description"/>
                <form:input path="description" size="35"/><br/>

                <form:label path="price">
                    <spring:message text="Price: "/>
                </form:label>
                <form:errors path="price"/>
                <form:input path="price" size="35"/><br/>

                <form:hidden path="category"/>

                <button class="btn btn-default">Edit</button>
            </form:form>

        </c:if>

        <a href="${pageContext.request.contextPath}/admin/show_all_goods">Back</a>

    </div>
</div>
</body>
</html>
