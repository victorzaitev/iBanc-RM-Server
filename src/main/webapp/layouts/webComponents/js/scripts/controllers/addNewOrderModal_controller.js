/* 
 *  Document   : orderNotesModal_controller.js
 *  Created on : Iun 03, 2016, 
 *  Author     : Mihail.Cepraga
 */

angular.module('ordersApp').controller('addNewOrderModalController', ['$scope', '$uibModalInstance', 'orderModels', 'orderColors', 'orderTypes', 'orderDiameters', 'orderCustomers', 'orderThreads', 'orderParametersNamesService', 'ordersService', function ($scope, $uibModalInstance, orderModels, orderColors, orderTypes, orderDiameters, orderCustomers, orderThreads, orderParametersNamesService, ordersService) {

        var self = this;

        self.params = orderParametersNamesService.OrderParametersNames().get();

        $scope.newOrderCustomer = orderCustomers;
        $scope.neworderModels = orderModels;
        $scope.neworderColors = orderColors;
        $scope.neworderTypes = orderTypes;
        $scope.neworderDiameters = orderDiameters;
        $scope.neworderThreads = orderThreads;
        $scope.orderParameters = orderParametersNamesService.OrderParametersNames().get();
        $scope.newOrderParameter;
        $scope.newOrderParameters = [];
        $scope.newOrder = {};
        $scope.newOrder.orderParameters = [];
        
        self.fetchAllOrderParametersValues = function () {
            $scope.orderParameters = angular.copy(self.params);
        };

        $scope.addParameter = function (paramId, paramLabel, indexparam) {
            $scope.newOrderParameters.push({id: paramId, label: paramLabel, value: $scope.newOrderParameter.value});
            $scope.newOrder.orderParameters.push({"paramName": paramLabel, "paramValue": $scope.newOrderParameter.value});
            $scope.orderParameters.splice(indexparam, 1);
            $scope.newOrderParameter.value = '';
        };

        $scope.addNewOrderFormSubmit = function () {

            ordersService.Orders().create(self.packingDataForSending($scope.newOrder));

//            self.packingDataForSending($scope.newOrder);

            // check to make sure the form is completely valid
        };

        $scope.resetAddNewOrderForm = function () {

            self.fetchAllOrderParametersValues();
            $scope.newOrder = {};
            $scope.newOrderParameters = [];
            $scope.orderParameters = angular.copy(self.params);
            $scope.newOrder.orderParameters = [];
        };

        $scope.openDataPicker = function () {
            $scope.orderDataPopup.opened = true;
        };

        $scope.orderDataPopup = function () {
            opened: false;
        };

        $scope.openDeliveryPicker = function () {
            $scope.orderDeliveryPopup.opened = true;
        };
        $scope.orderDeliveryPopup = function () {
            opened: false;
        };

        $scope.closeModal = function () {
            $uibModalInstance.close('close');
        };

        self.packingDataForSending = function (order) {
            var newOrderToAdd = {};

            newOrderToAdd["customer"] = order.customer["value"];
            newOrderToAdd["color"] = order.color["value"];
            newOrderToAdd["diameter"] = order.diameter["value"];
            newOrderToAdd["model"] = order.model["value"];
            newOrderToAdd["type"] = order.type["value"];
            newOrderToAdd["thread"] = order.thread["value"];
            newOrderToAdd["orderData"] = order.orderData;
            newOrderToAdd["delivery"] = order.delivery;
            newOrderToAdd["quantity"] = order.quantity;
            newOrderToAdd.orderParameterses = order.orderParameters;
            newOrderToAdd.orderIdentifier = order.orderIdentifier;
            newOrderToAdd.status = 1;

            console.log("----------------------- packingDataForSending --------------------------------");
            console.log(newOrderToAdd);
            return newOrderToAdd;


        };

    }]);