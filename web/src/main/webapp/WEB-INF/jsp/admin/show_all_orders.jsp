<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet">
</head>
<body>
<h1 class="centered">Orders</h1>

<table class="table table-hover">
    <tr>
        <th>№</th>
        <th>UserName</th>
        <th>Price</th>
        <th>Date</th>
        <th>Status</th>
        <th>More info</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td><c:out value="${order.orderId}"/></td>
            <td><c:out value="${order.userName}"/></td>
            <td><c:out value="${order.totalPrice}"/></td>
            <td><c:out value="${order.date}"/></td>
            <td><c:out value="${order.status}"/></td>
            <td><a href="/admin/order_details/${order.orderId}">Details</a></td>
        </tr>
    </c:forEach>
</table>
<a class="centered" href="/admin/main_admin">Back</a>
</body>
</html>
