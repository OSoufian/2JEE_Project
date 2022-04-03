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
        <label for="name"></label><input type="text" id="name" name="name"  placeholder="Nom"/><br><br>
        <label for="firstName"></label><input type="text" id="firstName" name="firstName" placeholder="Prénom"/><br>
        <label for="username"></label><input type="text" id="username" name="username" placeholder="Nom d'utilisateur"/><br>
        <label for="email"></label><input type="email" id="email" name="email" placeholder="Email"/><br>
        <label for="zipCode"></label><input type="text" id="zipCode" name="zipCode" placeholder="Code Postal"/><br>
        <label for="password"></label><input type="password" id="password" name="password" placeholder="Mot de Passe"/><br>
        <input type="submit" id="register" value="S'inscrire"/><br>
        <p>Vous avez déjà un compte ? <a href="register.jsp">Se connecter</a></p>
    </form>

</body>
</html>
