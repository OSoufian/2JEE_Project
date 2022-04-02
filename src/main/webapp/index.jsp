<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Bienvenue sur la page index.jsp !</h1><br>
<p><%= session.getAttribute("username") %></p>

</body>
</html>