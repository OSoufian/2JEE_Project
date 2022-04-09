<%@ page import="com.supinfo.datasource.MyDataSource" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>S'inscrire</title>
</head>
<body>
    <h1>Votre profil</h1>
    <form method="POST" action="edit">
        <p>Nom d'utilisateur : <input type="text" id="username" name="username" placeholder="<%= session.getAttribute("username") %>"/></p>
        <p>Nom : <input type="text" id="name" name="name" placeholder="<%= session.getAttribute("name") %>"/></p>
        <p>Prénom : <input type="text" id="firstName" name="firstName" placeholder="<%= session.getAttribute("firstName") %>"/></p>
        <p>Email : <input type="email" id="email" name="email" placeholder="<%= session.getAttribute("email") %>"/></p>
        <p>Code postal : <input type="text" id="zipCode" name="zipCode" placeholder="<%= session.getAttribute("zipCode") %>"/></p>
        <input type="submit" id="edit" value="edit"/><br>
    </form>
</body>
</html>
