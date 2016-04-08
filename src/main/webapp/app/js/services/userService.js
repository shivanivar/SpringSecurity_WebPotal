angular.module('job-app.services', []).factory('userService', function($http) {

	var serviceObj = {};

	serviceObj.addUser = function(formData, successCallback, errorCallback) {
		var res = $http({
			method : 'POST',
			url : 'user/addUser',
			data: formData
		}).then(function (response) {
		    // this callback will be called asynchronously
		    // when the response is available
			console.log("success");
			console.log(response);
			
			if(response ) {
				if (response.data.responseCode == 200) {
					if (successCallback) {
						successCallback(response);
					}
				} else {
					if (errorCallback) {
						errorCallback(response);
					}
				}
			}
		  }, function (response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
			  
			  console.log("error");
			  console.log(response);
			  if(errorCallback) {
				  errorCallback(response);
			  }
		  });
		return res;
	};
	
	serviceObj.validateEmail = function(requestData, successCallback, errorCallback) {
		var res = $http({
			method : 'POST',
			url : 'user/validateEmail',
			data: requestData
		}).then(function (response) {
			if(response && response.data.responseCode == 200 || response.data.responseCode == 400) {
				if (successCallback) {
					successCallback(response.data);
				}	
			}
		  }, function (response) {
			  if(errorCallback) {
				  errorCallback(response);
			  }
		  });
		return res;
	};
	
	return serviceObj;
});





/*angular.module('job-app.services', []).factory('userService',
		function($resource) {
			return $resource('/api/user/:id',{id:'@_id'},{
		        update: {
		            method: 'PUT'
		        }
		    });
		});*/
