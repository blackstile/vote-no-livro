angular.module('LivroService', ['ngResource'])
	.factory('LivroService', ['$resource', function($resource) {
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


