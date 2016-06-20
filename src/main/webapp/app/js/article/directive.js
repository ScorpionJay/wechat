define(['angular','ckeditor'],function(){
	
	'use strict';
	
	// create a directive module
	var directiveModule = angular.module('articleDirectiveModule',[]);

	 // create a directive
	directiveModule.directive('myDriective',function(){
	  return {
	    restrict: 'E',
	    template: 'Name: {{user.name}} Address: {{user.age}}'
	  };

	});
	
	directiveModule.directive('ckeditor',function(){
		return function(scope,element,attrs){
				CKEDITOR.replace( 'editor1', {
					on: {
						//focus: onFocus,
						//blur: onBlur,
						// Check for availability of corresponding plugins.
						pluginsLoaded: function( evt ) {
							var doc = CKEDITOR.document, ed = evt.editor;
							if ( !ed.getCommand( 'bold' ) )
								doc.getById( 'exec-bold' ).hide();
							if ( !ed.getCommand( 'link' ) )
								doc.getById( 'exec-link' ).hide();
						}
					}
				});
		};
	});


	directiveModule.directive('iwayShare',function(){
	  return {
	    link: function(scope,element,attrs){
	    	element.on('click',function(){
	    		var t = element.attr('id');
				var links = {
						'sina':'http://service.weibo.com/share/share.php?',
						'tx':'http://share.v.t.qq.com/index.php?c=share&a=index&',
						'qq':'http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?'
					};
				var options = ['title=jay','&pic=','&url='+window.location.href];
			 	var parms = ['toolbar=0,status=0,resizable=1,width=440,height=430,left=',(window.screen.width-440)/2,',top=',(window.screen.height-430)/2];
				window.open(links[t]+options.join(''),null,parms.join(''));

	    	});
	    }
	  }

	})

	return directiveModule;

});// end for define

