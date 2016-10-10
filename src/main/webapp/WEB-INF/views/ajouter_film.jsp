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
            <form:form action="${route}" modelAttribute="filmTitre">
                <form:hidden path="id"/>
                <label>Titre du Film</label>
                <form:input path="titre"/>
                <br>
                <input type="submit" value="Ajouter"/>
            </form:form>
        </div>
    </body>
</html>
