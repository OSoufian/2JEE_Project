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
                    <c:out value="${object.name}"/>
                    <img width="300px" height="300px" src="data:image/jpeg;base64,${object.encode}"/>
                    <form method="POST" action="deleteObject">
                        <input type="hidden" name="objectId" value="${object.id}"/><br>
                        <input type="submit" value="Supprimer" class="delete"/>
                    </form>
                </div>
            </c:forEach>
            <div class="plus">
                <a href="addObject.jsp">
                    <img src="image/plus.png" alt="Ajouter une image"/><br>
                </a>
            </div>
        </div>


        <footer>
            <p> &copy; SUPINFO Paris </p>
        </footer>

    </body>
</html>