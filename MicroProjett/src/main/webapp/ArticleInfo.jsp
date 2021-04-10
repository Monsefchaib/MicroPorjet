<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.util.ArrayList" %>
        <%@page import="model.Articles" %>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
  <link rel="stylesheet" href="InfoCss.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="container my-4">


     <hr class="mt-5">

	<h1>Details Album :</h1>

  <hr class="mb-5"/>
</div>
<c:forEach items="${listD}" var="arr" > 
<div class="d-flex justify-content-center">
 <div class="card" style="max-width: 20rem;">

        <!-- Card image -->
        <img class="card-img-top" src="${arr.photo}" alt="Card image cap">

        <!-- Card content -->
        <div class="card-body text-white rgba-black-light p-2">
         
        </div>

      </div> 
      </div>
 <div class="d-flex justify-content-center">
 <div class="row">
     <div class="col">
 <c:set var="parts" value="${fn:split(arr.designation, '|')}" />
<h3>Reference:</h3>
<input type="text" id="country" name="country" value="${arr.categorie}00${arr.codeArticle}" readonly><br>
<h3>Auteur:</h3>
  <input type="text" id="country" name="country" value="${parts[0]}" readonly><br>
<h3>Quantite en stock:</h3>
<input type="text" id="country" name="country" value="${arr.stock}" readonly><br><br>
</div>
<div class="col">
<h3>Titre:</h3>
<input type="text" id="country" name="country" value="${parts[1]}" readonly><br>

<h3>Editeur:</h3>
<input type="text" id="country" name="country" value="${parts[2]}" readonly><br>
<h3>Pour le prix modique de:</h3>
<input type="text" id="country" name="country" value="${arr.prix}" readonly><br><br>
</div>
</div>
</div>
</c:forEach>
<p class="text-right">
<a href="CatalogueServ">Retour</a><br>
<a href="CatalogueServ">Ajouter au Panier</a>
</p>
</body>
</html>