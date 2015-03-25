voteNoLivroApp.controller('VotoController', function($scope, $rootScope, VotoService, LivroService) {

	
	$scope.votar = function(disputa, livroEscolhido) {

		var voto = {
			primeiraOpcao : disputa.livro1,
			segundaOpcao : disputa.livro2,
			opcaoEscolhida : livroEscolhido
		};

		VotoService.votar(voto, 
			function(success) {
				$rootScope.getLivrosDisputa();					
			}, function(error) {
				alert('erro ao registrar voto');
			}
		);
	};

	$scope.configurarPerdedor = function(disputa, livroEscolhido) {
		if (disputa.livro1.id == livroEscolhido.id) {
			$scope.disputa.perdedor2 = true;
		} else {
			$scope.disputa.perdedor1 = true;
		}
		$scope.votar(disputa, livroEscolhido);
	};

});