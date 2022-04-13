<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>SUP Bartering</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <a href="index.jsp">
            <div class="logotwo">
                <img src="image/logo.png" alt="test" width = "300">
            </div>
        </a><br>
        <% if (session.getAttribute("status") != null) { %>
            <p class="errorMessage">Une erreur est survenu lors de l'inscription. Veuillez réessayer !</p>
        <% } %>
        <form method="POST" action="register">
            <p class="connexion"> Inscription </p>
            <div class="form">
                <input type="text" name="name" placeholder="Nom"/><br>
                <input type="text" name="firstName" placeholder="Prénom"/><br>
                <input type="text" name="username" placeholder="Nom d'utilisateur"/><br>
                <input type="email" name="email" placeholder="Email"/><br>
                <input type="text" name="zipCode" placeholder="Code Postal"/><br>
                <input type="password" name="password" placeholder="Mot de Passe"/><br>
                <input type="submit" class="submit" value="S'inscrire"/><br>
                <p class="dejavu">Vous avez déjà un compte ? <a href="login.jsp">Se connecter</a></p>
            </div>
        </form>

        <footer>
            <p> &copy; SUPINFO Paris </p>
        </footer>

    </body>
</html>