<%-- 
    Document   : modifier_genre
    Created on : 10 oct. 2016, 14:44:33
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ajout d'un film!</h1>
        <div>
            <c:set var="route">
                <spring:url value="/ajouter_film"/>
            </c:set>
            <table>
                <form:form action="${route}" modelAttribute="filmTitre">
                    <form:hidden path="id"/>
                    <tr>
                        <td>
                            <label>Titre du Film</label><br>
                            <form:input path="titre"/>
                        </td>
                        <td>
                            <label>Genre du Film</label><br>
                            <form:select path="genre.id"><form:options items="${genres}" itemLabel="nom" itemValue="id"></form:options></form:select>
                                </td>
                                <td>
                                    <label>Année de production du Film</label><br>
                            <form:input path="anneeProd"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Synopsis du Film</label><br>
                            <form:textarea path="synopsis"/>
                        </td>
                        <td>
                            <input type="submit" value="Ajouter"/>
                        </td>
                    </tr>
                </form:form>
            </table>
        </div>
    </body>
</html>
