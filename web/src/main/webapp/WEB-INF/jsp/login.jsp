<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row centered">
        <img src="/resources/img/site/logotype.jpg" alt="logo">
        <hr>
        <form action="/login" method="post">
            <c:if test="${param['error']}">
                <p class="error">Invalid login or password. Please check and try again!</p>
            </c:if>
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" required name="username" placeholder="Username">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
            <button class="btn btn-default">Войти</button>
        </form>
        <hr/>
        <div class="btn">
            <form action="/register" method="get">
                <input class="btm buttom" type="submit" value="Регистрация"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>
