define(['angular','route','home/homeController'
	,'accout/accoutController'
	,'login/controller','common/service'],function(){

	console.log('app');

	var app = angular.module('app',['ngRoute',
		'homeModule',
		'accoutModule','loginModule','serviceModule']);

	app.config(function($routeProvider, $locationProvider){

		$routeProvider
			.when('/home',{
				templateUrl:'app/js/home/home.html',
				controller:'homeCtr'
			})
			.when('/accout',{
				templateUrl:'app/js/accout/accout.html',
				controller:'accoutCtr'
			})
			.when('/login',{
				templateUrl:'app/js/login/index.html',
				controller:'loginCtr'
			})
			.otherwise('/home');

        $locationProvider.html5Mode({
			  enabled: false,
			  requireBase: false
			});
	});

	
	// 3. run	
	app.run(['$rootScope', '$location', function($rootScope) {
        $rootScope.$on('$routeChangeSuccess', function(newV) {
        	window.scrollTo(0,0);// to top
        });
//        $rootScope.$on('$routeChangeStart', function(newV) {
//        	window.scrollTo(0,0);// to top
//        });
    }]);
	
	
	// 自定义格式化
	app.filter('testFilter',function(){
		return function(text,str) {
		      // filters need to be forgiving so check input validity
		      return text + " filter by jay" + str;
		    };
	});
	
	app.filter('nickFilter',function(){
		return  function(nickName){
			if(nickName){
				if(nickName.length<=2){
					return "*";
				}else{
					return nickName.substring(0, 1)+"***"+nickName.substring(nickName.length-1, nickName.length)
				}
			}else{
				return "*"
			}
		}
	});

	

});