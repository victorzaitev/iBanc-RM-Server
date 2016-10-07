/* 
 *  Document   : orders_service.js
 *  Created on : Apr 15, 2016, 
 *  Author     : Mihail.Cepraga
 */

'use strict';

angular.module('ordersApp').factory('ordersService', ['$resource', function ($resource) {

        return {
            Orders: function () {
                return $resource("/FactoryDream/rest/orders", {}, {
                    query: {method: "GET", isArray: true},
                    create: {method: "POST", url: "/FactoryDream/save/orders"},
                    get: {method: "GET", url: "/FactoryDream/rest/orders?id=:id"},
                    remove: {method: "DELETE", url: "/FactoryDream/rest/orders?id=:id"},
                    update: {method: "POST", url: "/FactoryDream/save/orders"}
                });
            }
        };
    }]);