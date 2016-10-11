<%-- 
    Document   : film_lister
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
        <h1>Films disponibles</h1>
    <table>
        <c:forEach items="${films}" var="film">
            <tr>
                <td>${film.titre}</td>
                <td><a href="supprimer_film/${film.id}">Supprimer</a></td>
                <td><a href="modifier_film/${film.id}">Modifier</a></td>
            </tr>
            <tr>
                <td> ${film.anneeProd} </td><td> ${film.genre.nom} </td><td> ${film.synopsis}</td>
            </tr>
    </c:forEach>
</table>
</body>
</html>
