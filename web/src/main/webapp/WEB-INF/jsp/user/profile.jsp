<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Профиль</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<div class="container centered">
    <diw class="row">
<c:import url="/fragment/navbar"/>
        <div class="left">
            <form action="/user/main">
                <button class="btn btn-warning buttom">на главную</button>
            </form>
        </div>
    <c:if test="${!empty user}">
<h1>User Profile</h1>
<h2>Your Information</h2>
<p>Email: ${user.mail}</p>
<p>User Name: ${user.username}</p>
<p>First Name: ${user.firstName}</p>
<p>Last Name: ${user.lastName}</p>
<p>Middle Name: ${user.middleName}</p>
<p>Phone Number: ${user.phoneNumber}</p>
    </c:if>
    <c:if test="${!empty address}">
        <h2>User Address</h2>

        <p>Region: ${address.region}</p>
        <p>City: ${address.city}</p>
        <p>Street: ${address.street}</p>
        <p>House: ${address.house}</p>
        <p>Flat: ${address.flat}</p>

    </c:if>
<form action="/user/profile/update" method="get">
    <div class="btn buttom"><button>Изменить данные профиля</button></div>
</form>

<c:if test="${!empty userUpdate}">
<h2>Edit</h2><br/>
<c:url var="addAction" value="/user/update/add"/>
    <c:if test="${param['error']}">
        <p class="error">Invalid login or password. Please check and try again!</p>
    </c:if>
<form:form action="${addAction}" method="post" commandName="userUpdate">

    <form:label path="userId">
        <spring:message text="userId"/><br/>
    </form:label>
    <form:input cssClass="text-color" path="userId"/><br/>

    <form:label path="mail">
        <spring:message text="mail"/>
    </form:label>
    <form:errors path="mail"/><br/>
    <form:input cssClass="text-color" path="mail"/><br/>

    <form:label path="username">
        <spring:message text="username"/>
    </form:label>
    <form:errors path="username"/><br/>
    <form:input cssClass="text-color" path="username"/><br/>

    <form:label path="firstName">
        <spring:message text="firstName"/>
    </form:label>
    <form:errors path="firstName"/><br/>
    <form:input cssClass="text-color" path="firstName"/><br/>

    <form:label path="lastName">
        <spring:message text="lastName"/>
    </form:label>
    <form:errors path="lastName"/><br/>
    <form:input cssClass="text-color" path="lastName"/><br/>

    <form:label path="middleName">
        <spring:message text="middleName"/>
    </form:label>
    <form:errors path="middleName"/><br/>
    <form:input cssClass="text-color" path="middleName"/><br/>

    <form:label path="phoneNumber">
        <spring:message text="phoneNumber"/>
    </form:label>
    <form:errors path="phoneNumber"/><br/>
    <form:input cssClass="text-color" path="phoneNumber"/><br/>

    <form:hidden path="password" />

    <div class="btn buttom"><button>Изменить данные</button></div>

</form:form>
</c:if>
        <c:if test="${address == null}">
            <h3>Адресс еще не заполнен</h3>
            <form action="/user/profile/address" method="get">
                <div class="btn buttom"><button>Добавить адрес</button></div>
            </form>
        </c:if>
<c:import url="/fragment/footer"/>
    </diw>
</div>
<script><c:import url="/resources/js/bootstrap.js"/></script>
<script><c:import url="/resources/js/script.js"/></script>
</body>
</html>
