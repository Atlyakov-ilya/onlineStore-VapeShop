<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet"/>
</head>
<body>
<h1 class="centered">List of users</h1>
<c:if test="${!empty users}">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>#</th>
            <th>Username</th>
            <th>Password</th>
            <th>FirstName</th>
            <th>LastName</th>
            <th>MiddleName</th>
            <th>Email</th>
            <th>Remove</th>
            <th>Update</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <th><c:out value="${user.userId}"/></th>
                <td><c:out value="${user.username}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.firstName}"/></td>
                <td><c:out value="${user.lastName}"/></td>
                <td><c:out value="${user.middleName}"/></td>
                <td><c:out value="${user.mail}"/></td>
                <td><a href="remove/${user.userId}">Delete</a></td>
                <td><a href="edit/${user.userId}">Edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<div class="container">
    <div class="row centered">
        <c:if test="${!empty user}">
            <form:form action="/admin/edit/add" method="post" commandName="user">
                <tr>
                    <td>
                        <form:label path="userId">
                            <spring:message text="ID: "/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="userId"/>
                    </td>
                </tr>
                <br/>
                <tr>
                    <td>
                        <form:label path="username">
                            <spring:message text="User Name: "/>
                        </form:label>
                    </td>
                    <td>
                        <form:errors path="username"/><br/>
                        <form:input path="username"/>
                    </td>
                </tr>
                <br/>
                <tr>
                    <td>
                        <form:label path="mail">
                            <spring:message text="Email: "/>
                        </form:label>
                    </td>
                    <td>
                        <form:errors path="mail"/><br/>
                        <form:input path="mail"/>
                    </td>
                </tr>
                <br/>
                <tr>
                    <td>
                        <form:label path="firstName">
                            <spring:message text="First Name: "/>
                        </form:label>
                    </td>
                    <td>
                        <form:errors path="firstName"/><br/>
                        <form:input path="firstName"/>
                    </td>
                </tr>
                <br/>
                <tr>
                    <td>
                        <form:label path="lastName">
                            <spring:message text="Last Name: "/>
                        </form:label>
                    </td>
                    <td>
                        <form:errors path="lastName"/><br/>
                        <form:input path="lastName"/>
                    </td>
                </tr>
                <br/>
                <tr>
                    <td>
                        <form:label path="middleName">
                            <spring:message text="Middle Name: "/>
                        </form:label>
                    </td>
                    <td>
                        <form:errors path="middleName"/><br/>
                        <form:input path="middleName"/>
                    </td>
                </tr>
                <br/>
                <tr>
                    <td>
                        <form:label path="phoneNumber">
                            <spring:message text="Phone Number: "/>
                        </form:label>
                    </td>
                    <td>
                        <form:errors path="phoneNumber"/><br/>
                        <form:input path="phoneNumber"/>
                    </td>
                </tr>
                <br/>
                <tr>
                    <td>
                        <form:label path="password">
                            <spring:message text="Password: "/>
                        </form:label>
                    </td>
                    <td>
                        <form:errors path="password"/><br/>
                        <form:input path="password"/>
                    </td>
                </tr>
                <br/>
                <tr>
                    <td>
                        <form:label path="confirmPassword">
                            <spring:message text="Return Password: "/>
                        </form:label>
                    </td>
                    <td>
                        <form:errors path="confirmPassword"/><br/>
                        <form:input path="confirmPassword"/>
                    </td>
                </tr>
                <br/>
                <form:label path="role">
                    <spring:message text="Role: ${user.role} "/>
                </form:label>
                <form:select path="role">
                    <form:option label="ROLE_ADMIN" value="ROLE_ADMIN"/>
                    <form:option label="ROLE_USER" value="ROLE_USER"/>
                </form:select><br/>

                <form:label path="access">
                    <spring:message text="Access: ${user.access} "/>
                </form:label>
                <form:select path="access">
                    <form:option label="ACTIVE" value="ACTIVE"/>
                    <form:option label="BANNED" value="BANNED"/>
                </form:select><br/>
                <button>Update</button>
            </form:form>
        </c:if>
        <a href="/admin/main_admin">Back</a>
    </div>
</div>

</body>
</html>
