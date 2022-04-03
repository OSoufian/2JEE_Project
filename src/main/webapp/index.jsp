<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>Bienvenue sur SUP BARTERING !</h1>

    <% if (session.getAttribute("username") != null) { %>
        <p>User : <%= session.getAttribute("username") %></p>
        <a href="logout.jsp">Se déconnecter</a>
    <% } else { %>
        <a href="login.jsp">Se connecter</a>
        <a href="register.jsp">S'inscrire</a>
    <% } %>

</body>
</html>