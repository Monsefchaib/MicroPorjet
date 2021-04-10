<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.util.ArrayList" %>
        <%@page import="model.Articles" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
  <link rel="stylesheet" href="cataCss.css">

<meta charset="UTF-8">
<title>catalogue</title>
</head>
<body>
<div class="d-flex justify-content-center">
<h1>Catalogue des albums</h1>
</div>
<div class = "float-right">
	<form>
	<label>Change Currency :</label><br>
		<select id="languge" name="language" onchange="submit()">
			<option ></option>
			<option value="en_US" ${language == 'en' ? 'selected' : ''}>DOLLAR</option>
			<option value="fr_FR" ${language == 'fr' ? 'selected' : ''}>EURO</option>		
		</select>
	</form>
</div>
<form action="CatalogueServ" method="post">
<label>Choisissez le genre :</label>
<select name="musicType">
    <option ></option>
    <option >RAP</option>
    <option >BLUES</option>
</select>
    <input type="submit">
</form>
<div class="container">
  <div class="row">
    <div class="col-12">
		<table class="table table-image">
		  <thead>
		    <tr>
		      <th scope="col">REFERENCE</th>
		      <th scope="col">TITRE</th>
		      <th scope="col">AUTHEUR</th>
		      <th scope="col">PHOTO</th>
		      <th scope="col">PRIX</th>
		    </tr>
		  </thead>
		   <%
	ArrayList<Articles> array = (ArrayList<Articles>) request.getAttribute("list");
   for (Articles article : array) {
	   
       %>
        <% String string = article.getDesignation();
         String[] parts = string.split("\\|");
 		System.out.println(parts[0]);
 		System.out.println(parts[1]);

        		 %>
         <tbody>
		    <tr>
		      <th scope="row"><a href="DetailsArticleServ?id=<%= article.getCodeArticle() %>"> <%= article.getCategorie()+"00"+article.getCodeArticle() %></a>
		      </th>
		      <td><%= parts[1] %></td>
		      <td><%= parts[0] %></td>
		       <td class="w-25">
			      <img src="<%= article.getPhoto() %>" class="img-fluid img-thumbnail" alt="Sheep">
		      </td>
		
         <td> <fmt:formatNumber value="<%= article.getPrix() %>" type="currency"/> </td> 
		      <td><a href="#" >add article </a></td>
		    </tr>
		
		  </tbody>
           <%
     }
   
   
   %>
		</table>   
    </div>
  </div>
</div>
</body>
</html>