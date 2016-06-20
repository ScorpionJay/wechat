define(['angular','angular-bootstrap','ckeditor'],function(){

	'use strict';

	// article controller module
	var articleController = angular.module('ArticleCtrl', ['ui.bootstrap']);

	// article controller
	articleController.controller('articleCtrl',['$scope','httpService','$sce','$log','$http',function($scope,httpService,$sce,$log,$http){

			//$scope.currentPage = 0;
			$scope.maxSize = 5;
			$scope.itemsPerPage = 9;
			
			httpService.get('api/article/getArticles',{page:1,size:$scope.itemsPerPage}).then(function(data){
				console.log(data);
				$scope.articles= data.data;
				$scope.totalItems = data.totalItems;
			});

			$scope.trust = function(html){
				return $sce.trustAsHtml(html);
			};

			$scope.setPage = function (pageNo) {
			    $scope.currentPage = pageNo;
			};

			// 分页
			$scope.pageChanged = function() {
				console.log($scope.currentPage);
			    $log.log('Page changed to: ' + $scope.currentPage);
			    httpService.get('api/article/getArticles',{page:$scope.currentPage,size:$scope.itemsPerPage}).then(function(data){
			    	console.log(data);
					$scope.articles= data.data;
					$scope.totalItems = data.totalItems;
				});
		    };
	
	}]);


	// article detail controller
	articleController.controller('articleDetailCtrl',['$scope','httpService','$sce','$routeParams',function($scope,httpService,$sce,$routeParams){
			console.log($routeParams.id);
			httpService.get('api/article/getArticleById',{id:$routeParams.id}).then(function(data){
			 	console.log(data);
			 	$scope.article = data;
			});

			$scope.trust = function(html){
				return $sce.trustAsHtml(html);
			};
	}]);

	
	// new article controller
	articleController.controller('newArticleCtrl',['$scope','httpService','$sce','$routeParams','$http',function($scope,httpService,$sce,$routeParams,$http){
		
		 $scope.fnGetContent =  function() {
				var editor = CKEDITOR.instances.editor1;
				console.log( editor.getData() );
				var content = editor.getData();
			
				var data = {
						title:" 文章标题"+new Date(),
						summary:content,
						content:content,
				};
				
				httpService.post('api/article/saveArticle',null,data).then(function(data){
				 	console.log(data);
				});
				
//				$http.post('api/article/saveArticle', data).success(function (result, status, headers) {
//					console.log(result);
//				}).error(function(reason, status, headers, config) {
//				});
				
			};
	}]);
	

});// end for define