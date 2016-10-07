<%-- 
    Document   : bodyLogin
    Created on : Mar 21, 2016, 4:04:23 PM
    Author     : Zaițev.Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>

<c:url var="loginUrl" value="/j_spring_security_check" />

<div class="container">
    <sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
        <div class="row">

            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><spring:message code="login.title.authent" text="Logare"/></h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="POST" action="sendMail" >
                            <fieldset>
                              
                                <!-- Change this to a button or input when using this as a form -->
                                <input class="btn btn-lg btn-success btn-block"  type="submit" value=<spring:message code="login.title.summit" text="Logare"/> />
                            </fieldset>
                        </form>
                    </div>
                </div>
                <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                    <div class="alert alert-danger">
                        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
                    </div>
                </c:if>        
            </div>
        </div>
    </sec:authorize>
</div>