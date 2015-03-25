 voteNoLivroApp.controller("LivroController",function($scope,$rootScope,LivroService, ApplicationService, VotoService){
	
	 $rootScope.disputa = {};	
	
	 $rootScope.getLivrosDisputa = function(){		
		LivroService.getLivrosDisputa({},
							 	function(response){
									var novaDisputa = response;
									if (novaDisputa.livro1 == undefined){
										$scope.liberaNovaVotacao($scope.chamaFormEmail());
									}else{
										$rootScope.disputa = novaDisputa;										
									}
								},
								function(error){
									alert('Erro ao tentar executar a busca dos livros');
									return;
								}
		);
	};
	
	$scope.chamaFormEmail =  function(){
		$rootScope.toggleModal();
	};
	
	$scope.liberaNovaVotacao = function(callback){
		VotoService.novaVotacao({},
				function(success,callback){
					callback();
				},
				function(error){
					alert('Erro ao tentar liberar nova votação');
				}
		);
	};
	
	$scope.initData =  function(){
		ApplicationService.init({},
								function(response){
									$scope.getLivrosDisputa();
								},
								function(error){
									alert('Erro ao tentar inicializar os dados dos livros.');
									return;
								}
		
		);
	};
	$scope.initData();
});
