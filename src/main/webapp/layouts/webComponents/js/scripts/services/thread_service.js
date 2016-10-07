/* 
 *  Document   : diameter_service.js
 *  Created on : Mai 20, 2016, 
 *  Author     : Mihail.Cepraga
 */

'use strict';

angular.module('ordersApp').factory('threadService', ['$resource', function ($resource) {

        return {
            Threads: function () {
                return $resource("/FactoryDream/rest/valueThreads", {}, {
                    query: {method: "GET", isArray: true}
                });
            }
        };
    }]); 
