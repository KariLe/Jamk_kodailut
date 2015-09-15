var app = angular.module('myApp',['SharedServices']);

angular.module('SharedServices', [])
    .config(function ($httpProvider) {
        $httpProvider.responseInterceptors.push('myHttpInterceptor');
        var spinnerFunction = function (data, headersGetter) {
            // todo start the spinner here
            $('#loading').show();
            return data;
        };
        $httpProvider.defaults.transformRequest.push(spinnerFunction);
    })
// register the interceptor as a service, intercepts ALL angular ajax http calls
    .factory('myHttpInterceptor', function ($q, $window) {
        return function (promise) {
            return promise.then(function (response) {
                // do something on success
                // todo hide the spinner
                $('#loading').hide();
                return response;

            }, function (response) {
                // do something on error
                // todo hide the spinner
                $('#loading').hide();
                return $q.reject(response);
            });
        };
    });





function ShopCtrl($scope, $http) {

	$http({ method: 'GET', url: '/angularB/shop/', cache: true }).
		success(function(data, status) {
			$scope.items = data
		}).
		error(function(data, status) {
			console.log('Status: ' + status);
		});

	$scope.clearBought = function() {
		$scope.items = _.filter($scope.items, function(item) {
			if(item.bought) {
				$http.delete('/rest/shop/' + item.id).error(function(data, status) {
					console.log(status);
				});
			}
			return !item.bought;
		});

	}

	$scope.addItem = function() {
		$http.post('/rest/shop', { text: $scope.itemEntry } ).success(function(data, status) {
			if(data) {
				var last = _.last($scope.items);
				$scope.items.push({text: $scope.itemEntry, bought: false, id: (last.id + 1) });
				$scope.itemEntry = '';
				console.log($scope.items);
			} else {
				console.log('There was a problem. Status: ' + status + '; Data: ' + data);
			}
		}).error(function(data, status) {
			console.log('status: ' + status);
		});
		
	}

	$scope.isBought = function(bought) {
		return (bought) ? 'bought' : 'not-bought';
	}

}