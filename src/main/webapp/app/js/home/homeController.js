define(['angular'],function(){

	console.log('home controller');

	var homeModule = angular.module('homeModule',[]);

	homeModule.controller('homeCtr',function($scope,httpService){

		console.log('homeCtr ...');

		$scope.name = "jay";
		
		$scope.wxInfo = {};
		

		$scope.fnGetWxInfo = function(){
			$scope.title = "jay's test account";
			httpService.get('/wechat/wxManage/'+$scope.title ).then(function(data){
				console.log('success');
				console.log(data);
				$scope.wxInfo = data;
			},function(data){
				console.log('error');
				console.log(data);
			});
		}
		
		
		$scope.fnGetToken = function(){
			httpService.get('/wechat/wx/token', $scope.wxInfo).then(function(data){
				console.log('success');
				console.log(data);
				$scope.wxInfo.token = data.obj;
			},function(data){
				console.log('error');
				console.log(data);
			});
		}
		
		$scope.fnGetFollowers = function(){
			httpService.get('/wechat/wxManage/users').then(function(data){
				console.log('success');
				console.log(data);
				$scope.followers = data.obj;
			},function(data){
				console.log('error');
				console.log(data);
			});
		}
		
		$scope.fnGetMenus = function(){
			httpService.get('/wechat/wxManage/menus').then(function(data){
				console.log('success');
				console.log(data);
				$scope.menus = data.obj;
			},function(data){
				console.log('error');
				console.log(data);
			});
		}
		
		$scope.fnGetMeteials = function(){
			httpService.get('/wechat/wxManage/meteials').then(function(data){
				console.log('success');
				console.log(data);
				$scope.meteials = data;
			},function(data){
				console.log('error');
				console.log(data);
			});
		}
		
		
	});

});