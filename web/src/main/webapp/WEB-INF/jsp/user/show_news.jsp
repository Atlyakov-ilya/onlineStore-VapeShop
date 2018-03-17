<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новости</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<c:import url="/fragment/navbar"/>
<div class="container">
    <div class="row">
        <div class="left">
            <form action="/user/main">
                <button class="btn btn-warning buttom">на главную</button>
            </form>
        </div>
        <div class="col-md-9">
            <h1>Новости</h1>
            <hr/>
<c:if test="${!empty news}">
    <c:forEach var="news" items="${news}">
            <a href="show_one_news/${news.newsId}"><c:out value="${news.title}"/></a><br/>
            <img src="${pageContext.request.contextPath}/user/downloadNewsFile/<c:out value="${news.newsId}"/>" alt="Smiley face"/><br/>
            <c:out value="${news.content}"/><br/>
            <c:out value="${news.date}"/><br/>
        <hr/>
    </c:forEach>
    </c:if>
        </div>
        <div class="col-md-3">
            <h3>Темы</h3>
            <c:forEach var="news" items="${news}">
                <a href="show_one_news/${news.newsId}"><c:out value="${news.title}"/></a><br/>
            </c:forEach>
        </div>
    </div>
    <a href="/user/main">Back</a>
    <c:import url="/fragment/footer"/>
    <script><c:import url="/resources/js/bootstrap.js"/></script>
    <script><c:import url="/resources/js/script.js"/></script>
</div>
</body>
</html>
