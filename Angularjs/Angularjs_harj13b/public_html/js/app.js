function ShopCtrl($scope) {
    
	$scope.items = [
		{id: 1, text: 'Cheese - 200g', bought: false},
		{id: 2, text: 'Bread', bought: true},
		{id: 3, text: 'Onions x4', bought: false}
	];

	$scope.clearBought = function() {
		$scope.items = _.filter($scope.items, function(item) {
			return !item.bought;
		});
	}

	$scope.addItem = function() {
		$scope.items.push({text: $scope.itemEntry, bought: false, id: ($scope.items.length + 1) });
		$scope.itemEntry = '';
	}

	$scope.isBought = function(bought) {
		return (bought) ? 'bought' : 'not-bought';
	}
}