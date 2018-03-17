<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Details</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet">
</head>
<body>
<div class="container centered">
    <div class="row">
        <h1>Order №${order.orderId} for ${order.userName}</h1>
        <h3>Goods list</h3>
        <c:if test="${!empty goodsList}">
            <c:forEach var="goods" items="${goodsList}">
                <div class="col-md-12">
                <hr/>
                <div class="col-md-3">
                    <a href="show_one_item/${goods.goodsId}">
                        <img src="${pageContext.request.contextPath}/admin/downloadGoodsFile/<c:out value="${goods.goodsId}"/>"
                             alt="photo"></a>
                </div>
                <div class="col-md-3">
                    <p>Название: <c:out value="${goods.name}"/></p>
                    <p>Номер товара: <c:out value="${goods.article}"/></p>
                    <p>Цена: <c:out value="${goods.price}"/></p>
                    <p>Количество: 1</p>
                </div>
                </div>
            </c:forEach>
            <div class="centered">
                <h3>Customer information</h3>
                ФИО получателя: ${user.lastName} ${user.firstName} ${user.middleName}.<br/>
                Номер телефона:${user.phoneNumber}<br>
                Адрес:Город ${address.city},Улица ${address.street},Дом ${address.house},Квартира ${address.flat}.<br/>
                Email:<p>${user.mail}</p><br>
                <hr/>
                <p>Сумма по товарам: ${allPrice} руб</p>
                <p>Сумма по доставке: 0 руб</p>
                <hr/>
                <p>ИТОГО: ${allPrice} руб</p><br/>

                <form:form action="/admin/order_details/changeStatus"  commandName="order" method="post">
                    <form:hidden path="orderId"/>
                    <form:hidden path="date"/>
                    <form:select path="status">
                        <form:option label="NEW" value="NEW"/>
                        <form:option label="REVIEWING" value="REVIEWING"/>
                        <form:option label="IN_PROGRESS" value="IN_PROGRESS"/>
                        <form:option label="DELIVERED" value="DELIVERED"/>
                    </form:select><br/>
                    <form:hidden path="totalPrice"/>
                    <form:hidden path="userId"/>
                    <button class="btn btn-warning">Изменить статус</button>
                </form:form>
            </div>
        </c:if>
    </div>
    <a href="${pageContext.request.contextPath}/admin/show_all_orders">Back</a>
</div>
</body>
</html>
