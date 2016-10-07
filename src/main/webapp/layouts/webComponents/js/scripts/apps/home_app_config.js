/* 
 *  Document   : home_app.js
 *  Created on : Jul 13, 2016, 
 *  Author     : Mihail.Cepraga
 */
angular.module('homeApp').config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
        // For any unmatched url, send to /business
        $urlRouterProvider.otherwise("/");

        $stateProvider
                .state('userSetings', {//State demonstrating Nested views
                    url: "/userSetings",
                    templateUrl: "js/scripts/templates/userSetingsForm.html",
                    controller : 'userSetingsController'
                });
    }]);