<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details Article</title>
</head>
<body>
<h1>Detail de L'article</h1>
<%-- <c:forEach items="${list}" var="ar">
       <tr>
         <td>${ar.prix}</td>
         <td>${ar.Categorie}</td>
       </tr>
     </c:forEach> --%>
<c:forEach items="${listD}" var="arr" >   

<div>
<img   style="width:80pt; height:80pt;" src="${arr.photo}" /><br>
<label>Reference:</label>
<label>${arr.categorie}00${arr.prix}</label><br>
<label>Auteur:</label>
<label></label><br>
<label>Quantite en stock:</label>
<label>${arr.stock}</label><br>
</div>
<div>
<label>Titre:</label>
<label></label><br>
<label>Editeur:</label>
<label></label><br>
<label>Pour le prix modique de:</label>
<label>${arr.prix}</label><br>
</div>
</c:forEach>
<a href="CatalogueServ">Retour</a>
<a href="CatalogueServ">Ajouter au Panier</a>
</body>
</html>