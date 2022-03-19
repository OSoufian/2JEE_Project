<%--
  Created by IntelliJ IDEA.
  User: Soufian
  Date: 18/03/2022
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page d'inscription</title>
</head>
<body>
    <h2>S'inscrire</h2>
    <input type="text" name="name" placeholder="Nom"/></br>
    <input type="text" name="firstName" placeholder="Prénom"/></br>
    <input type="email" name="email" placeholder="E-mail"/></br>
    <input type="text" name="zipCode" placeholder="Code Postal"/></br>
    <input type="password" name="password" placeholder="Mot de Passe"/></br>
    <input type="password" name="confirmPassword" placeholder="Confirmation Mot de Passe"/></br>
    <input type="checkbox" name="agreeTerm" id="agreeTerm"/>
        <label for="agreeTerm">J'ai lu et j'accepte les conditions d'utilisation</label></br>
    <input type="submit" name="signUp" value="S'inscrire"/>
</body>
</html>
