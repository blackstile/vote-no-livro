voteNoLivroApp.controller('UsuarioController', function($scope, $rootScope, UsuarioService){
	
	$scope.salvarUsuario = function(){
		usuario = $scope.usuario;
		console.log( 'usuario', usuario)
		UsuarioService.salvar(usuario,
							function(success){
								console.log(angular.element('#usuario-alerta-sucesso').html());
								angular.element('#usuario-alerta-sucesso').show();
							},
							function(error){
								alert('Erro ao tentar salvar o usuario');
							}
		);
	}; 
});