<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach var="<%= session.getAttribute("userList") %>" items="${userList}">
    <c:forEach var="user" items="${userList}">
        <c:out value="${user.firstName}"/>
    </c:forEach>
</c:forEach>

</body>
</html>
