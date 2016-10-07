/* 
 *  Document   : orderNotes_service.js
 *  Created on : Mai 26, 2016, 
 *  Author     : Mihail.Cepraga
 */

'use strict';

angular.module('ordersApp').factory('orderNotesService', ['$resource', '$q', '$http', function ($resource, $q, $http) {

        return {
            OrderNotes: function () {
                return $resource("/FactoryDream/rest/orderNotes", {}, {
                    query: {method: "GET", isArray: true, url: "/FactoryDream/rest/orderNotes?orderId=:idCod"},
                    create: {method: "POST", isArray: true, url: "/FactoryDream/save/notes"},
                    get: {method: "GET", url: "/FactoryDream/rest/orderNotes"},
                    remove: {method: "DELETE", url: "/FactoryDream/delete/notes?note=:note"},
                    update: {method: "POST", url: "/FactoryDream/update/notes"}
                });
            },
            noteUpdate: function (note) {
                return $http.post("/FactoryDream/update/notes", note);
            }
        };
    }]);