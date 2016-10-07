/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
'use strict';

angular.module('ordersApp').factory("Orders", [
    "$resource",
       function($resource) {
          return $resource("/FactoryDream/rest/orders");
    }
]);


