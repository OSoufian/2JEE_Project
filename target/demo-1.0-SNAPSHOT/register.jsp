<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>S'inscrire</title>
    <style>
        #errorMessage {
            color: red;
        }
    </style>
</head>
<body>
<h1>S'inscrire</h1>
<a href="index.jsp">Retour au menu principal</a><br>
<% if (session.getAttribute("status") != null) { %>
<p id="errorMessage">Une erreur est survenu lors de l'inscription. Veuillez réessayer !</p>
<% } %>
<form method="POST" action="register">
    <input type="text" id="name" name="name" placeholder="Nom"/><br><br>
    <input type="text" id="firstName" name="firstName" placeholder="Prénom"/><br>
    <input type="text" id="username" name="username" placeholder="Nom d'utilisateur"/><br>
    <input type="email" id="email" name="email" placeholder="Email"/><br>
    <input type="text" id="zipCode" name="zipCode" placeholder="Code Postal"/><br>
    <input type="password" id="password" name="password" placeholder="Mot de Passe"/><br>
    <input type="submit" id="register" value="S'inscrire"/><br>
    <p>Vous avez déjà un compte ? <a href="register.jsp">Se connecter</a></p>
</form>

</body>
</html>