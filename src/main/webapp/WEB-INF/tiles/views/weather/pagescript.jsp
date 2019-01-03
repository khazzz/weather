<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="/resources/css/weather.css">
<script language="JavaScript">
	var failedToGetDataLabel = '<spring:message code="error.failed.to.get.weather.data" text="Failed to get weather data"/>';
</script>
<script src="<c:url value="/resources/js/weather.js"/>" type="text/javascript"></script>