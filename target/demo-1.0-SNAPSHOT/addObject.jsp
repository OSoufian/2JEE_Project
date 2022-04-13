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
        <h1 class="connexion">Ajouter un objet</h1>
        <% if (request.getAttribute("status") != null) { %>
            <p class="errorMessage">Une erreur est survenu lors de l'ajout de l'objet. Veuillez réessayer !</p>
        <% } %>
        <form method="POST" action="addObject" enctype="multipart/form-data" class="form">
            <input type="text" name="name" placeholder="Nom"/><br>
            <input type="text" name="description" placeholder="Description"/><br>
            <input type="text" name="price" placeholder="Prix"/><br>
            <input type="file" name="image"/><br>
            <input type="submit" value="Ajouter"/><br>
        </form>

        <footer>
            <p> &copy; SUPINFO Paris </p>
        </footer>

    </body>
</html>
