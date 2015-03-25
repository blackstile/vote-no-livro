voteNoLivroApp.controller('ModalController', function ($scope, $rootScope) {
	$scope.showModal = false;
	$rootScope.toggleModal = function(){
		$scope.showModal = !$scope.showModal;
//		console.log($scope.showModal);
    };
  }).directive('modal', function ($rootScope) {
    return {
      templateUrl: 'modal.html',
      restrict: 'E',
      transclude: true,
      replace:true,
      scope:true,
      controller: 'ModalController',
      link: function postLink(scope, element, attrs) {
        scope.title = attrs.title;

        scope.$watch(attrs.visible, function(value){
          if(value == true)
            $(element).modal('show');
          else
            $(element).modal('hide');
        });

        $(element).on('shown.bs.modal', function(){
          scope.$apply(function(){
            scope.$parent[attrs.visible] = true;
          });
        });

        $(element).on('hidden.bs.modal', function(){
          scope.$apply(function(){
            scope.$parent[attrs.visible] = false;
            $rootScope.toggleModal();
          });
        });
      }
    };
  });