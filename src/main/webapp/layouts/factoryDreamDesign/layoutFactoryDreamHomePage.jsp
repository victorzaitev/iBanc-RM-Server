<%-- 
    Document   : layoutFactoryDream
    Created on : Mar 21, 2016, 3:33:27 PM
    Author     : Zaițev.Victor
--%>
<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <tiles:insertAttribute name="header"/>
    </head>
    <body>

        <div id="wrapper" ng-app="homeApp" >
            <!-- Navigation -->
            <nav class="navbar navbar-default navbar-static-top marginBottom-0px" role="navigation">
                <tiles:insertAttribute name="navMenuTop"/>
                <tiles:insertAttribute name="navMenuLeft"/>

            </nav>    
            <tiles:insertAttribute name="body"/>
        </div><!-- /#wrapper -->

        <tiles:insertAttribute name="javaScript"/>

    </body>
</html>

