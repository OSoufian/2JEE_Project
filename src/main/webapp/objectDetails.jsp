<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SUP Bartering</title>
</head>
<body>
    <p>Nom : <%= request.getAttribute("name") %></p>
    <p>Description  : <%= request.getAttribute("description") %></p>
    <p>Prix : <%= request.getAttribute("price") %></p>
    <p>Vendu par :  <%= request.getAttribute("username") %>
    <img width="300px" height="300px" src="data:image/jpeg;base64, <%= request.getAttribute("encode") %>"/>
</p>

</body>
</html>
