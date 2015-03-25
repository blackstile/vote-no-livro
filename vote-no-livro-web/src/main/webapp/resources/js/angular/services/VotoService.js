var modulo = angular.module('VotoService', ['ngResource']);

modulo.factory('VotoService', ['$resource', function($resource) {
  return $resource('/vote-no-livro/pages/voto/:action/:id', 
  {}, 
  {
	  votar : {
		  method: 'POST',
		  isArray: false,
		  params: {
			  action: 'salvar'
		  }
	  },
	  novaVotacao : {
	      method: 'GET',
	      isArray: false,
	      params: {
	  			action: 'nova-votacao'
	      }
	  }
  });
}]);
