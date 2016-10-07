/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var studentsManagement = angular.module("exempleApp", 
	["ngResource", "ngCookies", "ngRoute"]).run(function ($rootScope) {
    $rootScope.title = "Home";
})
    .config([
        "$routeProvider", "$locationProvider", function ($routeProvider, $locationProvider) {
            $locationProvider.html5Mode({
                enabled: true,
                requireBase: false
            });
            $routeProvider.when("/", {
                templateUrl: "/templates/Students.html",
                controller: "stsController"
                //<code>resolve</code>
            });
        }
    ]);