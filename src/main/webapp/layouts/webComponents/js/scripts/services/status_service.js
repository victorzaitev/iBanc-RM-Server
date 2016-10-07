/* 
 *  Document   : orders_service.js
 *  Created on : Apr 15, 2016, 
 *  Author     : Mihail.Cepraga
 */

'use strict';

angular.module('ordersApp').factory('statusesService', ['$resource', function ($resource) {

        return {
            Statuses: function () {
                return $resource("/FactoryDream/rest/statusCodStatuses", {}, {
                    query: {method: "GET", isArray: true, url: "/FactoryDream/rest/statusCodStatuses?statusGroup=:cod"},
                    create: {method: "POST", url: "/FactoryDream/save/orders"},
                    get: {method: "GET", url: "/FactoryDream/rest/statusCodStatuses?id=:id"},
                    remove: {method: "DELETE", url: "/FactoryDream/rest/statusCodStatuses?id=:id"},
                    update: {method: "POST", url: "/FactoryDream/rest/statusCodStatuses"}
                });
            }
        };
    }]);
