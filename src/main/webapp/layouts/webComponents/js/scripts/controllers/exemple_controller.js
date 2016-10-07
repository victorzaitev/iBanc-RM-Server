/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


studentsManagement.controller("stsController", [
"$scope", "$route", "$rootScope", 
"stDataService", function($scope, $route, $rootScope, stDataService) {
        $rootScope.title = "Students";
        $scope.students = $route.current.locals.students;
        $scope.removeStudent = function(id, student) {
            stDataService.remove({ id: id }).$promise.then(function() {
                var index = $scope.students.indexOf(student);
                $scope.students.splice(index, 1);
                alertify.log(student.Name + " is removed");
            });
        };
    }
]);