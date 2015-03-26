voteNoLivroApp.controller("LivroController",
		function($scope, $rootScope, $anchorScroll, $location, LivroService,
				ApplicationService, VotoService) {

			$rootScope.disputa = {};
			$scope.ranking = {};
			$scope.meusVotos = {};

			$rootScope.getLivrosDisputa = function() {
				LivroService.getLivrosDisputa({}, function(response) {
					var novaDisputa = response;
					if (novaDisputa.livro1 == undefined) {
						$scope.liberaNovaVotacao($scope.chamaFormEmail());
					} else {
						$rootScope.disputa = novaDisputa;
						window.location.hash = "anchor-votar";
						$location.hash('anchor-votar');
					}
				}, function(error) {
					alert('Erro ao tentar executar a busca dos livros');
					return;
				});
			};

			$scope.chamaFormEmail = function() {
				$rootScope.toggleModal();
			};

			$scope.liberaNovaVotacao = function(callback) {
				VotoService.novaVotacao({}, function(success, callback) {
					callback();
				}, function(error) {
					alert('Erro ao tentar liberar nova votação');
				});
			};
			
			$rootScope.visualizarRanking =  function(){
				angular.element('#ranking-container').show();
				angular.element('#voto-container').hide();				
				$scope.getRanking($scope.getMeusVotos());
			};
			
			$rootScope.visualizarVotacao =  function(){
				angular.element('#ranking-container').hide();
				angular.element('#voto-container').show();
				$scope.getLivrosDisputa();
				
			};
			
			$scope.getRanking = function(callback) {
				VotoService.getRanking({}, 
						function(success, callback) {
							$scope.ranking = success;
							callback();
						}, 
						function(error) {
							alert('Error ao tentar buscar o ranking');
						});
			};
			$scope.getMeusVotos = function() {
				VotoService.getMeusVotos({}, 
						function(success) {
					$scope.meusVotos = success;
				}, 
				function(error) {
					alert('Error ao tentar buscar o ranking')
				});
			};
			$scope.initData = function() {
				ApplicationService.init({}, function(response) {
					$scope.getLivrosDisputa();
				}, function(error) {
					alert('Erro ao tentar inicializar os dados dos livros.');
					return;
				}

				);
			};
			$scope.initData();
		});
