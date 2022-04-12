<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>Salut <%= session.getAttribute("username") %>, tu as été inscrit avec succès !</p>
    <p>Clique <a href="login.jsp">ici</a>, pour te connecter !</p>
</body>
</html>
