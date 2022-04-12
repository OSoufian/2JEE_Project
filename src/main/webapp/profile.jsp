<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SUP Bartering</title>
</head>
<body>
    <h1>Votre profil</h1>
    <p>Nom d'utilisateur : <%= session.getAttribute("username") %></p>
    <p>Nom : <%= session.getAttribute("name") %></p>
    <p>Prénom : <%= session.getAttribute("firstName") %></p>
    <p>Email : <%= session.getAttribute("email") %></p>
    <p>Code postal : <%= session.getAttribute("zipCode") %></p>
    <a href="editProfile.jsp">Éditer</a>
</body>
</html>
