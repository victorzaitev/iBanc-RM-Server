<%-- 
    Document   : layoutFactoryDreamOrdersPage
    Created on : Apr 14, 2016, 3:48:55 PM
    Author     : Mihail.Cepraga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <tiles:insertAttribute name="header"/>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-static-top marginBottom-0px" role="navigation">
<!--   
            <div class="container-fluid">
                 Brand and toggle get grouped for better mobile display 
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Brand</a>
                </div>
                 Collect the nav links, forms, and other content for toggling 
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="#" ng-model="advanceFiltration" ng-click="initAdvanceFiltrationData()" uib-btn-checkbox btn-checkbox-true="1" btn-checkbox-false="0"><span class="glyphicon glyphicon-filter"></span> Advance filtration</a></li>
                        <li><a href="#">Link</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> User Name</a></li>
                        <li><a href="FactoryDream/logout">Logout <span class="glyphicon glyphicon-log-out"></span></a></li>
                    </ul>
                </div> /.navbar-collapse 
            </div>-->
            
        <tiles:insertAttribute name="navMenuTop"/>
        </nav>
        
        <tiles:insertAttribute name="body"/>
        <tiles:insertAttribute name="javaScript"/>
    </body>
</html>
