<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Se Connecter</title>
</head>
<body>
<input type="hidden" value="<%= request.getAttribute("status") %>">
<h1>Se Connecter</h1>
<form method="POST" action="login">
    <label for="username"></label><input type="text" id="username" name="username" placeholder="Nom d'utilisateur" />
    <label for="password"></label><input type="password" id="password" name="password" placeholder="Mot de Passe" />
    <input type="submit" value="Se Connecter" />
</form>
</body>
</html>
