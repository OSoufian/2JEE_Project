<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Se Connecter</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <a href="index.jsp">
            <div class="logotwo">
                <img src="image/logo.png" alt="test" width = "300">
            </div>
        </a><br>

        <% if (session.getAttribute("status") != null) { %>
        <p class="errorMessage">Nom d'utilisateur ou mot de passe incorrect !</p>
        <% } %>

        <form method="POST" action="login">
            <p class="connexion"> Connexion </p>
            <div class="form">
                <input type="text" id="username" name="username" placeholder="Nom d'utilisateur" /><br>
                <input type="password" id="password" name="password" placeholder="Mot de Passe" /><br>
                <input class="submit" type="submit" value="Valider"/><br>
                <p class="dejavu">Pas encore inscrit ? <a href="register.jsp">Créer un compte</a></p>
            </div>
        </form>

        <footer>
            <p> &copy; SUPINFO Paris </p>
        </footer>
    </body>
</html>
