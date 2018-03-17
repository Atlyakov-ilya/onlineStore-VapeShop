<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isErrorPage="true" %>
<html>
<head>
</head>
<body>
<main>
    <div class="category">
        Request from ${pageContext.errorData.requestURI} is failed<br>
        Servlet name: ${pageContext.errorData.servletName}<br>
        Status code: ${pageContext.errorData.statusCode}<br>
        Exception: ${pageContext.exception}<br>
        Message from exception: ${pageContext.exception.message}
    </div>
</main>
</body>
</html>
