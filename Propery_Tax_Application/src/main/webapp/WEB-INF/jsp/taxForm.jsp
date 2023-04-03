<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Welcome</title>
<style>  
.error{color:red}  
</style>  
</head>
<body>
<%@ include file="header.jsp" %>  
<div class="d-flex justify-content-center align-items-center" style="padding-top:90px; border:double">

<form:form action="savetax" modelAttribute="taxForm" style="border:double; background-color:orange" >
<h3 class="d-flex justify-content-center align-items-center"><spring:message code="taxform.tax" text="default"/></h3>
<table>
	<tr>
		<td>Year</td>
		<td><form:input path="year" size="30" placeholder="Enter year"/>
		<form:errors path="year" cssClass="error"/>
		</td>
		
	</tr>
	<tr>
		<td>name</td>
		<td><form:input path="name" size="30" placeholder="Enter your name"/>
		<form:errors path="name" cssClass="error"/></td>
		
	</tr>
	
	<tr>
		<td>email</td>
		<td><form:input path="email" size="30" placeholder="Enter your mail"/>
		<form:errors path="email" cssClass="error"/></td>
		
	</tr>
	
	<tr>
		<td>address</td>
		<td><form:textarea path="address" size="30" rows="5" cols="30"/><form:errors path="address" cssClass="error"/></td>
		
	</tr>
	
	<tr>
		<td>zone</td>
		<td><form:select path="zone" id="zone" >
		<form:option value="">Select an Option</form:option>
		<form:option value="1">Zone A</form:option>
		<form:option value="2">Zone B</form:option>
		<form:option value="3">Zone C</form:option>
		</form:select>
		<form:errors path="zone" cssClass="error"/>
		</td>
	</tr>
	
	<tr>
		<td>description</td>
		<td><form:select path="description" id="description">
		<form:option value="">Select an Option</form:option>
		<form:option value="1">RCC Buildings</form:option>
		<form:option value="2">RCC buildings with cement or red-oxide flooring</form:option>
		<form:option value="3">Tiled/Sheet of all kinds</form:option>
		</form:select>
		<form:errors path="description" cssClass="error"/></td>
		
	</tr>
	<tr>
		<td>status</td>
		<td><form:select path="status" id="status" >
		<form:option value="">Select an Option</form:option>
		<form:option value="1">owner</form:option>
		<form:option value="2">tentated</form:option>
		
		</form:select>
		<form:errors path="status" cssClass="error"/>
		</td>
	</tr>
	
	<tr>
		<td>ConstructedYear</td>
		<td><form:input path="constructedYear" size="30" id="constructedyear" placeholder="Enter constucted year"/>
		<form:errors path="constructedYear" cssClass="error"/></td>
		
	</tr>
	
	<tr>
		<td>area in ft</td>
		<td><form:input path="area" size="30" id="area" placeholder="Enter area"/><form:errors path="area" cssClass="error"/></td>
		
	</tr>
	<tr>
		<td>tax</td>
		<td><form:input path="tax" size="30" value="" id="tax" readonly="true"/>
		<input type="button" value="calculate" id="calculate" class="btn btn-success" >
		<form:errors path="tax" Class="error"/></td>

		
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="submit" class="btn btn-primary">
		
		
	</tr>
	
	
	
</table>
</form:form>
<form name="form">
  <input class="btn btn-primary" type="submit" value="Cancel" onclick="javascript: form.action='/login';">
   

</form>
</div>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">


     $('#calculate').click(function(){
         var status_id = $('#status').val();
         var description_id = $('#description').val();
         var zone_id=$('#zone').val();
         var area=$('#area').val();
         var constructedyear=$('#constructedyear').val();
         $.ajax({
             type:'GET',
             data: {
                 status_id: status_id,
				description_id:description_id,
				zone_id:zone_id,
				area:area,
				constructedyear:constructedyear,
                 action: 'demo2'
             },
             url:'AjaxController',
             success : function(result){
                 $('#tax').val(result);

             }

         });
     }); 
	



</script>

</body>
</html>
