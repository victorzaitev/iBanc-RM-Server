/* 
 *  Document   : model_service.js
 *  Created on : Apr 22, 2016, 
 *  Author     : Mihail.Cepraga
 */


'use strict';

angular.module('ordersApp').factory('modelService', ['$resource', function ($resource) {

        return {
            Models: function () {
                return $resource("/FactoryDream/rest/valueModels", {}, {
                    query: {method: "GET", isArray: true}
                });
            }
        };
    }]);