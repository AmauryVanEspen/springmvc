<%-- 
    Document   : genre_lister
    Created on : 10 oct. 2016, 11:01:41
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${titre}</title>
    </head>
    <body>
        <h1>Genres disponibles</h1>
        <c:forEach items="${genres}" var="genre">
            ${genre.id} - ${genre.nom} 
            <a href="supprimer_genre/${genre.id}">Supprimer</a>
            <a href="modifier_genre/${genre.id}">Modifier</a><br>
        </c:forEach>
    </body>
</html>
