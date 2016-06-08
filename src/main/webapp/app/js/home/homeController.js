define(['angular'],function(){

	console.log('home controller');

	var homeModule = angular.module('homeModule',[]);

	homeModule.controller('homeCtr',function($scope,httpService){

		console.log('homeCtr ...');

		$scope.name = "jay";
		
		
		$scope.wx = {
				appId:'get from db',
				appSecret:'get from db',
				token:''
		};
		

		$scope.fnGetToken = function(){
			
			httpService.get('/wechat/wx/token', $scope.wx).then(function(data){
				console.log('success');
				console.log(data);
				$scope.wx.token = data.obj;
			},function(data){
				console.log('error');
				console.log(data);
			});
			
		}
		
		
	});

});