<%@ page import="com.supinfo.datasource.MyDataSource" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--<c:forEach var="user" items="<%= new MyDataSource().getUserList() %>">--%>
<%--    <c:out value="${user.firstName}"/><br>--%>
<%--</c:forEach>--%>

<c:forEach var="object" items="<%= new MyDataSource().getUserObjects((Integer)session.getAttribute("id")) %>">
    <c:out value="${object.name}"/>
</c:forEach>

</body>
</html>
