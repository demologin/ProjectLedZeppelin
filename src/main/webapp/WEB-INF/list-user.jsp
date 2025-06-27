<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>List Users</h1>
<br/>
<ul>
    <c:forEach var="user" items="${requestScope.users}">
        <li><a href="edit-user?id=${user.id}">${user.login}</a></li>
    </c:forEach>
</ul>
</body>
</html>