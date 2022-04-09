<%@ page import="com.supinfo.datasource.MyDataSource" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String userId = (String)session.getAttribute("id"); %>

<c:forEach var="object" items="<%= new MyDataSource().getUserObjects(userId) %>">
    <c:out value="${object.name}"/>
</c:forEach>
</body>
</html>
