/* 
 *  Document   : color_service.js
 *  Created on : Mai 20, 2016, 
 *  Author     : Mihail.Cepraga
 */
'use strict';
 
angular.module('ordersApp').factory('colorService', ['$resource', function($resource){
 
    return {
            Colors: function (){
                return $resource("/FactoryDream/rest/valueColors",{},{
                    query:{ method: "GET", isArray: true }
                });
            }
        }; 
}]);  