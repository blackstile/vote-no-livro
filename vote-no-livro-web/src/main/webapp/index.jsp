<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="pt-BR" data-ng-app="voteNoLivroApp">
<head>
<meta charset="UTF-8">
<title>Vote no Livro</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->


<script type="text/javascript" src='<spring:url value="/resources/js/jquery/jquery-1.11.2.min.js" />'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/angular/angular.min.js" />'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/angular/angular-resource.min.js" />'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/angular/VoteNoLivroApplication.js" />'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/angular/controllers/ModalController.js" />'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/angular/controllers/LivroController.js" />'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/angular/services/LivroService.js" />'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/angular/controllers/VotoController.js" />'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/angular/services/VotoService.js" />'></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

<style type="text/css">
.vertical-center {
	display: flex;
	align-items: center;
}

.hcenter {
	text-align: center;
	margin: 0 auto;
}
</style>
</head>
<body>
	<header>
		<h1>
			<img width="225" height="125"
				src="http://g-ecx.images-amazon.com/images/G/01/kindle/miranda/photos/miranda-bookstack-horiz._V189854584_.jpg">
			Vote no Livro - Aqui sua opinião é importante
		</h1>
		<nav class="navbar navbar-default" data-role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#menu-navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Vote No Livro!</a>
			</div>
			<div class="collapse navbar-collapse" id="menu-navbar-collapse">
				<ul class="nav nav-tabs">
					<li><a href="#">Cadastre Seu Livro</a></li>
					<li><a href="#">Visualize o Ranking</a></li>
					<li><a href="#">Sobre</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<section data-ng-controller="LivroController">
		<article data-ng-controller="ModalController">
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="col-md-5" data-ng-controller="VotoController">
						<div class="thumbnail">
							<div class="caption">
								<h3>{{disputa.livro1.titulo}}</h3>
							</div>
							<img style="float: left" width="200" height="200"
								src='<spring:message code="livro.images.path" />/{{disputa.livro1.imagem}}' />
							<p>{{disputa.livro1.descricao}}</p>
							<div style="clear: both"></div>
							<p class="text-center">
								<a href="#" data-ng-click="votar(disputa, disputa.livro1)"
									class="btn btn-primary" data-role="button"><i
									class="glyphicon glyphicon-thumbs-up"></i> Votar</a>
							</p>
						</div>
					</div>
					<div class="col-md-2">
						<div class="vertical-center" style="height: 280px">
							<h1 class="hcenter">VS</h1>
						</div>
						<div style="clear: both"></div>
					</div>
					<div class="col-md-5 pull-right" data-ng-controller="VotoController">
						<div class="thumbnail">
							<div class="caption">
								<h3>{{disputa.livro2.titulo}}</h3>
							</div>
							<img style="float: left" width="200" height="200"
								src='<spring:message code="livro.images.path" />/{{disputa.livro2.imagem}}' />
							<p>{{disputa.livro2.descricao}}</p>
							<div style="clear: both"></div>
							<p class="text-center">
								<a href="#" data-ng-click="votar(disputa, disputa.livro2)" class="btn btn-primary pull-center" data-role="button">
								<i class="glyphicon glyphicon-thumbs-up"></i> Votar
								</a>
							</p>
						</div>
					</div>
					<div style="clear: both"></div>
				</div>
			</div>
			<modal title="Obrigado por participar!" visible="showModal">
				<form data-role="form">
					<div class="form-group">
						<label for="nome">Nome</label> <input type="text"
							class="form-control" id="nome" placeholder="Digite seu nome" />
					</div>
					<div class="form-group">
						<label for="email">Email address</label> <input type="email" class="form-control" id="email" placeholder="seu-email@test.com" />
					</div>
					<button type="submit" class="btn btn-primary">Enviar</button>
				</form>
			</modal>
		<button data-ng-click="toggleModal()" class="btn btn-default">Open modal</button>
		</article>
	</section>
	<script type="text/ng-template" id="modal.html">
		<div class="modal fade"> 
 		 	<div class="modal-dialog"> 
    			<div class="modal-content"> 
      				<div class="modal-header"> 
        				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> 
        				<h4 class="modal-title">{{ title }}</h4> 
      				</div> 
      				<div class="modal-body" ng-transclude></div> 
    			</div> 
  			</div> 
		</div>
	</script>
</body>
</html>
