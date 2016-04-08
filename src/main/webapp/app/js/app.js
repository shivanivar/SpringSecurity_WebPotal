// Declare app level module which depends on filters, and services
angular.module('job-app', [ 'ngRoute', 'ngResource', 'job-app.controllers', 'UserValidation' ]).

config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when('/login', {
		templateUrl : 'app/partials/login.html'
	}).when('/user-profile', {
		templateUrl : 'app/partials/profile.html'
	}).when('/profile-wizard', {
		templateUrl : 'app/partials/personal_details_wizard.html'
	}).when('/education-wizard', {
		templateUrl : 'app/partials/education_wizard.html'
	}).when('/employment_wizard', {
		templateUrl : 'app/partials/employment_wizard.html'
	}).when('/sign-up-success', {
		templateUrl : 'app/partials/sign-up-success.html'
	}).when('/sign-up-error', {
		templateUrl : 'app/partials/sign-up-error.html'
	}).otherwise({
		redirectTo : '/login'
	});
} ]);

angular.module('UserValidation', []).directive('wjValidationError', function() {
	return {
		require : 'ngModel',
		link : function(scope, elm, attrs, ctl) {
			scope.$watch(attrs['wjValidationError'], function(errorMsg) {
				elm[0].setCustomValidity(errorMsg);
				ctl.$setValidity('wjValidationError', errorMsg ? false : true);
			});
		}
	};
});
