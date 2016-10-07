/* 
 *  Document   : orderParametersNames_service.js
 *  Created on : Iun 08, 2016, 
 *  Author     : Mihail.Cepraga
 */

'use strict';

angular.module('ordersApp').factory('orderParametersNamesService', ['$resource', function ($resource) {
       
        return {
            OrderParametersNames: function () {
                return $resource("/FactoryDream/rest/paramNames", {}, {
                    query: {method: "GET", isArray: true, url: "/FactoryDream/rest/orderNotes?orderId=:idCod"},
                    create: {method: "POST", url: "/FactoryDream/save/notes"},
                    get: {method: "GET", isArray: true, url: "/FactoryDream/rest/paramNames"},
                    remove: {method: "DELETE", url: "/FactoryDream/delete/notes?note=:note"},
                    update: {method: "POST", url: "/FactoryDream/update/notes"}
                });
            }
        };

    }]);