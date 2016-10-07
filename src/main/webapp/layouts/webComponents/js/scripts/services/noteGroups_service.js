/* 
 *  Document   : noteGroups_service.js
 *  Created on : Iun 7, 2016, 
 *  Author     : Mihail.Cepraga
 */
'use strict';
 
angular.module('ordersApp').factory('noteGroupsService', ['$resource', function($resource){
 
    return {
            NoteGroups: function (){
                return $resource("/FactoryDream/rest/valueNoteGroups",{},{
                    query:{ method: "GET", isArray: true }
                });
            }
        }; 
}]);  
