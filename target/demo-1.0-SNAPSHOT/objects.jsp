<%--
  Created by IntelliJ IDEA.
  User: osouf
  Date: 07/04/2022
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach var="<%= session.getAttribute("userList") %>" items="${userList}">
    <c:forEach var="user" items="${userList}">
        <c:out value="${user.getFirstName()}"/>
    </c:forEach>
</c:forEach>

</body>
</html>
