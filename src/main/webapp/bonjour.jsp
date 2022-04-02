<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
<form method="post" action="hello">
    <p>
        <label for="name">Nom : </label>
        <input type="text" name="name" id="name" />
    </p>
    <p>
        <label for="firstName">Prénom : </label>
        <input type="text" name="firstName" id="firstName" />
    </p>

    <input type="submit" />
</form>

<ul>
    <c:forEach var="user" items="${ user }">
        <li><c:out value="${ user.name }" /> <c:out value="${ user.firstName }" /></li>
    </c:forEach>
</ul>
</body>
</html>