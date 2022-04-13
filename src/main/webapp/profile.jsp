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
        <h1 class="connexion">Votre profil</h1>
        <div class="form">
            <p>Nom d'utilisateur : <%= session.getAttribute("username") %></p>
            <p>Nom : <%= session.getAttribute("name") %></p>
            <p>Prénom : <%= session.getAttribute("firstName") %></p>
            <p>Email : <%= session.getAttribute("email") %></p>
            <p>Code postal : <%= session.getAttribute("zipCode") %></p>
            <a href="editProfile.jsp" >Éditer</a>
        </div>
        <footer>
            <p> &copy; SUPINFO Paris </p>
        </footer>

    </body>
</html>