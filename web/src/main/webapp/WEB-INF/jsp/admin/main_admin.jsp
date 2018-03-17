<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="row centered">
        <h1>ADMIN_MANE_PAGE</h1>
        <div class="centered">
            <ul class="list-group list-unstyled">
                <a href="${pageContext.request.contextPath}/admin/add_news" class="list-group-item">
                    <li class="centered">ADD NEWS</li>
                </a>
                <a href="${pageContext.request.contextPath}/admin/add_goods" class="list-group-item">
                    <li class="centered">ADD_GOODS</li>
                </a>
                <a href="${pageContext.request.contextPath}/admin/show_users" class="list-group-item">
                    <li class="centered">SHOW_USERS</li>
                </a>
                <a href="${pageContext.request.contextPath}/admin/show_all_goods" class="list-group-item">
                    <li class="centered">SHOW_ALL_GOODS</li>
                </a>
                <a href="${pageContext.request.contextPath}/admin/show_all_news" class="list-group-item">
                    <li class="centered">SHOW_ALL_NEWS</li>
                </a>
                <a href="${pageContext.request.contextPath}/admin/show_user_message/1" class="list-group-item" class="centered">
                    <li>SHOW_USER_MESSAGE</li>
                </a>
                <a href="${pageContext.request.contextPath}/admin/show_all_orders" class="list-group-item">
                    <li class="centered">SHOW_ALL_ORDERS</li>
                </a>
            </ul>
            <form action="${pageContext.request.contextPath}/logout">
                <button class="btn btn-danger">Logout</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
