<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
	<head>
	  <tiles:importAttribute name="title" scope="page" toName="tilesTitle" />
	  <title><spring:message code="${tilesTitle}" /></title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <%-- favicon --%>
	  <link rel="icon" type="image/x-icon" href="<c:url value="/resources/images/camera.png"/>">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <link rel="stylesheet" href="<c:url value="/resources/css/basicLayout.css"/>">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  <script src="<c:url value="/resources/js/basicLayout.js"/>" type="text/javascript"></script>
	  <tiles:insertAttribute name="pagescript" />
	</head>

	<img src="<c:url value="/resources/images/ajaxLoader.gif"/>" id="loading-indicator" title="<spring:message code="loading.label" />"/>
	
	<body>

        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="body" />
        <tiles:insertAttribute name="footer" />
        
    </body>
</html>