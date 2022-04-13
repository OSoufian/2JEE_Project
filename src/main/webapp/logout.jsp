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
        <% session.invalidate(); %>
        <p class="success">Vous avez été déconnecté avec succès !</p><br>
        <p class="success">Retourner à la <a href="index.jsp">page d'accueil</a> !</p>

        <footer>
            <p> &copy; SUPINFO Paris </p>
        </footer>

    </body>
</html>
