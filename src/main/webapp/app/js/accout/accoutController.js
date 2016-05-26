define(['angular','util'],function(angular,util){

	console.log('accout controller');

	var homeModule = angular.module('accoutModule',['serviceModule']);

	homeModule.controller('accoutCtr',function($scope,httpService){

		console.log('accoutCtr ...');

		$scope.money = 130012;

		util.date();

		console.log(httpService);

		httpService.get('app/json/test.json').then(function(data){
			console.log('success');
			console.log(data);
			$scope.data = data;

		},function(data){
			console.log('error');
			console.log(data);
		});

	});

});