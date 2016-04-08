'use strict';

angular.module('job-app.controllers', ['job-app.services'])
.controller('mainController', [ "$scope", "userService", "$location", function($scope, userService, $location) {

	$scope.next = function(path) {
        $location.url(path);        
        if (path == "/login") {
        	$scope.$on( "$routeChangeSuccess", function(event, next, current) {
        		$('#login').hide(); 
            	$('#sign-up').show();
            });        	
		}
    };
    
    $scope.getData = function(){
    	console.log( $scope.formData);
    	userService.addUser($scope.formData, function(response) {
    		$location.url("/sign-up-success");
    	}, function(response) {
    		$location.url("/sign-up-error");
    	});
    }
    $scope.validateEmail = function(){
    	var email = this.registerForm.email.$viewValue;
    	if (email !== undefined && email !== "") {
    		var requestData = {"register": {"email": email}}
	    	userService.validateEmail(requestData, function(response) {
	    		console.log(response);
	    		if (response.responseCode == 400) {
	    			$scope.emailAlreadyExists = true;
	    		} else {
	    			$scope.emailAlreadyExists = false;
	    		}
	    	}, function(response) {
	    		console.log("Error");
	    		console.log(response);
	    	});
    	}
    }
    // we will store all of our form data in this object
    $scope.formData = {};
}]);