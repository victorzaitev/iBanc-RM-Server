/* 
 *  Document   : type_service.js
 *  Created on : Mai 20, 2016, 
 *  Author     : Mihail.Cepraga
 */

'use strict';

angular.module('ordersApp').factory('typeService', ['$resource', function ($resource) {

        return {
            Types: function () {
                return $resource("/FactoryDream/rest/valueTypes", {}, {
                    query: {method: "GET", isArray: true}
                });
            }
        };
    }]); 