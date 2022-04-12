<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SUP Bartering</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <p>Salut <%= session.getAttribute("username") %>, tu as été inscrit avec succès !</p>
    <p>Clique <a href="login.jsp">ici</a>, pour te connecter !</p>
</body>
</html>
