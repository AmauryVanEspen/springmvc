<%-- 
    Document   : homepage
    Created on : 10 oct. 2016, 11:06:56
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div>${titre}</div>
        <div><a href="/springmvc/ajouter_film">Ajouter un Film</a></div>
        <div><a href="/springmvc/liste_films">Lister les Films</a></div>
        <div><a href="/springmvc/ajouter_genre">Ajouter un Genre</a></div>
        <div><a href="/springmvc/liste_genres">Lister les Genres</a></div>
    </body>
</html>
