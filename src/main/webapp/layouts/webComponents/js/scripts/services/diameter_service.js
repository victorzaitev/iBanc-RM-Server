/* 
 *  Document   : diameter_service.js
 *  Created on : Mai 20, 2016, 
 *  Author     : Mihail.Cepraga
 */

'use strict';

angular.module('ordersApp').factory('diameterService', ['$resource', function ($resource) {

        return {
            Diameters: function () {
                return $resource("/FactoryDream/rest/valueDiameters", {}, {
                    query: {method: "GET", isArray: true}
                });
            }
        };
    }]); 
