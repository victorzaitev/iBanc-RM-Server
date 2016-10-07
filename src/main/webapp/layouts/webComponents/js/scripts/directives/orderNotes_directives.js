/* 
 *  Document   : orderNotes_directives.js
 *  Created on : Mai 30, 2016, 
 *  Author     : Mihail.Cepraga
 */

angular.module('ordersApp').directive("orderNotes", function() {
    return {
        templateUrl: function(item, attr){
        return 'js/scripts/templates/orderNotes-'+attr.type+'.html';
        }
    };
}).directive("orderInsertNote", function() {
    return {
        restrict : "C",
        templateUrl: function(){
        return 'js/scripts/templates/orderNoteInsertForm.html';
        }
    };
}).directive("orderNoteEdit", function() {
    return {
        restrict : "C",
        templateUrl: function(){
        return 'js/scripts/templates/orderNoteEditForm.html';
        }
    };
}).directive("addNewOrder", function() {
    return {
        templateUrl: function(){
        return 'js/scripts/templates/addNewOrderForm.html';
        }
    };
}).directive("ordersAdvanceFiltring", function() {
    return {
        restrict : "C",
        templateUrl: function(){
        return 'js/scripts/templates/ordersAdvanceFiltring.html';
        }
    };
});