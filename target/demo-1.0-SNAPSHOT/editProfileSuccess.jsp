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
        <p class="success">Vos modification ont été effectués avec succès ! Veuillez vous <a href="login.jsp">reconnecter</a></p><br>

        <footer>
            <p> &copy; SUPINFO Paris </p>
        </footer>

    </body>
</html>
