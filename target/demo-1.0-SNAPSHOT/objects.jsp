<%@ page import="com.supinfo.datasource.MyDataSource" %>
<%@ page import="java.io.OutputStream" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String userId = (String)session.getAttribute("id"); %>

<a href="addObject.jsp">Ajouter un object</a><br>

<c:forEach var="object" items="<%= new MyDataSource().getUserObjects(userId) %>">
    <c:out value="${object.name}"/>
    <img width="300px" height="300px" src="data:image/jpeg;base64,${object.encode}" />
</c:forEach>
</body>
</html>
