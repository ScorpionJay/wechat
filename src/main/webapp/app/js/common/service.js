define(['angular'],function(){

	var module = angular.module('serviceModule',[]);

	module.factory('httpService',['$q','$http',function($q,$http){

		var httpService = {};

		var _query = function(method,url,params,data){
			var deferred = $q.defer();
			$http({
					method : method,
					url : url,
					params:params,
					data:data,
					headers: {'Content-Type': 'application/json;charset=UTF-8','X-Requested-With':'XMLHttpRequest'},
				}).success(function(data, status, headers, config) {
					deferred.resolve(data);
				}).error(function(reason, status, headers, config) {
					if(status==403){
						window.location.href="/login";
					}
					deferred.reject(reason);
				});
			return deferred.promise;
		}

		httpService.get = function(url,params){
			return _query('get',url,params);
		}

		httpService.post = function(url,params){
			return _query('post',url,params);
		}

		return httpService;
		
	}]);


});