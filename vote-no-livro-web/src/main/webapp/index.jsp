<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="pt-BR" data-ng-app="voteNoLivroApp">
<head>
<meta charset="UTF-8">
<title>Vote no Livro</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">

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
<script type="text/javascript" src='<spring:url value="/resources/js/angular/controllers/UsuarioController.js" />'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/angular/services/UsuarioService.js" />'></script>
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
img.desaturate{
-webkit-filter: grayscale(1); -webkit-filter: grayscale(100%);
filter: gray; filter: grayscale(100%);
filter: url(desaturate.svg#greyscale);
}
.lead{
	font-size:16px;
}
.titulo{
	border-bottom:3px solid #333;
}
.ranking-geral{
	background-color:#f8f8f8 !important;
}
.meus-votos{
	background-color:#f0f0f0 !important;
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
				<a class="navbar-brand" href="#" data-ng-click="visualizarVotacao();">Vote No Livro!</a>
			</div>
			<div class="collapse navbar-collapse" id="menu-navbar-collapse">
				<ul class="nav nav-tabs">
					<li><a href="#" data-ng-click="visualizarRanking()">Visualize o Ranking</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<section data-ng-controller="LivroController">
		<article id="voto-container">
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="col-md-5" data-ng-controller="VotoController">
						<div class="thumbnail">
							<div class="caption">
								<h3>{{disputa.livro1.titulo}}</h3>
							</div>
							<img style="float: left; width:200px; height:300px;" class="img-thumbnail" data-ng-class="{desaturate : disputa.perdedor1}" src='<spring:message code="livro.images.path" />/{{disputa.livro1.imagem}}' />
							<p class="lead">{{disputa.livro1.descricao}}</p>
							<p class="text-center">
								<a href="#" data-ng-click="configurarPerdedor(disputa, disputa.livro1)"
									class="btn btn-primary" data-role="button"><i
									class="glyphicon glyphicon-thumbs-up"></i> Votar</a>
							</p>
							<div style="clear: both"></div>
						</div>
					</div>
					<div class="col-md-2">
						<div class="vertical-center" style="height: 300px">
							<h1 class="hcenter">VS</h1>
						</div>
						<div style="clear: both"></div>
					</div>
					<div class="col-md-5 pull-right" data-ng-controller="VotoController">
						<div class="thumbnail">
							<div class="caption">
								<h3>{{disputa.livro2.titulo}}</h3>
							</div>
							<img style="float: left; width:200px; height:300px;" class="img-thumbnail" data-ng-class="{desaturate : disputa.perdedor2}"src='<spring:message code="livro.images.path" />/{{disputa.livro2.imagem}}' />
							<p class="lead">{{disputa.livro2.descricao}}</p>
							<p class="text-center">
								<a href="#" data-ng-click="configurarPerdedor(disputa, disputa.livro2)" class="btn btn-primary pull-center" data-role="button">
								<i class="glyphicon glyphicon-thumbs-up"></i> Votar
								</a>
							</p>
							<div style="clear: both"></div>
						</div>
					</div>
					<div style="clear: both"></div>
				</div>
			</div>
			<span class="anchor" id="anchor-votar"></span>
		</article>
		<article id="ranking-container" style="display:none;">
			<div class="container-fluid meus-votos">
				<div class="row-fluid">
					<div class="col-md-6" data-ng-controller="VotoController">
						<div class="caption titulo">
								<h3>Ranking - Meus Votos</h3>
						</div>
						<div data-ng-repeat="voto in meusVotos|orderBy : 'quantidadeVotos' : true">
							<div class="lead">
								<img style="float: left; width:50px; height:75px;" class="img-thumbnail" src='<spring:message code="livro.images.path" />/{{voto.livro.imagem}}' />
								<p><span>{{voto.livro.titulo}}</span></p>
								<p><span>Total de Votos: <strong>{{voto.quantidadeVotos}}</strong></span></p>
								<div style="clear: both; border-bottom:2px solid #333;"></div>
							</div>
						</div>
						<div style="clear: both"></div>
					</div>
				</div>
			</div>	
			<div class="container-fluid ranking-geral">
				<div class="row-fluid">
					<div class="col-md-6" data-ng-controller="VotoController">
						<div class="caption titulo">
								<h3>Ranking - Votação Geral</h3>
						</div>
						<div data-ng-repeat="voto in ranking | orderBy : 'quantidadeVotos' : true">
							<div class="lead">
								<img style="float: left; width:50px; height:75px;" class="img-thumbnail" src='<spring:message code="livro.images.path" />/{{voto.livro.imagem}}' />
								<p><span>{{voto.livro.titulo}}</span></p>
								<p><span>Total de Votos: <strong>{{voto.quantidadeVotos}}</strong></span></p>
								<div style="clear: both; border-bottom:2px solid #333;"></div>
							</div>
						</div>
						<div style="clear: both"></div>
					</div>
				</div>
			</div>
		</article>
		<modal title="Obrigado por participar ;)" visible="showModal" >
			<form data-role="form" method="post" name="userForm"  data-ng-controller="UsuarioController">
				<div class="form-group" data-ng-class="{ 'has-error': userForm.nome.$invalid && userForm.nome.$dirty }" >
					<label for="nome">Nome</label> <input type="text" data-ng-model="usuario.nome" required class="form-control" id="nome" placeholder="Digite seu nome" />
				</div>
				<div class="form-group" ng-class="{ 'has-error': userForm.email.$invalid && userForm.email.$dirty }">
					<label for="email">Email address</label> <input type="email" required data-ng-model="usuario.email" class="form-control" id="email" placeholder="seu-email@test.com" />
				</div>
				<div id="usuario-alerta-sucesso" class="alert alert-success" style="display: none" role="alert">Dados salvo com sucesso</div>
				<div class="alert alert-info" id="message-close" style="display: none" role="alert"></div>
				<button type="submit" class="btn btn-primary" data-ng-click="salvarUsuario(usuario)">Enviar</button>
			</form>
		</modal>
	</section>
	<script type="text/ng-template" id="modal.html">
		<div class="modal fade"> 
 		 	<div class="modal-dialog"> 
    			<div class="modal-content"> 
      				<div class="modal-header"> 
        				<button type="button" id="closeButton" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> 
        				<h4 class="modal-title">{{ title }}</h4> 
      				</div> 
      				<div class="modal-body" ng-transclude></div> 
    			</div> 
  			</div> 
		</div>
	</script>
</body>
</html>
