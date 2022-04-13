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
    <div class="allinfo">
        <div class="info">
            <img width="300px" height="300px" src="data:image/jpeg;base64, <%= request.getAttribute("encode") %>"/>
            <p class="bigname">Nom : <%= request.getAttribute("name") %></p>
            <hr>
            <p class="bigprice">Prix : <%= request.getAttribute("price") %></p>
        </div>
        <div class="buy">
            <div class="user">
                <img src="image/login.svg" alt="test" width = "50">
                <p><%= request.getAttribute("username") %></p>
            </div>
            <hr>
            <p><%= request.getAttribute("description") %></p>
            <hr>
            <input class=bigbutton type="submit" name="Valider" value="ACHETER" />
        </div>
    </div>

    </body>
</html>
