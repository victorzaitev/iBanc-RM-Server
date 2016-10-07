/* 
 *  Document   : diameter_service.js
 *  Created on : Mai 20, 2016, 
 *  Author     : Mihail.Cepraga
 */

'use strict';

angular.module('ordersApp').factory('customerService', ['$resource', function ($resource) {

        return {
            Customers: function () {
                return $resource("/FactoryDream/rest/valueCustomers", {}, {
                    query: {method: "GET", isArray: true}
                });
            }
        };
    }]); 
