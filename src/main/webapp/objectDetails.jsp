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
                <img width="300px" src="data:image/jpeg;base64, <%= request.getAttribute("encode") %>"/>
                <p class="bigname"><%= request.getAttribute("name") %></p>
                <hr>
                <p class="bigprice"><%= request.getAttribute("price") %> €</p>
            </div>
            <div class="buy">
                <div class="user">
                    <img src="image/login.svg" alt="test" width = "50">
                    <div>
                        <p class="username"><%= request.getAttribute("username") %></p><br>
                        <p><%= request.getAttribute("email") %></p>
                    </div>
                </div>
                <hr>
                <p><%= request.getAttribute("description") %></p>
            </div>
        </div>

    </body>
</html>
