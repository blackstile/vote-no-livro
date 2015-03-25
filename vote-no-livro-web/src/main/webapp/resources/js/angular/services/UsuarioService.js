angular.module('UsuarioService',['ngResource'])
	.factory('UsuarioService', ['$resource', function($resource){
		return $resource('/vote-no-livro/pages/usuario/:action/:id',
		{},
		{
			salvar : {
				method: 'POST',
				isArray: false,
				params: {
					action: 'save'
				}
			}
		});
	}]);