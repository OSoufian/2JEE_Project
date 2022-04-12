<%@ page import="com.supinfo.datasource.MyDataSource" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>S'inscrire</title>
</head>
<body>
    <h1>Votre profil</h1>
    <form method="POST" action="edit">
        <p>Nom d'utilisateur : <input type="text" id="username" name="username" value="<%= session.getAttribute("username") %>"/></p>
        <p>Nom : <input type="text" id="name" name="name" value="<%= session.getAttribute("name") %>"/></p>
        <p>Prénom : <input type="text" id="firstName" name="firstName" value="<%= session.getAttribute("firstName") %>"/></p>
        <p>Email : <input type="email" id="email" name="email" value="<%= session.getAttribute("email") %>"/></p>
        <p>Code postal : <input type="text" id="zipCode" name="zipCode" value="<%= session.getAttribute("zipCode") %>"/></p>
        <input type="submit" id="edit" value="edit"/><br>
    </form>
</body>
</html>
