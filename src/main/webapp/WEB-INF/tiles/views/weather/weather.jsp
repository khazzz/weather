<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container">

	<br/>

	<div id="message"></div>

	<div class="panel panel-default">
	  	<div class="panel-body">
			<form id="searchForm" class="form-inline" action="/weather/" method="get">
			    <div class="form-group">
			      <label for="city"><spring:message code="city" text="City"/>:</label>
			      <input type="text" class="form-control" id="city" value="${param.city}" placeholder="<spring:message code="enter.city" text="Enter City"/>" name="city" required="required">
			    </div>
			    <button type="button" class="btn btn-info weatherButton"><span class="glyphicon glyphicon-search"></span></button>
		    </form>
    		</div>
    </div>

	<br/>
	
	<div id="weather" class="panel panel-default hidden">
  		<div class="panel-heading"><spring:message code="weather" text="weather"/></div>
  		<div class="panel-body">

			<table class="table table-striped">
			    <tbody>
			        <tr>
			            <td><spring:message code="description" text="Description"/></td>
			           <td id="description"></td>
			       </tr>
			       <tr>
			           <td><spring:message code="temperature" text="Temperature"/></td>
			           <td id="temperature"></td>
			       </tr>
			       <tr>
			           <td><spring:message code="temp_range" text="Range"/></td>
			           <td id="temp_range"></td>
			       </tr>
			       <tr>
			           <td><spring:message code="pressure" text="Pressure"/></td>
			           <td id="pressure"></td>
			       </tr>
			       <tr>
			           <td><spring:message code="humidity" text="Humidity"/></td>
			           <td id="humidity"></td>
			       </tr>
			       <tr>
			           <td><spring:message code="visibility" text="Visibility"/></td>
			            <td id="visibility"></td>
			        </tr>
			    </tbody>
			</table>
			
		</div>
	</div>

</div>