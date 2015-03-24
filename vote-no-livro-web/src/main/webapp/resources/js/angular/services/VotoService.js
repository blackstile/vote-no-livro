var modulo = angular.module('VotoService', ['ngResource']);

modulo.factory('VotoService', ['$resource', function($resource) {
  return $resource('pages/livro/:action/:id', 
  {}, 
  {
	  votar : {
	      method: 'post',
	      isArray: false,
	      params: {
	  			action: 'votar'
	      }
	}
  });
}]);
