<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Профиль</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<c:import url="/fragment/navbar"/>
<div class="container centered">
    <a href="/user/profile">назад</a>
       <h1>${message}</h1>
<form:form action="/user/profile/addressAdd" method="post"  modelAttribute="addressDTO">
    <label >Регион: </label><br/>
    <form:errors path="region"/><br/>
    <form:input cssClass="text-color" path="region" type="text"/><br/>

    <label >Город: </label><br/>
    <form:errors path="city"/><br/>
    <form:input cssClass="text-color" path="city" type="text"/><br/>

    <label >Улица: </label><br/>
    <form:errors path="street"/><br/>
    <form:input cssClass="text-color" path="street" type="text"/><br/>

    <label >Дом: </label><br/>
    <form:errors path="house"/><br/>
    <form:input cssClass="text-color" path="house" type="text"/><br/>

    <label >Квартира: </label><br/>
    <form:errors path="flat"/><br/>
    <form:input cssClass="text-color" path="flat" type="text"/><br/>

   <div class="btn buttom"><button>Добавить адрес</button></div>

</form:form>
<c:import url="/fragment/footer"/>
    <script><c:import url="/resources/js/bootstrap.js"/></script>
    <script><c:import url="/resources/js/script.js"/></script>
</div>
</body>
</html>
