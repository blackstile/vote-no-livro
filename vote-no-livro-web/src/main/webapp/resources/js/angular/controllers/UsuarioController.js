voteNoLivroApp.controller('UsuarioController', function($scope, $rootScope, $timeout, $interval, UsuarioService){
	
	$scope.salvarUsuario = function(){
		var usuario = $scope.usuario;
		UsuarioService.salvar(usuario,
							function(success){
								angular.element('#usuario-alerta-sucesso').show();
								
								$rootScope.visualizarRanking();
								$timeout(function(){
									angular.element('#closeButton').click();
								}, 6000);
								var count = 5;
								var iclose = undefined;
								
								iclose = $interval(function(){
									angular.element('#message-close').show();
									angular.element('#message-close').text("A vai fechar em " +  (--count) + " segundos");
									if (count == 0){
										if (iclose){
											$interval.cancel(iclose);
										}
										count = 5;
									}
									count;
								}, 1000);
							},
							function(error){
								alert('Erro ao tentar salvar o usuario');
							}
		);
	}; 
});