<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>all news</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="row centered">
        <h1>ALL NEWS</h1>
        <c:if test="${!empty newsList}">
            <c:forEach var="news" items="${newsList}">
                <div class="col-md-3 products">
                    <div>
                        <div>
                            <a href="news_details/${news.newsId}"><img
                                    src="${pageContext.request.contextPath}/admin/downloadNewsFile/<c:out value="${news.newsId}"/>"
                                    alt="photo"></a>
                        </div>
                        <p>
                            <a href="/admin/show_news_details/${news.newsId}"><c:out value="${news.title}"/></a>
                        </p>
                        <p><c:out value="${news.date}"/></p>
                        <p>Content: <c:out value="${news.content}"/></p><br/>
                        <form action="/admin/show_all_news/removeNews/${news.newsId}" method="get">
                            <button class="btn btn-warning" type="submit">Delete</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <a href="/admin/main_admin">Back</a>
    </div>
</div>
</body>
</html>
