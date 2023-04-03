<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %> 
<h3 class="d-flex justify-content-center align-items-center"><spring:message code="zonal.heading" text="default"/></h3>
<table class="table table-striped">
<thead>
<tr >
   <th >ZONES</th>
   <th >STATUS</th>
   <th >TOTAL</th>

</tr>
</thead>
<tbody>
<c:forEach items="${all}" var="al">

<tr>
     <td ><c:out value="${al.zoneName}" /></td>
     <td ><c:out value="${al.statusName}" /></td>
     <td ><c:out value="${al.total}" /></td>
    
    

</tr>
</c:forEach>
</tbody>

</table>
</body>
</html>