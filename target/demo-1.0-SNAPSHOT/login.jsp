<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Se Connecter</title>
    <style>
        #errorMessage {
            color: red;
        }
    </style>
</head>
<body>
    <h1>Se Connecter</h1>
    <a href="index.jsp">Retour au menu principal</a><br>
    <% if (session.getAttribute("status") != null) { %>
        <p id="errorMessage">Nom d'utilisateur ou mot de passe incorrect !</p>
    <% } %>
    <form method="POST" action="login">
        <label for="username"></label><input type="text" id="username" name="username" placeholder="Nom d'utilisateur" /><br>
        <label for="password"></label><input type="password" id="password" name="password" placeholder="Mot de Passe" /><br>
        <input type="submit" value="Se Connecter" /><br>
        <p>Pas encore inscrit ? <a href="register.jsp">Créer un compte</a></p>
    </form>
</body>
</html>
