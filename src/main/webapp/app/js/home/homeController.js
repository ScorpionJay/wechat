define(['angular'],function(){

	console.log('home controller');

	var homeModule = angular.module('homeModule',[]);

	homeModule.controller('homeCtr',function($scope){

		console.log('homeCtr ...');

		$scope.name = "jay";

	});

});