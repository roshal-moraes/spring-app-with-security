<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
	<title>Add task</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-todo-style.css">
</head>

<body>
	
	<div id="wrapper" align="center">
		<div id="header">
			<h2 align="center">Add/Update Tasks</h2>
			
			<h4  style="display:inline; margin-right: 65%"><security:authentication property="principal.username" />
			
			</h4>
			<p  style="display:inline" >
			<a href="${pageContext.request.contextPath}/" align = "right">Back to List</a>
			</p>
			
			<form:form action = "${pageContext.request.contextPath}/logout" method = "POST">
			<input type =  "submit" value="Logout" id="logout-button"/>
			
			</form:form>
			
			
			
			
		</div>
	</div>

	<div id="container">
		
	
		<form:form action="saveTask" modelAttribute="task" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table align="center">
				<tbody align = "right">
					<tr>
						<td><label>Task Description:</label></td>
						<td><form:input path="comment" /></td>
					</tr>
				
					<tr align="center">
						<td><label>Status:</label></td>
						<td><form:input path="status" /></td>
					</tr>

					

					<tr align="center">
						<td style="width: 1%"><label></label></td>
						<td style="width: 99%"><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		
	
	</div>

</body>

</html>










