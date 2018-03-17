<%@ page contentType="text/html; charset = UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Registration</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row centered">
        <div class="btn buttom">
            <form action="${pageContext.request.contextPath}/login" method="get">
                <input type="submit" value="Back"/>
            </form>
        </div>
        <form:form method="post" modelAttribute="userDTO" action="/register">
            <label>Email: </label><br/>
            <form:errors path="mail"/><br/>
            <form:input cssClass="registration" path="mail" type="text"/><br/>
            <label>Username: </label><br/>
            <form:errors path="username"/><br/>
            <form:input cssClass="registration" path="username" type="text"/><br/>
            <label>FirstName: </label><br/>
            <form:errors path="firstName"/><br/>
            <form:input cssClass="registration" path="firstName" type="text"/><br/>
            <label>LastName: </label><br/>
            <form:errors path="lastName"/><br/>
            <form:input cssClass="registration" path="lastName" type="text"/><br/>
            <label>MiddleName: </label><br/>
            <form:errors path="middleName"/><br/>
            <form:input cssClass="registration" path="middleName" type="text"/><br/>
            <label>Phone number: </label><br/>
            <form:errors path="phoneNumber"/><br/>
            <form:input cssClass="registration" path="phoneNumber" type="text"/><br/>
            <label>Password: </label><br/>
            <form:errors path="password"/><br/>
            <form:input cssClass="registration" path="password" type="password"/><br/>
            <label>Repeat Password: </label><br/>
            <form:errors path="confirmPassword"/><br/>
            <form:input cssClass="registration" path="confirmPassword" type="password"/><br/>

            <div class="btn buttom">
                <button>Registration</button>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
