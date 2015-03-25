 voteNoLivroApp.controller("LivroController",function($scope,$rootScope,LivroService, ApplicationService){
	$scope.disputa = {};	
	$scope.getLivrosDisputa = function(){		
		$rootScope.toggleModal = true;
		LivroService.getLivrosDisputa({},
							 	function(response, status){
									$scope.disputa = response;
									if ($scope.disputa.livro1 == undefined){
										alert('nao tem mais disputa');
									}
								},
								function(error){
									alert('Erro ao tentar executar a busca dos livros');
									return;
								}
		);
	};
	
	$scope.chamaFormEmail =  function(){
		alert('Formulario email');
	};
	
	$scope.initData =  function(){
		ApplicationService.init({},
								function(response){
								},
								function(error){
									alert('Erro ao tentar inicializar os dados dos livros.');
									return;
								}
		
		);
	};
	$scope.initData();
	$scope.getLivrosDisputa();
});
