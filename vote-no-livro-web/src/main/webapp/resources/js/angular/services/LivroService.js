var modulo = angular.module('LivroService', ['ngResource']);

modulo.factory('LivroService', ['$resource', function($resource) {
  return $resource('/vote-no-livro/pages/livro/:action/:id', 
  {}, 
  {
	  getLivrosDisputa : {
	      method: 'GET',
	      isArray: false,
	      params: {
	  			action: 'disputa'
	      }
	}
  });
}]);

var moduloApp = angular.module('ApplicationService', ['ngResource']);
moduloApp.factory('ApplicationService', ['$resource', function($resource) {
	return $resource('/vote-no-livro/pages/view/:action/:id', 
	{}, 
	{
		init : {
			method: 'GET',
			isArray: false,
			params: {
				action: 'init'
			}
		}
	});
}]);

