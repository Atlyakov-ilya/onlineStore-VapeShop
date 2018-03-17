<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News Details</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="row centered">
        <h1>NEWS</h1>
        <hr>

        <h3>TITLE:${news.title}</h3>

        <img src="${pageContext.request.contextPath}/admin/downloadNewsFile/<c:out value="${news.newsId}"/>" alt="News">

        <h3>CONTEXT: ${news.content}</h3>

        <h3>DATE: ${news.date}</h3>

        <form action="/admin/editNews/${news.newsId}" method="get">
            <button>Edit this News</button>
        </form>

        <c:if test="${!empty newsEdit}">
            <form:form action="/admin/editNews/add" commandName="news" method="get">
                <form:hidden path="newsId"/>
                <form:label path="title">
                    <spring:message text="Title: "/>
                </form:label>
                <form:errors path="title"/>
                <form:input path="title" size="60"/><br/>
                <form:label path="content">
                    <spring:message text="Content: "/><br/>
                </form:label>
                <form:errors path="content"/>
                <form:textarea path="content" rows="10" cols="40"/><br/>
                <button class="btn btn-default">Edit</button>
            </form:form>
        </c:if>

        <a href="${pageContext.request.contextPath}/admin/show_all_news">Back</a>
    </div>
</div>
</body>
</html>
