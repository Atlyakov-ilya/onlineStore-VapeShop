<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet">
</head>
<body>
<div class="container ">
    <div class="row centered ">
        <H1>ADD GOODS</H1>

        <form:form method="post" modelAttribute="goodsDTO" enctype="multipart/form-data" action="${pageContext.request.contextPath}admin/add_goods">
            <h3>${message}</h3>
            <label for="name">Name</label><br/>
            <p><form:errors path="name"/></p>
            <form:input path="name" type="text"/><br/>

            <label for="article">Article</label><br/>
            <p><form:errors path="article"/></p>
            <form:input path="article" type="text"/><br/>

            <label for="price">Price</label><br/>
            <p><form:errors path="price"/></p>
            <form:input path="price" type="textarea"/><br/>

            <label for="description">Description</label><br/>
            <p><form:errors path="description"/></p>
            <form:textarea path="description" rows="5" cols="30"/><br/>

            <label for="category">Category</label><br/>
            <form:select path="category">
                <form:option label="Жидкость" value="LIQUID"/>
                <form:option label="Аккамулятор" value="ACCUMULATOR"/>
                <form:option label="Электронная сигарета" value="ATOMIZER"/>
                <form:option label="Компоненты" value="COMPONENTS"/>
            </form:select><br/><br/>

            <div class="btn btn-file">
                <i class="icon-plus"> </i><span>Choose picture...</span>
                <form:input cssClass="btn-file" path="file" type="file" name="image" id="image"/><br/><br/>
            </div>
            <br/><br/>

            <button class="btn btn-warning">Create goods</button>

        </form:form>
        <a href="/admin/main_admin">Back</a>
    </div>
</div>
<script><c:import url="${pageContext.request.contextPath}/resources/js/bootstrap.js"/></script>
<script><c:import url="${pageContext.request.contextPath}/resources/js/script.js"/></script>
</body>
</html>
