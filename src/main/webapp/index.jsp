<%@ page import="com.supinfo.DAO.ObjectEntityDAO" %>
<%@ page import="com.supinfo.Dto.ObjectEntityDto" %>
<%@ page import="java.util.List" %>
<%@ page import="com.supinfo.DAO.UserEntityDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>SUP Bartering</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <header>
            <div class="header">
                <a href="index.jsp">
                    <div class="logo">
                        <img src="image/logo.png" alt="test" width = "300">
                    </div>
                </a>

                <div class="search">
                    <form method="POST" action="searchObjects">
                        <input type="text" name="input" placeholder="Rechercher un produit...">
                        <input type="image" type="submit" name="search" src="image/search.svg" alt="search" width = "20"/>
                    </form>
                </div>

                <div class="subnavbar">
                    <% if (session.getAttribute("username") != null) { %>
                        <div class="itemsnv">
                            <a href="profile.jsp">
                                <input type="image" name="login" src="image/login.svg" alt="Logout" width = "50"/>
                                <p><%= session.getAttribute("username") %></p>
                            </a>
                        </div>
                        <div class="itemsnv">
                            <a href="logout.jsp">
                                <input type="image" name="login" src="image/deconnexion.png" alt="Logout" width = "50"/>
                                <p>Déconnexion</p>
                            </a>
                        </div>
                        <div class="itemsnv manage">
                            <a href="objects.jsp">
                                <input type="image" name="manage" src="image/cube.svg" alt="Manage object" width = "50">
                                <p>Gerer vos objets</p>
                            </a>
                        </div>
                    <% } else { %>
                    <div class="itemsnv">
                        <a href="register.jsp">
                            <input type="image" name="login" src="image/login.svg" alt="Logout" width = "50"/>
                            <p>S'inscrire</p>
                        </a>
                    </div>
                    <div class="itemsnv">
                        <a href="login.jsp">
                            <input type="image" name="login" src="image/login.svg" alt="Logout" width = "50"/>
                            <p>Se connecter</p>
                        </a>
                    </div>
                    <% } %>

                </div>
            </div>
        </header>

        <div class=presentation>
            <img id=ban src="image/echange.jpg" alt="banniere">
            <div class=sous-titre>
                <h2>LE site pour faire de bonnes affaires ! ( ou pas... )</h2>
            </div>
        </div>

        <div class="stats" >
            <div class="first">
                <img src="image/stat.png" alt="banniere" width = "400">
                <p>Nombre d'utilisateurs</p>
                <p class="numstat"><% out.print(new UserEntityDAO().statistics()); %></p>
            </div>
            <div class="first">
                <img src="image/stat.png" alt="banniere" width = "400">
                <p>Nombre d'objets en vente</p>
                <p class="numstat"><% out.print(new ObjectEntityDAO().statistics()); %></p>
            </div>
        </div>

        <div class="separation">
            <h2> EN VENTE ! </h2>
            <img src="image/minilogo.svg" alt="banniere" width = "70">
        </div>

        <div class="objectspreviews">
            <%
                List<ObjectEntityDto> objects;
                if (request.getAttribute("objects") == null) {
                    objects = new ObjectEntityDAO().getAllObjects();
                } else {
                    objects = (List<ObjectEntityDto>) request.getAttribute("objects");
                }
            %>
            <c:forEach var="object" items="<%= objects %>">
                <div class="preview">
                    <img src="data:image/jpeg;base64,${object.encode}" width = "300"/>
                    <p class="name"> <c:out value="${object.name}"/> </p>
                    <p class="price"> <c:out value="${object.price}"/>  € </p>
                    <p>Mis en vente par : <c:out value="${object.user.username}"/> </p>
                    <form method="POST" action="objectDetails">
                        <input type="hidden" name="objectId" value="${object.id}"/><br>
                        <input type="submit" value="VOIR" class="submit"/>
                    </form>
                </div>
            </c:forEach>
        </div>

        <footer>
            <p> &copy; SUPINFO Paris </p>
        </footer>
    </body>
</html>