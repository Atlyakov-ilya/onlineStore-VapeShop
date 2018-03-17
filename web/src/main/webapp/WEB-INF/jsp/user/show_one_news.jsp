<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${news.title}</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row centered">
        <c:import url="/fragment/navbar"/>
<h2>${news.title}</h2>

<img src="${pageContext.request.contextPath}/user/downloadNewsFile/<c:out value="${news.newsId}"/>" alt="News">

<h3>${news.content}</h3>

<h3>${news.date}</h3>

<a href="/user/show_news">Back</a>
    </div>
</div>
<script><c:import url="/resources/js/bootstrap.js"/></script>
<script><c:import url="/resources/js/script.js"/></script>
<c:import url="/fragment/footer"/>
</body>
</html>
