var voteNoLivroApp = angular.module('voteNoLivroApp',['LivroService','ApplicationService', 'VotoService']);

angular.module('ApplicationService', ['ngResource'])
	.factory('ApplicationService', ['$resource', function($resource) {
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