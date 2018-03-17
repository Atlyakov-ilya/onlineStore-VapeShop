<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/js/script.js" rel="script">
    <script type="text/javascript" src="http://yandex.st/jquery/1.9.0/jquery.min.js"></script>
</head>
<body>
<div class="container ">
    <div class="row centered ">
        <H1>ADD NEWS</H1>
        <form:form method="post" modelAttribute="newsDTO" enctype="multipart/form-data" action="admin/add_news">

            <label for="title">Title</label><br/>
            <p><form:errors path="title"/></p>
            <form:input path="title" type="text"/><br/>


            <label for="content">Content</label><br/>
            <p><form:errors path="content"/></p>
            <form:textarea path="content" rows="5" cols="30"/><br/>

            <div class="btn btn-file">
                <i class="icon-plus"> </i><span>Choose picture...</span><br/>
                <form:input cssClass="btn-file" path="file" type="file" name="image" id="image"/><br/><br/>
            </div>
            <br/>

            <button class="btn btn-warning">Save News</button>
        </form:form>
        <br/>
        <a href="/admin/main_admin">Back</a>
    </div>
</div>
<script><c:import url="/resources/js/bootstrap.js"/></script>
<script><c:import url="/resources/js/script.js"/></script>
</body>
</html>
