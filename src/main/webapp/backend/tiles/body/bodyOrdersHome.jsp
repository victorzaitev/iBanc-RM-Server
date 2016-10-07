<%-- 
    Document   : bodyOrdersHome
    Created on : Apr 14, 2016, 3:53:39 PM
    Author     : Mihail.Cepraga
--%>

<div ng-app="ordersApp" ng-controller="ordersController" >

    <div class="container-fluid" ng-hide="!advanceFiltration">
        <div class="orders-advance-filtring"></div>
    </div> <!-- END container-fluid div-->

    <div class="container-fluid">
        <div class="row">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">List of Orders </span>
                    <button type="button" ng-model="orderAddFlag" ng-hide="orderAddFlag" id="addData" class="btn btn-info pull-right btn-sm" ng-click="openOrderAddModalWindow('lg')"><span class="glyphicon glyphicon-plus"></span><span class="hidden-xs"> Add New Order</span></button>
                </div>
                <div class="tablecontainer">

                    <div>
                        <div id="grid" ui-grid="ordersGridData" ui-grid-edit ui-grid-row-edit ui-grid-pinning ui-grid-selection ui-grid-exporter ui-grid-cellNav class="grid"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>