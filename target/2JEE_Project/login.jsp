<%--
  Created by IntelliJ IDEA.
  User: Soufian
  Date: 18/03/2022
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Se connecter</title>
</head>
<body>
    <h2>Se connecter</h2>
    <form>
        <input type="email" name="email" placeholder="Email"/></br>
        <input type="password" name="password" placeholder="Mot de Passe"/></br>
        <input type="checkbox" name="rememberMe" id="rememberMe"/>
            <label for="rememberMe">Se souvenir de moi</label></br>
        <input type="submit" name="signIn" value="Se connecter" />
    </form>
</body>
</html>