<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%@ include file="header.jsp" %> 

<div class="h-200 d-flex align-items-center justify-content-center" style="padding-top:20px">
  
    <form name="form">
  

  <input type = text>
  <input class="btn btn-primary" type="submit" value=<spring:message code="welcome.pay" text="default"/> onclick="javascript: form.action='/taxing';">
  <br>
  <br>
  <input type = text>
  <input class="btn btn-success" type="submit" value=<spring:message code="welcome.zonal" text="default"/> onclick="javascript: form.action='/reports';"> 

</form>
</div>
	


</body>
</html>