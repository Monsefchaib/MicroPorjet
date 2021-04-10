<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
      
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="test.css">

<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<meta charset="UTF-8">
<title>acceuil</title>
</head>
<body>
 <div class="container">
      <div class="col-md-6 mx-auto text-center">
         <div class="header-title">
            <h1 class="wv-heading--title">
               Écouter, ça change tout
            </h1>
            <h2 class="wv-heading--subtitle">
			Magasin De Musique
            </h2>
         </div>
      </div>
      <div class="row">
         <div class="col-md-4 mx-auto">
            <div class="myform form ">
               <form action="InscrireServ" method="post" >
                  
                  <div class="form-group">
                     <input type="text" name="nom"  class="form-control my-input" id="nom" placeholder="Nom">
                  </div>
                  <div class="form-group">
                     <input type="text" name="prenom"  class="form-control my-input" id="prenom" placeholder="Prenom">
                  </div>
                  <div class="form-group">
                     <input type="text" name="adresse"  class="form-control my-input" id="adresse" placeholder="Adresse"><br>
                     <input type="text" name="codepostal"  class="form-control my-input" id="codepostal" placeholder="CodePostal">
                     <input type="text" name="ville"  class="form-control my-input" id="ville" placeholder="Ville">
                
                  </div>
                  <div class="form-group">
                     <input type="text" name="tel"  class="form-control my-input" id="tel" placeholder="Tel">
                  </div>
                  <div class="form-group">
                     <input type="email" name="email"  class="form-control my-input" id="email" placeholder="Email">
                  </div>
                   <div class="form-group">
                     <input type="password" name="password"  class="form-control my-input" id="motdepasse" placeholder="Mot De Passe">
                  </div>
                  <div class="text-center ">
                     <button type="submit" class=" btn btn-block send-button tx-tfm">S'inscrire</button>
                  </div>
                  <p class="small mt-3">En vous inscrivant, vous indiquez que vous avez lu et accepté les <a href="#" class="ps-hero__content__link">Conditions d'utilisation</a> et <a href="#">Politique de confidentialité</a>.
                  </p>
               </form>
            </div>
         </div>
      </div>
   </div>
</body>
</html>