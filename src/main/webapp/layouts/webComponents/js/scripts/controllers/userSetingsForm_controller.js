/* 
 *  Document   : userSetingsForm_controller.js
 *  Created on : Jul 15, 2016, 
 *  Author     : Mihail.Cepraga
 */

angular.module('homeApp').controller('userSetingsController', ['$scope', function ($scope) {
        // function to submit the form after all validation has occurred      
        console.info("userSetingsController");
        
        $scope.FL_NamePattern = /^[a-zA-Z]{3,100}$/;
        $scope.emailPattern = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
        
        $scope.submitForm = function (isValid) {

            console.info("------- scope.submitForm ----------   ****"+isValid);
            // check to make sure the form is completely valid
            if (isValid) {
                console.info("------- our form is amazing ----------");
            }
        };
    }]);