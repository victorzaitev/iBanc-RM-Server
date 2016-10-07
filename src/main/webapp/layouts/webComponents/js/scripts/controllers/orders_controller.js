/* 
 *  Document   : orders_controller.js
 *  Created on : Apr 15, 2016, 
 *  Author     : Mihail.Cepraga
 */

angular.module('ordersApp').controller('ordersController', ['$scope', '$uibModal', 'ordersService', 'modelService', 'colorService', 'typeService', 'diameterService', 'customerService', 'threadService', 'statusesService', 'uiGridConstants', function ($scope, $uibModal, ordersService, modelService, colorService, typeService, diameterService, customerService, threadService, statusesService, uiGridConstants) {

        var self = this;
        $scope.user_access;
        $scope.orderAddFlag = true;
        self.orders = [];
        $scope.ordersGridData = {};
        $scope.modelsValue = {};
        $scope.colorsValue = {};
        $scope.typesValue = {};
        $scope.diametersValue = {};
        $scope.customersValue = {};
        $scope.threadsValue = {};
        $scope.statusesValue = {};
        $scope.orderParameters = [];
        $scope.advanceFiltrationData = [];

        self.fetchAllModelsValue = function () {
            modelService.Models().query().$promise.then(function (result) {
                $scope.modelsValue = result;
            });
        };
        self.fetchAllColorsValue = function () {
            colorService.Colors().query().$promise.then(function (result) {
                $scope.colorsValue = result;
            });
        };
        self.fetchAllTypesValue = function () {
            typeService.Types().query().$promise.then(function (result) {
                $scope.typesValue = result;
            });
        };
        self.fetchAllDiametersValue = function () {
            diameterService.Diameters().query().$promise.then(function (result) {
                $scope.diametersValue = result;
            });
        };
        self.fetchAllCustomersValue = function () {
            customerService.Customers().query().$promise.then(function (result) {
                $scope.customersValue = result;
            });
        };
        self.fetchAllThreadsValue = function () {
            threadService.Threads().query().$promise.then(function (result) {
                $scope.threadsValue = result;
            });
        };
        self.fetchAllStatuses = function () {
            statusesService.Statuses().query({cod: 4}).$promise.then(function (result) {
                $scope.statusesValue = result;
            });
        };

        self.fetchAllOrders = function () {
            ordersService.Orders().query().$promise.then(function (result) {
                $scope.user_access = result[0].userAccess;
                self.biuldData(result[1].orders);
                self.initOrderGridColumn($scope.user_access);
            });
        };

        self.initOrderGridColumn = function (userAccess) {

            switch (userAccess) {
                case "full":
                    $scope.ordersGridData.columnDefs = self.fullAccess;
                    $scope.ordersGridData.columnDefs[1].editDropdownOptionsArray = $scope.statusesValue;
                    $scope.ordersGridData.columnDefs[1].filter.selectOptions = $scope.statusesValue;
                    $scope.ordersGridData.columnDefs[3].editDropdownOptionsArray = $scope.customersValue;
                    $scope.ordersGridData.columnDefs[3].filter.selectOptions = $scope.customersValue;
                    $scope.ordersGridData.columnDefs[7].editDropdownOptionsArray = $scope.modelsValue;
                    $scope.ordersGridData.columnDefs[7].filter.selectOptions = $scope.modelsValue;
                    $scope.ordersGridData.columnDefs[10].editDropdownOptionsArray = $scope.diametersValue;
                    $scope.ordersGridData.columnDefs[10].filter.selectOptions = $scope.diametersValue;
                    $scope.ordersGridData.columnDefs[11].editDropdownOptionsArray = $scope.typesValue;
                    $scope.ordersGridData.columnDefs[11].filter.selectOptions = $scope.typesValue;
                    $scope.ordersGridData.columnDefs[12].editDropdownOptionsArray = $scope.threadsValue;
                    $scope.ordersGridData.columnDefs[12].filter.selectOptions = $scope.threadsValue;
                    $scope.ordersGridData.columnDefs[13].editDropdownOptionsArray = $scope.colorsValue;
                    $scope.ordersGridData.columnDefs[13].filter.selectOptions = $scope.colorsValue;
                    $scope.ordersGridData.enableGridMenu = true;
                    $scope.ordersGridData.enableCellEditOnFocus = true;
                    $scope.ordersGridData.enableFiltering = true;
                    $scope.ordersGridData.exporterMenuPdf = false;
                    $scope.ordersGridData.exporterCsvFilename = 'myFile.csv';
                    $scope.orderAddFlag = false;

                    break;
                case "update":
                    $scope.ordersGridData.columnDefs = self.fullAccess;
                    $scope.ordersGridData.columnDefs[3].editDropdownOptionsArray = $scope.customersValue;
                    $scope.ordersGridData.columnDefs[7].editDropdownOptionsArray = $scope.modelsValue;
                    $scope.ordersGridData.columnDefs[10].editDropdownOptionsArray = $scope.diametersValue;
                    $scope.ordersGridData.columnDefs[11].editDropdownOptionsArray = $scope.typesValue;
                    $scope.ordersGridData.columnDefs[12].editDropdownOptionsArray = $scope.threadsValue;
                    $scope.ordersGridData.columnDefs[13].editDropdownOptionsArray = $scope.colorsValue;
                    $scope.ordersGridData.enableGridMenu = true;
                    $scope.ordersGridData.enableCellEditOnFocus = true;
                    $scope.ordersGridData.enableFiltering = true;
                    $scope.ordersGridData.exporterMenuPdf = false;
                    $scope.ordersGridData.exporterCsvFilename = 'myFile.csv';

                    break;
                case "insert":
                    $scope.ordersGridData.columnDefs = self.fullAccess;
                    $scope.ordersGridData.columnDefs[3].editDropdownOptionsArray = $scope.customersValue;
                    $scope.ordersGridData.columnDefs[7].editDropdownOptionsArray = $scope.modelsValue;
                    $scope.ordersGridData.columnDefs[10].editDropdownOptionsArray = $scope.diametersValue;
                    $scope.ordersGridData.columnDefs[11].editDropdownOptionsArray = $scope.typesValue;
                    $scope.ordersGridData.columnDefs[12].editDropdownOptionsArray = $scope.threadsValue;
                    $scope.ordersGridData.columnDefs[13].editDropdownOptionsArray = $scope.colorsValue;
                    $scope.ordersGridData.enableGridMenu = true;
                    $scope.ordersGridData.enableCellEditOnFocus = true;
                    $scope.ordersGridData.enableFiltering = true;
                    $scope.ordersGridData.exporterMenuPdf = false;
                    $scope.ordersGridData.exporterCsvFilename = 'myFile.csv';
                    $scope.orderAddFlag = false;
                    break;
                default:
                    $scope.ordersGridData.columnDefs = self.readOnlyAccess;
                    $scope.ordersGridData.columnDefs[1].filter.selectOptions = $scope.statusesValue;
                    $scope.ordersGridData.columnDefs[3].filter.selectOptions = $scope.customersValue;
                    $scope.ordersGridData.columnDefs[7].filter.selectOptions = $scope.modelsValue;
                    $scope.ordersGridData.columnDefs[10].filter.selectOptions = $scope.diametersValue;
                    $scope.ordersGridData.columnDefs[11].filter.selectOptions = $scope.typesValue;
                    $scope.ordersGridData.columnDefs[12].filter.selectOptions = $scope.threadsValue;
                    $scope.ordersGridData.columnDefs[13].filter.selectOptions = $scope.colorsValue;
                    $scope.ordersGridData.enableCellEdit = false;
                    $scope.ordersGridData.enableFiltering = true;
                    $scope.ordersGridData.enableSelectAll = true;
                    $scope.ordersGridData.enableGridMenu = true;
                    $scope.ordersGridData.exporterMenuPdf = false;
                    $scope.orderAddFlag = true;
                    break;

            }
        };
//------------------------------------------------------------------------------

        $scope.statusNameClass = function (row) {
            if (row.entity.status === 'None') {
                return "text-muted text-center";
            } else {
                return "text-primary"; // Or even "", which won't add any additional classes to the element
            }
        };

        $scope.statusButtonClass = function (row) {
            if (row.entity.status === 1) {
                return "btn btn-default btn-xs";
            } else {
                return "btn btn-danger btn-xs"; // Or even "", which won't add any additional classes to the element
            }
        };

        $scope.openNotesModalWindow = function (size, orderSourceId, userAccess) {
            console.info(orderSourceId);
            console.info(userAccess);
            var modalInstance = $uibModal.open({
                animation: true,
                template: '<div order-notes type="' + userAccess + '"></div>',
                controller: 'orderNotesModalController',
                size: size,
                resolve: {
                    orderId: function () {
                        return orderSourceId;
                    },
                    userStatus: function () {
                        return userAccess;
                    }
                }
            });

            modalInstance.result.then(function (selectedItem) {
                $scope.selected = selectedItem;
            }, function () {
                console.info('OpenNotesModalWindow dismissed at: ' + new Date());
            });
        };


        $scope.openOrderAddModalWindow = function (size) {
            var modalInstance = $uibModal.open({
                animation: true,
                template: '<div add-new-order></div>',
                controller: 'addNewOrderModalController',
                size: size,
                resolve: {
                    orderModels: function () {
                        return $scope.modelsValue;
                    },
                    orderColors: function () {
                        return $scope.colorsValue;
                    },
                    orderTypes: function () {
                        return $scope.typesValue;
                    },
                    orderDiameters: function () {
                        return $scope.diametersValue;
                    },
                    orderCustomers: function () {
                        return $scope.customersValue;
                    },
                    orderThreads: function () {
                        return $scope.threadsValue;
                    }
                }
            });

            modalInstance.result.then(function (selectedItem) {
                $scope.selected = selectedItem;
            }, function () {
                console.info('openOrderAddModalWindow dismissed at: ' + new Date());
            });
        };

//------------------------------------------------------------------------------

        self.fullAccess = [
            {name: 'orderNotes', displayName: 'Notes', pinnedLeft: true, enableCellEdit: false, enableColumnMenu: false, enableFiltering: false, cellTemplate: '<div class="ui-grid-cell-contents"><button class="btn btn-primary btn-xs" ng-click="grid.appScope.openNotesModalWindow(\'lg\', row.entity.id, grid.appScope.user_access)"><span class="badge btn-xs">{{COL_FIELD}}</span> Notes</button></div>', width: 80},
            {name: 'status', displayName: 'Status', pinnedLeft: true, enableCellEdit: true, enableColumnMenu: false, width: 80
                , filter: {type: uiGridConstants.filter.SELECT}
                , editType: 'dropdown'
                , editableCellTemplate: 'ui-grid/dropdownEditor'
                , cellFilter: "statusdropdown:grid.appScope.statusesValue:row.entity.status"
                , editDropdownIdLabel: 'value'
                , editDropdownValueLabel: 'label'
            },
            {name: 'orderData', displayName: 'Data', type: 'date', pinnedLeft: true, cellFilter: 'date:"dd.MM.yyyy"', enableColumnMenu: false, width: 100},
            {name: 'customer', displayName: 'Client', enableColumnMenu: false, enablePinning: false, width: 150
                , filter: {type: uiGridConstants.filter.SELECT}
                , editType: 'dropdown'
                , editableCellTemplate: 'ui-grid/dropdownEditor'
                , cellFilter: "griddropdown:grid.appScope.customersValue:row.entity.customer"
                , editDropdownIdLabel: 'value'
                , editDropdownValueLabel: 'label'
            },
            {name: 'Client Order id', displayName: 'Ordin Client', enableColumnMenu: false, visible: false, width: 150},
            {name: 'Symbol', displayName: 'Symbol', enableColumnMenu: false, visible: false, width: 100},
            {name: 'orderIdentifier', displayName: 'Ordin Id', enableColumnMenu: false, width: 80},
            {name: 'model', displayName: 'Model', enableColumnMenu: false, width: 80
                , filter: {type: uiGridConstants.filter.SELECT}
                , editType: 'dropdown'
                , editableCellTemplate: 'ui-grid/dropdownEditor'
                , cellFilter: "griddropdown:grid.appScope.modelsValue:row.entity.model"
                , editDropdownIdLabel: 'value'
                , editDropdownValueLabel: 'label'
            },
            {name: 'Thickness', displayName: 'T', enableColumnMenu: false, width: 80},
            {name: 'LB/FT', displayName: 'Lb/Ft', enableColumnMenu: false, width: 80},
            {name: 'diameter', displayName: 'Diametru', enableColumnMenu: false, width: 80
                , filter: {type: uiGridConstants.filter.SELECT}
                , editType: 'dropdown'
                , editableCellTemplate: 'ui-grid/dropdownEditor'
                , cellFilter: "griddropdown:grid.appScope.diametersValue:row.entity.diameter"
                , editDropdownIdLabel: 'value'
                , editDropdownValueLabel: 'label'
            },
            {name: 'type', displayName: 'Tipul', enableColumnMenu: false, width: 90
                , filter: {type: uiGridConstants.filter.SELECT}
                , editType: 'dropdown'
                , editableCellTemplate: 'ui-grid/dropdownEditor'
                , cellFilter: "griddropdown:grid.appScope.typesValue:row.entity.type"
                , editDropdownIdLabel: 'value'
                , editDropdownValueLabel: 'label'
            },
            {name: 'thread', displayName: 'Filet', enableColumnMenu: false, width: 150
                , filter: {type: uiGridConstants.filter.SELECT}
                , editType: 'dropdown'
                , editableCellTemplate: 'ui-grid/dropdownEditor'
                , cellFilter: "griddropdown:grid.appScope.threadsValue:row.entity.thread"
                , editDropdownIdLabel: 'value'
                , editDropdownValueLabel: 'label'
            },
            {name: 'color', displayName: 'Culoare', enableColumnMenu: false, width: 80
                , filter: {type: uiGridConstants.filter.SELECT}
                , editType: 'dropdown'
                , editableCellTemplate: 'ui-grid/dropdownEditor'
                , cellFilter: "griddropdown:grid.appScope.colorsValue:row.entity.color"
                , editDropdownIdLabel: 'value'
                , editDropdownValueLabel: 'label'
            },
            {name: 'Vent Hole', displayName: 'Vent.mm', enableColumnMenu: false, width: 80},
            {name: 'OD', displayName: 'OD.mm', enableColumnMenu: false, width: 80},
            {name: 'Drift', displayName: 'Drift_mm', enableColumnMenu: false, width: 80},
            {name: 'delivery', displayName: 'Consegna', type: 'date', cellFilter: 'date:"dd.MM.yyyy"', enableColumnMenu: false, width: 100},
            {name: 'quantity', displayName: 'Q-ty', enableColumnMenu: false, width: 80}
        ];

        self.readOnlyAccess = [
            {name: 'orderNotes', displayName: 'Notes', pinnedLeft: true, enableCellEdit: false, enableColumnMenu: false, enableFiltering: false, cellTemplate: '<div class="ui-grid-cell-contents"><button class="btn btn-primary btn-xs" ng-click="grid.appScope.open(\'lg\', row.entity.id, grid.appScope.user_access)"><span class="badge btn-xs">{{COL_FIELD}}</span> Notes</button></div>', width: 80},
            {name: 'status', displayName: 'Status', pinnedLeft: true, enableColumnMenu: false, cellTemplate: '<div class="ui-grid-cell-contents" ng-class="grid.appScope.statusNameClass(row)" >{{COL_FIELD}}</div>', width: 80
                , filter: {type: uiGridConstants.filter.SELECT}
            },
            {name: 'orderData', displayName: 'Data', type: 'date', cellFilter: 'date:"dd.MM.yyyy"', enableColumnMenu: false, width: 90},
            {name: 'customer', displayName: 'Client', enableColumnMenu: false, width: 150
                , filter: {type: uiGridConstants.filter.SELECT}
            },
            {name: 'Client Order id', displayName: 'Ordin Client', enableColumnMenu: false, visible: false, width: 150},
            {name: 'Symbol', displayName: 'Symbol', enableColumnMenu: false, visible: false, width: 100},
            {name: 'orderIdentifier', displayName: 'Ordin Id', enableColumnMenu: false, width: 80},
            {name: 'model', displayName: 'Model', enableColumnMenu: false, width: 80
                , filter: {type: uiGridConstants.filter.SELECT}
            },
            {name: 'Thickness', displayName: 'T', enableColumnMenu: false, width: 80},
            {name: 'LB/FT', displayName: 'Lb/Ft', enableColumnMenu: false, width: 90},
            {name: 'diameter', displayName: 'Diametru', enableColumnMenu: false, width: 80
                , filter: {type: uiGridConstants.filter.SELECT}
            },
            {name: 'type', displayName: 'Tipul', enableColumnMenu: false, width: 90
                , filter: {type: uiGridConstants.filter.SELECT}
            },
            {name: 'thread', displayName: 'Filet', enableColumnMenu: false, width: 150
                , filter: {type: uiGridConstants.filter.SELECT}
            },
            {name: 'color', displayName: 'Culoare', enableColumnMenu: false, width: 80
                , filter: {type: uiGridConstants.filter.SELECT}
            },
            {name: 'Vent Hole', displayName: 'Vent.mm', enableColumnMenu: false, width: 80},
            {name: 'OD', displayName: 'OD.mm', enableColumnMenu: false, width: 80},
            {name: 'Drift', displayName: 'Drift_mm', enableColumnMenu: false, width: 80},
            {name: 'delivery', displayName: 'Consegna', type: 'date', cellFilter: 'date:"dd.MM.yyyy"', enableColumnMenu: false, width: 90},
            {name: 'quantity', displayName: 'Q-ty', enableColumnMenu: false, width: 80}
        ];
        $scope.saveRow = function (rowEntity) {
            // create a fake promise - normally you'd use the promise returned by $http or $resource
            var promise = ordersService.Orders().update(self.packingData(rowEntity)).$promise;
            $scope.gridApi.rowEdit.setSavePromise(rowEntity, promise);
        };
        $scope.ordersGridData.onRegisterApi = function (gridApi) {
            //set gridApi on scope
            $scope.gridApi = gridApi;
            gridApi.rowEdit.on.saveRow($scope, $scope.saveRow);
        };
        self.initOrdersGrid = function () {
            self.fetchAllModelsValue();
            self.fetchAllColorsValue();
            self.fetchAllTypesValue();
            self.fetchAllDiametersValue();
            self.fetchAllCustomersValue();
            self.fetchAllThreadsValue();
            self.fetchAllStatuses();
            self.fetchAllOrders();
            $scope.ordersGridData.data = self.orders;
        };

        self.checkAccess = function (userAccess) {
            console.log(userAccess);
        };

        self.initOrdersGrid();
        
        $scope.initAdvanceFiltrationData = function(){
            $scope.advanceFiltrationData = [{title: "Customer",
                                            content: $scope.customersValue},
                                            {title: "Models",
                                            content: $scope.modelsValue},
                                            {title: "Colors",
                                            content: $scope.colorsValue},
                                            {title: "Types",
                                            content: $scope.typesValue},
                                            {title: "Diameters",
                                            content: $scope.diametersValue},
                                            {title: "Threads",
                                            content: $scope.threadsValue},
                                            {title: "Statuses",
                                            content: $scope.statusesValue}
            ];
        };
        
        self.biuldData = function (OrderSourceData) {

            for (i = 0; i < OrderSourceData.length; i++) {

                var parameters = {};
                for (j = 0; j < OrderSourceData[i].orderParameterses.length; j++) {
                    parameters[OrderSourceData[i].orderParameterses[j].paramName] = OrderSourceData[i].orderParameterses[j].paramValue;
                }
                parameters.id = OrderSourceData[i].id;
                parameters.orderData = OrderSourceData[i].orderData;
                parameters.customer = OrderSourceData[i].customer;
                parameters.model = OrderSourceData[i].model;
                parameters.type = OrderSourceData[i].type;
                parameters.diameter = OrderSourceData[i].diameter;
                parameters.thread = OrderSourceData[i].thread;
                parameters.color = OrderSourceData[i].color;
                parameters.orderIdentifier = OrderSourceData[i].orderIdentifier;
                parameters.quantity = OrderSourceData[i].quantity;
                parameters.delivery = OrderSourceData[i].delivery;
                parameters.status = OrderSourceData[i].status;
                parameters.orderNotes = OrderSourceData[i].orderNotes;

                self.orders.push(parameters);
            }

        };
        self.packingData = function (row) {
            var orderKeys = Object.keys(row);
            var order = {};
            order.orderParameterses = new Array();
            for (var i = 0; i < orderKeys.length; i++) {

                switch (orderKeys[i])
                {
                    case '$$hashKey':
                        break;
                    case 'id':
                        order["id"] = row[orderKeys[i]];
                        break;
                    case 'customer':
                        order["customer"] = row[orderKeys[i]];
                        break;
                    case 'color':
                        order["color"] = row[orderKeys[i]];
                        break;
                    case 'diameter':
                        order["diameter"] = row[orderKeys[i]];
                        break;
                    case 'delivery':
                        order["delivery"] = row[orderKeys[i]];
                        break;
                    case 'model':
                        order["model"] = row[orderKeys[i]];
                        break;
                    case 'orderData':
                        order["orderData"] = row[orderKeys[i]];
                        break;
                    case 'orderIdentifier':
                        order["orderIdentifier"] = row[orderKeys[i]];
                        break;
                    case 'model':
                        order["model"] = row[orderKeys[i]];
                        break;
                    case 'status':
                        order["status"] = row[orderKeys[i]];
                        break;
                    case 'thread':
                        order["thread"] = row[orderKeys[i]];
                        break;
                    case 'type':
                        order["type"] = parseInt(row[orderKeys[i]]);
                        break;
                    case 'quantity':
                        order["quantity"] = row[orderKeys[i]];
                        break;
                    case 'orderNotes':
                        order["orderNotes"] = row[orderKeys[i]];
                        break;
                    default:
                        order.orderParameterses.push({"paramName": orderKeys[i], "paramValue": row[orderKeys[i]]});
                }
            }
            ;
            console.log(row);
            console.log(order);
            return order;
        };
    }]).filter('griddropdown', function () {

    return function (input, map, initial) {
        if (typeof map !== "undefined") {
            for (var i = 0; i < map.length; i++) {
                if (map[i]['value'] === input) {
                    return map[i]['label'];
                }
            }
        } else if (initial) {
            return initial;
        }
        return input;
    };
}).filter('statusdropdown', function () {

    return function (input, map, initial) {
        if (typeof map !== "undefined") {
            for (var i = 0; i < map.length; i++) {
                if (map[i]['value'] === input) {
                    return map[i]['label'];
                } else if (initial === 1) {
                    return "None";
                }
            }
        } else if (initial === '1') {
            return "None";
        }
        return input;
    };
}).directive('myCustomDropdown', function () {
    return {
        template: '<select class="form-control input-sm"  style="padding-right: 0px; padding-left: 0px;" ng-model="colFilter.term" ng-options="option.id as option.value for option in colFilter.options"></select>'
    };
});
