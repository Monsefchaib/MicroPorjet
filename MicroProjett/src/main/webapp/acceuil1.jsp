<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
  <link rel="stylesheet" href="cataCss.css">
<meta charset="UTF-8">
<title>acceuil1</title>
</head>
<body>
<h1>Bonjour Monsieur ${ sessionScope.fullname} </h1>
<a href="CatalogueServ" >Consulter Le Catalogue</a><br>
<a href="#" >Suivre Vos Commandes</a><br>
<a href="#" >Visualiser Le Panier</a><br>

</body>
</html>