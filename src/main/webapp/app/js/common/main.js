requirejs.config({
    //By default load any module IDs from js/lib
    baseUrl: './app/js/',
    //except, if the module ID starts with "app",
    //load it from the js/app directory. paths
    //config is relative to the baseUrl, and
    //never includes a ".js" extension since
    //the paths config could be for a directory.
    paths: {
        jquery: 'lib/jquery/jquery'
        ,angular:'lib/angular/angular'
        ,route:'lib/angular-route/angular-route'
        ,bootstrap:'lib/bootstrap/js/bootstrap'
        ,util:'common/util'
    },

    shim:{
    	route: {
            deps: ['angular'],
        },
        bootstrap: {
            deps: ['jquery'],
        },
        angular: {
            exports: 'angular'
        },
        util: {
            exports: 'util'
        },
    }

});

// Start the main app logic.
requirejs(['jquery', 'angular','common/app','bootstrap'],
function   () {
	console.log('jquery version: ' + $.fn.jquery);
	console.log('angular version: ' + angular.version.full);
	angular.bootstrap(document, ['app']);
});