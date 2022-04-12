<%@ page import="com.supinfo.DAO.ObjectEntityDAO" %>
<%@ page import="java.io.OutputStream" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SUP Bartering</title>
</head>
<body>
<% String userId = (String)session.getAttribute("id"); %>

<a href="addObject.jsp">Ajouter un object</a><br>

<c:forEach var="object" items="<%= new ObjectEntityDAO().getUserObjects(userId) %>">
    <c:out value="${object.name}"/>
    <img width="300px" height="300px" src="data:image/jpeg;base64,${object.encode}"/>
    <form method="POST" action="deleteObject">
        <input type="hidden" name="objectId" value="${object.id}"/><br>
        <input type="submit" value="Supprimer"/>
    </form>
</c:forEach>
</body>
</html>