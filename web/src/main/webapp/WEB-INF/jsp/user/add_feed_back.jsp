<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обратная связь</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row centered">

<h1>Обратная связь</h1>

<form:form method="post" modelAttribute="feedBack" action="user/add_feed_back">
    <h3>${successful}</h3>
    <label for="mail">Email:</label>
    <p><form:errors path="mail"/></p>
    <form:input cssClass="feed-back-text" path="mail" type="text" placeholder="user@mail.ru"/><br/>
    <form:hidden path="userName"/>
    <label for="topic">Topic:</label>
    <p><form:errors path="topic"/></p>
    <form:input cssClass="feed-back-text input-xlarge" path="topic" type="text" placeholder="Ваша тема сообщения"/><br/>
    <label for="message">Message:</label>
    <p><form:errors path="message"/></p>
    <form:textarea cssClass="feed-back-text" path="message" rows="6" cols="30" placeholder="ТЕКСТ"/><br/>
    <button id="feed-back" type="reset" class="btn btn-warning">Clean all</button>
    <button id="feed-back" type="submit" class="btn btn-warning">send message</button>
</form:form>
<a href="/user/main">Back</a>
    </div>
</div>
<script><c:import url="/resources/js/bootstrap.js"/></script>
<script><c:import url="/resources/js/script.js"/></script>
</body>
</html>
