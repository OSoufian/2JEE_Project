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
        <form method="POST" action="edit" class="form">
            <p class="connexion"> <%= session.getAttribute("username") %></p>
            <p>Nom : <input type="text" id="name" name="name" value="<%= session.getAttribute("name") %>"/></p>
            <p>Prénom : <input type="text" id="firstName" name="firstName" value="<%= session.getAttribute("firstName") %>"/></p>
            <p>Email : <input type="email" id="email" name="email" value="<%= session.getAttribute("email") %>"/></p>
            <p>Code postal : <input type="text" id="zipCode" name="zipCode" value="<%= session.getAttribute("zipCode") %>"/></p>
            <input type="submit" id="edit" value="edit" class="submit"/><br>
        </form>

        <footer>
            <p> &copy; SUPINFO Paris </p>
        </footer>

    </body>
</html>
