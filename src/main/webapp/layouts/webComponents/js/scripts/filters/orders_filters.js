/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module('ordersApp').filter('orderModulesFilter', function () {
    return function (input, map, idField, valueField, initial) {
        if (typeof map !== "undefined") {
            for (var i = 0; i < map.length; i++) {
                if (map[i][idField] === input) {
                    return map[i][valueField];
                }
            }
        } else if (initial) {
            return initial;
        }
        return input;
    };
});

