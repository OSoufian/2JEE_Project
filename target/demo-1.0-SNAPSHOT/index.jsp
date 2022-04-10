<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SUP Bartering</title>
</head>
<body>

    <h1>Bienvenue sur SUP BARTERING !</h1>

    <% if (session.getAttribute("username") != null) { %>
        <p>User : <%= session.getAttribute("username") %></p>
        <a href="profile.jsp">Voir votre profil</a><br>
        <a href="objects.jsp">Voir mes objets</a><br>
        <a href="logout.jsp">Se déconnecter</a>
    <% } else { %>
        <a href="login.jsp">Se connecter</a>
        <a href="register.jsp">S'inscrire</a>
    <% } %>

</body>
</html>