voteNoLivroApp.controller('VotoController', function($scope, $rootScope, VotoService){
	
	$scope.votar =  function(disputa,livroEscolhido){
		var voto = {
				primeiraOpcao : disputa.livro1,
				segundaOpcao : disputa.livro2,
				opcaoEscolhida : livroEscolhido
		};
		
		console.log('voto', voto);
		VotoService.votar(voto,
						 	function(success){
								alert('success');
							},
							function(error){
								alert('erro ao registrar voto');
							}
		);
	};
	
});