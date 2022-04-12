<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SUP Bartering</title>
    <link rel="stylesheet" href="style.css">
    <style>
        #errorMessage {
            color: red;
        }
    </style>
</head>
<body>
    <h1>Ajouter un objet</h1>
    <a href="index.jsp">Retour au menu principal</a><br>
    <% if (session.getAttribute("status") != null) { %>
    <p id="errorMessage">Une erreur est survenu lors de l'ajout de l'objet. Veuillez réessayer !</p>
    <% } %>
    <form method="POST" action="addObject" enctype="multipart/form-data">
        <input type="text" name="name" placeholder="Nom"/><br>
        <input type="text" name="description" placeholder="Description"/><br>
        <input type="text" name="price" placeholder="Prix"/><br>
        <input type="file" name="image"/><br>
        <input type="submit" value="Ajouter"/><br>
    </form>
</body>
</html>
