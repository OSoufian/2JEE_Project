<%@ page import="com.supinfo.DAO.ObjectEntityDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <% String userId = (String) session.getAttribute("id"); %>

        <div class="objectspreviews">
            <c:forEach var="object" items="<%= new ObjectEntityDAO().getUserObjects(userId) %>">
                <div class="preview">
                    <img width="300px" height="300px" src="data:image/jpeg;base64,${object.encode}"/>
                    <p class="name"> <c:out value="${object.name}"/> </p>
                    <form method="POST" action="deleteObject">
                        <input type="hidden" name="objectId" value="${object.id}"/><br>
                        <input type="submit" value="Supprimer" class="delete"/>
                    </form>
                    <button type="button">VOIR</button>
                </div>
            </c:forEach>
                <a href="addObject.jsp" class="plus">
                    <img src="image/plus.png" alt="Ajouter une image"/><br>
                </a>
        </div>


        <footer>
            <p> &copy; SUPINFO Paris </p>
        </footer>

    </body>
</html>