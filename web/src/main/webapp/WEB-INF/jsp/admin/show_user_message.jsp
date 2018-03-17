<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet">
</head>
<body>
<h1 class="centered">User Message(Feed Back)</h1>

<table class="table table-hover">
    <tr>
        <th>№</th>
        <th>User</th>
        <th>Email</th>
        <th>Topic</th>
        <th>Message</th>
        <th>Date</th>
    </tr>
    <c:forEach var="message" items="${message}">
        <tr>
            <td><c:out value="${message.feedBackId}"/></td>
            <td><c:out value="${message.userName}"/></td>
            <td><c:out value="${message.mail}"/></td>
            <td><c:out value="${message.topic}"/></td>
            <td width="50%"><c:out value="${message.message}"/></td>
            <td><c:out value="${message.date}"/></td>
            <td><a href="/admin/show_user_message/removeFeedBack/${message.feedBackId}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<div class="centered">
    <a href="/admin/show_user_message/1">1</a>
    <a href="/admin/show_user_message/2">2</a>
    <a href="/admin/show_user_message/3">3</a>
</div>
<br/>
<a href="/admin/main_admin">Back</a>
</body>
</html>
