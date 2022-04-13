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

            <p class="success" >Salut <%= session.getAttribute("username") %>, tu as été inscrit avec succès !</p>
            <p class="success">Clique <a href="login.jsp">ici</a>, pour te connecter !</p>

        <footer>
            <p> &copy; SUPINFO Paris </p>
        </footer>

    </body>
</html>