<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <div class="page-header"><h4>
                    <spring:message code="oops" text="Oops!"/></h4></div>
                <div class="page-header"><h4>
                    <spring:message code="not.found" text="404 Not Found"/></h4></div>
                <div class="error-details">
                    <spring:message code="sorry.an.error.has.occured.requested.page.not.found" text="Sorry, an error has occured, Requested page not found!"/>
                </div>
                <div class="error-actions">
                    <a href="/" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                        <spring:message code="take.me.home" text="Take Me Home"/></a>
                    <a href="/" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-envelope"></span> 
                    	<spring:message code="contact.support" text="Contact Support"/></a>
                </div>
            </div>
        </div>
    </div>
</div>